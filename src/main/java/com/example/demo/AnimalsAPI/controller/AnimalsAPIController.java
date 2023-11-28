package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.AnimalsAPI;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	//serviceクラスを定数で定義
	private final AnimalsAPIService animalsAPIService;

	//メソッドを定義（引数はserviceクラスので取得できる値）
	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalserch")
	public String getPets(Model model) throws IOException {

		//APIの動物のデータ全てを取得
		List<AnimalsAPI> animalsListController = animalsAPIService.getAnimals();
		//		System.out.println(animalsListCntl);

		//取得した動物データをビューに渡す
		model.addAttribute("animalsListController", animalsListController);

		//htmlに反映
		return "animalserch.html";

	}

	@PostMapping("animaldetail")
	//RequestParam　パラメーターを取得（ここではid）
	public String postPetsDetail(@RequestParam int id, Model model) throws IOException {

		//詳細のAPIデータをリストで取得
		List<AnimalsAPI> animalsDetail = animalsAPIService.getAnimalsDetail(id);
		System.out.println(animalsDetail);
		model.addAttribute("animalsDetail", animalsDetail);

		return "animaldetail.html";
	}

}