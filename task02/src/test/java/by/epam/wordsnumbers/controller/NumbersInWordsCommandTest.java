package by.epam.wordsnumbers.controller;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumbersInWordsCommandTest {
    public NumbersInWordsCommand numbersInWordsCommand = new NumbersInWordsCommand();

    @Test
    public void testReturnNumbersInWords9999() {
        String numbersInWords = "девять тысяч девятьсот девяносто девять рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(9999));
    }

    @Test
    public void testReturnNumbersInWords9100() {
        String numbersInWords = "девять тысяч сто рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(9100));
    }

    @Test
    public void testReturnNumbersInWords9000() {
        String numbersInWords = "девять тысяч рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(9000));
    }

    @Test
    public void testReturnNumbersInWords4321() {
        String numbersInWords = "четыре тысячи триста двадцать один рубль";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(4321));
    }


    @Test
    public void testReturnNumbersInWords1011() {
        String numbersInWords = "одна тысяча одиннадцать рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(1011));
    }

    @Test
    public void testReturnNumbersInWords1001() {
        String numbersInWords = "одна тысяча один рубль";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(1001));
    }

    @Test
    public void testReturnNumbersInWords1000() {
        String numbersInWords = "одна тысяча рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(1000));
    }

    @Test
    public void testReturnNumbersInWords889() {
        String numbersInWords = "восемьсот восемьдесят девять рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(889));
    }

    @Test
    public void testReturnNumbersInWords101() {
        String numbersInWords = "сто один рубль";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(101));
    }

    @Test
    public void testReturnNumbersInWords200() {
        String numbersInWords = "двести рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(200));
    }

    @Test
    public void testReturnNumbersInWords17() {
        String numbersInWords = "семнадцать рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(17));
    }

    @Test
    public void testReturnNumbersInWords0000() {
        String numbersInWords = "ноль рублей";
        Assert.assertEquals(numbersInWords, numbersInWordsCommand.returnNumbersInWords(0000));
    }
}