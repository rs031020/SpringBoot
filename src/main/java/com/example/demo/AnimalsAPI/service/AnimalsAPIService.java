package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.AnimalsAPI;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {

	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	//getAnimalsの配列メソッドを定義
	public List<AnimalsAPI> getAnimals() throws IOException {

		//SampleAPIRepository.javaからデータを取得してanimalsLists配列に格納
		AnimalsAPI[] animalsListService = animalsAPIRepository.getAnimals();

		//animalsListsをリストとして返す(Arrays.asList)
		return Arrays.asList(animalsListService);

	}

	public List<AnimalsAPI> getAnimalsDetail(int id) throws IOException {
		AnimalsAPI[] animalsListDetail = animalsAPIRepository.getAnimalsDetail(id);


		return Arrays.asList(animalsListDetail);
	}
}