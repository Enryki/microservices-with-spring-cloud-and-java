package br.com.erudio.math_api.request;

import br.com.erudio.math_api.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String number){
        if(!isNumeric(number) || number.isEmpty()) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strnumber) {
        if (strnumber == null || strnumber.isEmpty()) return false;

        String number = strnumber.replace(",", ".");

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
