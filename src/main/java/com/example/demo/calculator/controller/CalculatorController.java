package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) { //コンストラクタを定義	
		this.calculatorService = calculatorService;
	}

	//GETリクエストとURLとコントローラーのクラスまたはメソッドを紐づける。
	@GetMapping("calculator")
	//doGetパラメーターを取得
	public String doGet() {
		return "calculator.html";
	}

	//入力された値を受け取り結果を返す
	@PostMapping("calculator")
	//RequestParam　画面で入力した値を受け取り、left変数でその値を受け取る。
	public String doPost(
			@RequestParam("left") int left,
			@RequestParam("right") int right,
			@RequestParam("calculator") String opelator,
			Model model) {
		//Serviceクラスのcalculatorメソッドに値を渡す
		String result = String.valueOf(calculatorService.calculator(left, right, opelator));

		model.addAttribute("result", result);

		return "calculator.html";
	}
}
