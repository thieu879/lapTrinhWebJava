package com.example.ss8.controller.bt8;
import com.example.ss8.model.bt8.Seed;
import com.example.ss8.model.bt8.User;
import com.example.ss8.model.bt8.WarehouseSeeds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/GameController")
public class GameController {

    private List<User> users = new ArrayList<>();
    private List<Seed> seeds = new ArrayList<>();
    private List<WarehouseSeeds> warehouse = new ArrayList<>();
    private User loggedInUser;
    private String[] farm = new String[20]; // Giả sử trang trại có 20 ô đất

    public GameController() {
        // Initialize seeds, warehouse, etc.
        seeds.add(new Seed(1, "Tomato", 100.0, "https://example.com/tomato.jpg"));
        seeds.add(new Seed(2, "Carrot", 50.0, "https://example.com/carrot.jpg"));
        seeds.add(new Seed(3, "Cucumber", 70.0, "https://example.com/cucumber.jpg"));

        warehouse.add(new WarehouseSeeds(1, 10, seeds.get(0))); // 10 hạt giống cà chua
        warehouse.add(new WarehouseSeeds(2, 5, seeds.get(1)));  // 5 hạt giống cà rốt
        warehouse.add(new WarehouseSeeds(3, 0, seeds.get(2)));  // 0 hạt giống dưa chuột
    }

    @GetMapping("/register")
    public String showRegister() {
        return "/bt8/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        User newUser = new User(users.size() + 1, username, password, email);
        users.add(newUser);
        return "redirect:/GameController/login"; // Redirect to login after registration
    }

    @GetMapping("/login")
    public String showLogin() {
        return "/bt8/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return "redirect:/GameController/farm"; // Redirect to farm after successful login
            }
        }
        return "/bt8/login?error=true"; // Show error if login fails
    }

    @GetMapping("/shop")
    public String showShop(Model model) {
        if (loggedInUser == null) {
            return "redirect:/GameController/login"; // Redirect to login if not logged in
        }
        model.addAttribute("seeds", seeds);
        return "/bt8/shop";
    }
    @GetMapping("/warehouse")
    public String showWarehouse(Model model) {
        model.addAttribute("warehouse", warehouse);
        return "/bt8/warehouse";
    }
    @PostMapping("/buySeed")
    public String buySeed(@RequestParam int seedId, @RequestParam int quantity) {
        if (loggedInUser == null) {
            return "redirect:/GameController/login"; // Ensure the user is logged in
        }

        Seed selectedSeed = null;
        for (Seed seed : seeds) {
            if (seed.getId() == seedId) {
                selectedSeed = seed;
                break;
            }
        }

        if (selectedSeed != null && loggedInUser.getBalance() >= selectedSeed.getPrice() * quantity) {
            loggedInUser.setBalance(loggedInUser.getBalance() - selectedSeed.getPrice() * quantity);
            boolean seedExists = false;
            for (WarehouseSeeds ws : warehouse) {
                if (ws.getSeed().getId() == seedId) {
                    ws.setQuantity(ws.getQuantity() + quantity);
                    seedExists = true;
                    break;
                }
            }
            if (!seedExists) {
                warehouse.add(new WarehouseSeeds(warehouse.size() + 1, quantity, selectedSeed));
            }
        }
        return "redirect:/GameController/shop"; // Redirect back to the shop
    }

    @GetMapping("/farm")
    public String showFarm(Model model) {
        if (loggedInUser == null) {
            return "redirect:/GameController/login"; // Ensure the user is logged in
        }
        model.addAttribute("warehouse", warehouse);
        model.addAttribute("farm", farm);
        model.addAttribute("seeds", seeds);
        return "/bt8/farm";
    }

    @PostMapping("/plantSeed")
    public String plantSeed(@RequestParam int plotId, @RequestParam int seedId) {
        if (loggedInUser == null) {
            return "redirect:/GameController/login"; // Ensure the user is logged in
        }

        if (plotId < 1 || plotId > 20) {
            return "redirect:/GameController/farm?error=true"; // Validate plot ID
        }

        if (farm[plotId - 1] != null) {
            return "redirect:/GameController/farm?error=occupied"; // Ensure the plot is empty
        }

        boolean hasSeed = false;
        for (WarehouseSeeds ws : warehouse) {
            if (ws.getSeed().getId() == seedId && ws.getQuantity() > 0) {
                farm[plotId - 1] = "Seed " + seedId;
                ws.setQuantity(ws.getQuantity() - 1);
                hasSeed = true;
                break;
            }
        }

        if (!hasSeed) {
            return "redirect:/GameController/farm?error=no-seed"; // Show error if no seed is available
        }

        return "redirect:/GameController/farm"; // Redirect back to farm page
    }
}

