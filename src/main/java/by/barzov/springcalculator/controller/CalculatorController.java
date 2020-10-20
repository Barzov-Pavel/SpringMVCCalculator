package by.barzov.springcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {

        double answer = 0;
        if ("multiplication".equals(action)) {
            answer = a * b;
        } else if ("addition".equals(action)) {
            answer = a + b;
        } else if ("subtraction".equals(action)) {
            answer = a - b;
        } else if ("division".equals(action)) {
            answer = a / (double)b;
        }

        model.addAttribute("answer", answer);

        return "/calculator/calc";
    }
}
