package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {
	private final MinusService minusService;

	public MinusController(MinusService minusService) { //コンストラクタを定義	
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String doGet() {
		return "minus.html";
	}

	@PostMapping("minus")
	public String doPost(@RequestParam("left") int left, @RequestParam("right") int right, Model model) {
		//RequestParam　画面で入力した値を受け取り、left変数でその値を受け取る。
		String result = String.valueOf(minusService.minus(left, right));
		model.addAttribute("result", result);

		return "minus.html";
	}
}
