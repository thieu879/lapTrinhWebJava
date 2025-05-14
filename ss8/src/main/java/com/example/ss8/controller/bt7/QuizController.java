package com.example.ss8.controller.bt7;
import com.example.ss8.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class QuizController {

    private final List<Question> questions = Arrays.asList(
            new Question(1, "https://th.bing.com/th/id/R.cb001dac88c5c718803b743f2185a9c5?rik=%2fmDLuxGTVhiInA&pid=ImgRaw&r=0", "apple"),
            new Question(2, "https://tse1.mm.bing.net/th/id/OIP.KdRE7KHqL-46M8nrvOX2CgHaHa?cb=iwc2&rs=1&pid=ImgDetMain", "cat"),
            new Question(3, "https://tse4.mm.bing.net/th/id/OIP.9d5H4h21eKw8UEg5inkU0QHaLH?cb=iwc2&rs=1&pid=ImgDetMain", "dog")
    );

    @GetMapping("/quiz")
    public String showQuiz(HttpSession session, Model model) {
        Question question = getRandomQuestion();
        session.setAttribute("question", question);
        session.setAttribute("attempts", 0);
        model.addAttribute("question", question);
        model.addAttribute("message", "");
        model.addAttribute("canGuess", true);
        return "/bt7/quiz";
    }

    @PostMapping("/guess")
    public String handleGuess(@RequestParam String userAnswer, HttpSession session, Model model) {
        Question question = (Question) session.getAttribute("question");
        int attempts = (int) session.getAttribute("attempts");

        if (question.getAnswer().equalsIgnoreCase(userAnswer.trim())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("canGuess", false);
        } else {
            attempts++;
            session.setAttribute("attempts", attempts);
            if (attempts >= 3) {
                model.addAttribute("message", " Bạn hết lượt đoán!");
                model.addAttribute("canGuess", false);
            } else {
                model.addAttribute("message", "Sai rồi! Còn " + (3 - attempts) + " lượt.");
                model.addAttribute("canGuess", true);
            }
        }

        model.addAttribute("question", question);
        return "/bt7/quiz";
    }

    private Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}

