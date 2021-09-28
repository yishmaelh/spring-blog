package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;


@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollGuess(@PathVariable int n, Model model){

        Random rand = new Random();
        int randomNumber = rand.nextInt(6-1 + 1) + 1;

        model.addAttribute("diceRoll", randomNumber);
        model.addAttribute("userGuess", n);
        model.addAttribute("isCorrect", randomNumber == n);

        return "roll-dice";
    }
}
