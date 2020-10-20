package by.barzov.springcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) String a,
                            @RequestParam(value = "b", required = false) String b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {

        Integer answer = 0;
        if ("multiplication".equals(action)) {
            answer = Integer.parseInt(a) * Integer.parseInt(b);
        } else if ("addition".equals(action)) {
            answer = Integer.parseInt(a) + Integer.parseInt(b);
        } else if ("subtraction".equals(action)) {
            answer = Integer.parseInt(a) - Integer.parseInt(b);
        } else if ("division".equals(action)) {
            answer = Integer.parseInt(a) / Integer.parseInt(b);
        }

        model.addAttribute("answer", answer.toString());

        return "/calculator/calc";
    }
}
