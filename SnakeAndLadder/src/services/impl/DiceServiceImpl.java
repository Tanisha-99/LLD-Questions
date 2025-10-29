package services.impl;

import services.DiceService;

import java.util.Random;

public class DiceServiceImpl implements DiceService {
    Random rand = new Random();

    public int rollDice(int numberOfDices) {
        int maximum = numberOfDices * 6;
        int minimum = numberOfDices;

        int randomNumber = rand.nextInt((maximum - minimum) + 1) + minimum;

        return randomNumber;
    }
}
