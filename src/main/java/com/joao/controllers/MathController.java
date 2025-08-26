package com.joao.controllers;

import com.joao.exception.UnsupportedMathOperationException;
import com.joao.math.SimpleMath;
import com.joao.util.NumberUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.util.NumberUtils;
@RestController
@RequestMapping("/math")
public class MathController{

	private SimpleMath math = new SimpleMath();

	// http://localhost:8080/math/
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please" +
				" " +
				"set a " +
				"numeric value!");
		return math.sum(NumberUtils.convertToDouble(numberOne), NumberUtils.convertToDouble(numberTwo));
	}

	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable("numberOne") String numberOne,
							  @PathVariable("numberTwo") String numberTwo) throws Exception{
		if(!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a " +
				"numeric value!");
		return math.subtraction(NumberUtils.convertToDouble(numberOne), NumberUtils.convertToDouble(numberTwo));
	}

	@RequestMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable("numberOne") String numberOne,
								 @PathVariable("numberTwo") String numberTwo){
		if(!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a " +
				"numeric value!");
		return math.multiplication(NumberUtils.convertToDouble(numberOne), NumberUtils.convertToDouble(numberTwo));
	}

	@RequestMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable("numberOne") String numberOne,
								 @PathVariable("numberTwo") String numberTwo){
		if(!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a " +
				"numeric value!");
		return math.division(NumberUtils.convertToDouble(numberOne), NumberUtils.convertToDouble(numberTwo));
	}

	@RequestMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable("numberOne") String numberOne,
						   @PathVariable("numberTwo") String numberTwo){
		if(!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a " +
				"numeric value!");
		return math.mean(NumberUtils.convertToDouble(numberOne), NumberUtils.convertToDouble(numberTwo));
	}

	@RequestMapping("/squareRoot/{numberOne}")
	public Double squareRoot(@PathVariable("numberOne") String numberOne){
		if(!NumberUtils.isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a " +
				"numeric value!");
		return math.squareRoot(NumberUtils.convertToDouble(numberOne));
	}

}