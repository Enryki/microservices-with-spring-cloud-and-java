package br.com.erudio.math_api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.math_api.exception.UnsupportedMathOperationException;
import br.com.erudio.math_api.math.SimpleMath;
import br.com.erudio.math_api.request.NumberConverter;


@RequestMapping("/math")
@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");
                
        return math.sum( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");

        return math.subtraction( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");

        return math.multiplication( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        if(Double.parseDouble(numberTwo) == 0)
            throw new UnsupportedMathOperationException("You cannot divide by 0.");

        return math.division( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
        @PathVariable("numberOne") String numberOne, 
        @PathVariable("numberTwo") String numberTwo
    )throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");

        return math.average( NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/root/{numberOne}")
    public Double root(
        @PathVariable("numberOne") String number 
    )throws Exception{
        if(!NumberConverter.isNumeric(number)) 
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        return math.root( NumberConverter.convertToDouble(number));
    }




    
    

}
