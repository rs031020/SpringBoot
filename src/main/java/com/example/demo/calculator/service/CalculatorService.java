package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculator(int left, int right, String operator) {
		String ope = operator;
		int result = 0;
		switch (ope) {
		case "plus":
			result = left + right;
			break;
		case "minus":
			result = left - right;
			break;
		case "hang":
			result = left * right;
			break;
		case "divide":
			result = left / right;
			break;
		}
		return result;
	}
}