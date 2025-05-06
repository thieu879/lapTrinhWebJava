package com.example.ss2.bt9;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "WordGameServlet", value = "/WordGameServlet")
public class WordGameServlet extends HttpServlet {
    private static final ArrayList<String> secretWords = new ArrayList<>();
    private static final int MAX_ATTEMPTS = 3;
    public void init() {
        secretWords.add("hoa hong");
        secretWords.add("cay xanh");
        secretWords.add("meo con");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String secretWord = request.getParameter("secretWord");
        String attemptsLeftStr = request.getParameter("attemptsLeft");
        String gameStatus = request.getParameter("gameStatus");
        String gameOverStr = request.getParameter("gameOver");
        String wordIndexCounterStr = request.getParameter("wordIndexCounter");

        int wordIndexCounter;
        if (wordIndexCounterStr == null) {
            wordIndexCounter = 0;
        } else {
            wordIndexCounter = Integer.parseInt(wordIndexCounterStr);
        }

        if (secretWord == null) {
            wordIndexCounter = (wordIndexCounter + 1) % secretWords.size();
            secretWord = secretWords.get(wordIndexCounter);
            attemptsLeftStr = String.valueOf(MAX_ATTEMPTS);
            gameStatus = "";
            gameOverStr = "false";
        }

        int attemptsLeft = Integer.parseInt(attemptsLeftStr);
        boolean gameOver = Boolean.parseBoolean(gameOverStr);

        String wordHint = "";
        for (int i = 0; i < secretWord.length(); i++) {
            if (i % 2 == 0 && secretWord.charAt(i) != ' ') {
                wordHint = wordHint + "_ ";
            } else {
                wordHint = wordHint + secretWord.charAt(i) + " ";
            }
        }
        wordHint = wordHint.trim();

        request.setAttribute("wordHint", wordHint);
        request.setAttribute("attemptsLeft", attemptsLeft);
        request.setAttribute("gameStatus", gameStatus);
        request.setAttribute("gameOver", gameOver);
        request.setAttribute("secretWord", secretWord);
        request.setAttribute("wordIndexCounter", wordIndexCounter);

        request.getRequestDispatcher("/Bt/wordGame.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String secretWord = request.getParameter("secretWord");
        int attemptsLeft = Integer.parseInt(request.getParameter("attemptsLeft"));
        String gameStatus = request.getParameter("gameStatus");
        boolean gameOver = Boolean.parseBoolean(request.getParameter("gameOver"));
        int wordIndexCounter = Integer.parseInt(request.getParameter("wordIndexCounter"));

        if ("playAgain".equals(action)) {
            wordIndexCounter = (wordIndexCounter + 1) % secretWords.size();
            secretWord = secretWords.get(wordIndexCounter);
            attemptsLeft = MAX_ATTEMPTS;
            gameStatus = "";
            gameOver = false;
        } else {
            String guess = request.getParameter("guess");
            attemptsLeft = attemptsLeft - 1;

            if (guess != null && guess.equals(secretWord)) {
                gameStatus = "CHÚC MỪNG! Bạn đã đoán đúng từ: " + secretWord;
                gameOver = true;
            } else {
                if (attemptsLeft <= 0) {
                    gameStatus = "Bạn đã thua sau 3 lần đoán. Từ đúng là: " + secretWord;
                    gameOver = true;
                } else {
                    gameStatus = "Sai rồi! Hãy thử lại.";
                    gameOver = false;
                }
            }
        }

        String wordHint = "";
        for (int i = 0; i < secretWord.length(); i++) {
            if (i % 2 == 0 && secretWord.charAt(i) != ' ') {
                wordHint = wordHint + "_ ";
            } else {
                wordHint = wordHint + secretWord.charAt(i) + " ";
            }
        }
        wordHint = wordHint.trim();

        request.setAttribute("wordHint", wordHint);
        request.setAttribute("attemptsLeft", attemptsLeft);
        request.setAttribute("gameStatus", gameStatus);
        request.setAttribute("gameOver", gameOver);
        request.setAttribute("secretWord", secretWord);
        request.setAttribute("wordIndexCounter", wordIndexCounter);

        request.getRequestDispatcher("/Bt/wordGame.jsp").forward(request, response);
    }

    public void destroy() {
    }
}