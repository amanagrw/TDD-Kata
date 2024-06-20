package org.example;

public class Main {
    public static void main(String[] args) {

        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.Add(""));
        System.out.println(calculator.Add("1"));
        System.out.println(calculator.Add("1,2"));
        System.out.println(calculator.Add("1\n2,3"));
        System.out.println(calculator.Add("//;\n1;2"));
        System.out.println(calculator.Add("//[***]\n1***2***3"));
        System.out.println(calculator.Add("//[*][%]\n1*2%3"));
        System.out.println(calculator.Add("//[**][%%]\n1**2%%3"));
        System.out.println(calculator.Add("2,1001"));
    }
}