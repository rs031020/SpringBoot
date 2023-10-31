package com.example.demo.fizzbuzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzbuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {

	private final FizzBuzzService fizzbuzzService; //serviseファイルのFizzBuzzServicesをfizzbuzzserviceという定数に定義している

	public FizzBuzzController(FizzBuzzService fizzbuzzService) { //コンストラクタを定義	
		this.fizzbuzzService = fizzbuzzService;
	}

	@GetMapping("fizzbuzz") //URLパス
	public String fizzBuzzService(Model model) { //HTMLファイルに引数を渡すための変数（model)
		String list[] = FizzBuzzService.fizzbuzzService().toArray(new String[FizzBuzzService.fizzbuzzService().size()]);
		//Serviceクラスで作成したListを配列に変換（toArray）
		//.size　配列の要素を一つづつ取得
		model.addAttribute("list", list); //controllerとserviceのlistを結ぶ
		return "fizzBuzz.html"; //HTMLに反映
	}
}