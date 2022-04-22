package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class DiceController {
    @RequestMapping(path = "/roll-dice", method = RequestMethod.GET)
    public String rollDice() {
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
    public String diceRollGuess(@PathVariable String n, Model model) {
        int guessedNumber = Integer.parseInt(n);
        ArrayList<Integer> rolledNumbers = new ArrayList<>();
        for (int i = 0; i < 600; i++) {
            rolledNumbers.add((int) Math.floor(Math.random() * 6 + 1));
        }
        int correctGuess = 0;
        for (int number : rolledNumbers) {
            if (number == guessedNumber) {
                correctGuess++;
            }
        }
        model.addAttribute("guessedNumber", guessedNumber);
        model.addAttribute("rolledNumbers", rolledNumbers);
        model.addAttribute("diceCount", rolledNumbers.size());
        model.addAttribute("correctCount", correctGuess);
        return "roll-dice";
    }
}