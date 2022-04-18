package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "{operation}/{a}/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String math(@PathVariable String operation, @PathVariable String a, @PathVariable String b) {
        try {
            double firstNumber = Double.parseDouble(a);
            double secondNumber = Double.parseDouble(b);
            switch (operation) {
                case "add":
                    return Double.toString(firstNumber + secondNumber);
                case "subtract":
                    return Double.toString(firstNumber - secondNumber);
                case "multiply":
                    return Double.toString(firstNumber * secondNumber);
                case "divide":
                    return Double.toString(firstNumber / secondNumber);
                default:
                    return "Invalid operation.";
            }
        } catch (NumberFormatException e) {
            return "Invalid operands.";
        }
    }
}
