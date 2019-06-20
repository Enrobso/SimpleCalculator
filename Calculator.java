import javax.swing.JOptionPane;

/*
This is version 2 of simple calculator. I wish to add more functionality.
Title: Calculator
Author: Ephream Osborne
Last Update: 20/6/2019
 */

public class Calculator {
    private static String expressionToCalculate;
    private static double numberOne = 0, numberTwo = 0, total = 0;
    private static String num1,num2;

    public static void main(String [] args){
        //User enters expression.
        expressionToCalculate = JOptionPane.showInputDialog("Enter expression below:");
        expressionToCalculate = expressionToCalculate.replaceAll(" ", "");

        //Now determine what expression is.
        //First- is there */+-
        //Second- is there !^
        boolean divide = expressionToCalculate.contains("/");
        boolean multiply = expressionToCalculate.contains("*");
        boolean add = expressionToCalculate.contains("+");
        boolean subtract = expressionToCalculate.contains("-") && (expressionToCalculate.lastIndexOf("-") != 0);

        if (divide || multiply || add || subtract){
            if (divide){
                num1 = expressionToCalculate.substring(0,expressionToCalculate.indexOf("/"));
                numberOne = factorialOrPower(num1);
                num2 = expressionToCalculate.substring(expressionToCalculate.indexOf("/")+1);
                numberTwo = factorialOrPower(num2);
                total = numberOne / numberTwo;
            }
            else if (multiply){
                num1 = expressionToCalculate.substring(0,expressionToCalculate.indexOf("*"));
                numberOne = factorialOrPower(num1);
                num2 = expressionToCalculate.substring(expressionToCalculate.indexOf("*")+1);
                numberTwo = factorialOrPower(num2);
                total = numberOne * numberTwo;
            }
            else if (add){
                num1 = expressionToCalculate.substring(0,expressionToCalculate.indexOf("+"));
                numberOne = factorialOrPower(num1);
                num2 = expressionToCalculate.substring(expressionToCalculate.indexOf("+")+1);
                numberTwo = factorialOrPower(num2);
                total = numberOne + numberTwo;
            }
            else if (subtract){
                num1 = expressionToCalculate.substring(0,expressionToCalculate.lastIndexOf("-"));
                numberOne = factorialOrPower(num1);
                num2 = expressionToCalculate.substring(expressionToCalculate.lastIndexOf("-")+1);
                numberTwo = factorialOrPower(num2);
                total = numberOne - numberTwo;
            }
        }
        else{
            total = factorialOrPower(expressionToCalculate);
        }
        JOptionPane.showMessageDialog(null,total);
        System.exit(0);
    }
    //All numbers run through this method. It checks if there is a power or factorial.
    //If there is not, the string expression is parsed as normal.
    public static double factorialOrPower(String expression){
        double checkForFacPow = 0;
        boolean hasFacOrPow = expression.contains("!") || expression.contains("^");
        if (hasFacOrPow) {
            if(expression.contains("!")){
                checkForFacPow = Double.parseDouble(expression.substring(0,expression.indexOf("!")));
                int isNegNum = 0;
                if (checkForFacPow < 0) {
                    checkForFacPow = -checkForFacPow;
                    isNegNum = 1;
                }
                int facNum = 1;
                for(int i = (int)(Math.round(checkForFacPow)); i > 0; i--){
                    facNum *= i;
                }
                checkForFacPow = facNum;
                if (isNegNum == 1)
                    checkForFacPow = -checkForFacPow;
            }
            else{
                double firstNum = Double.parseDouble(expression.substring(0,expression.indexOf("^")));
                double secondNum = Double.parseDouble(expression.substring(expression.indexOf("^")+1));
                checkForFacPow = Math.pow(firstNum,secondNum);
            }
        }
        else{
            checkForFacPow = Double.parseDouble(expression);
        }
       return checkForFacPow;
    }

}
