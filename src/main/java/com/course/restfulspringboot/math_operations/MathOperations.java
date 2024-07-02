package com.course.restfulspringboot.math_operations;

import org.springframework.stereotype.Component;



@Component //configurando a MathOperations para ser uma bean do spring, assim eu consigo usar injeção de dependência
public class MathOperations {

    public Double sum(String num1, String num2) {
        return convertToDouble(num1) + convertToDouble(num2);
    }

    public Double minus(String num1, String num2) {
        return convertToDouble(num1) - convertToDouble(num2);
    }

    public Double division(String num1, String num2) {
        return convertToDouble(num1) / convertToDouble(num2);
    }

    public Double average(String num1, String num2) {
        return (convertToDouble(num1) / convertToDouble(num2)) / 2;
    }

    public Double square(String num1) {
        return java.lang.Math.sqrt(convertToDouble(num1));
    }

    private Double convertToDouble(String strNumber) {
        String strReplaced = strNumber.replaceAll(",", ".");
        if(isNumeric(strReplaced)) return Double.parseDouble(strReplaced);
        return 0D; //0.0
    }
    
    public boolean isNumeric(String strNumber) {
        if(strNumber == null) throw new RuntimeException("Set a not null value!");
        try {
            Double.parseDouble(strNumber);
        }
        catch(NumberFormatException e) { //exceção lançada quando uma operação de conversão de dados falha.
            throw new RuntimeException("Set a valid numeric value!");
        }
        return true;
    }
}
