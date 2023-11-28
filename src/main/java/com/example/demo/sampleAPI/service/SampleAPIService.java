package com.example.demo.sampleAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sampleAPI.data.Animals;
import com.example.demo.sampleAPI.repository.SampleAPIRepository;

@Service
public class SampleAPIService {

	private final SampleAPIRepository sampleAPIRepository;

	public SampleAPIService(SampleAPIRepository sampleAPIRepository) {
		this.sampleAPIRepository = sampleAPIRepository;
	}
	//getAnimalsの配列メソッドを定義
	public List<Animals> getAnimals() throws IOException {

		//SampleAPIRepository.javaからデータを取得してanimalsLists配列に格納
		Animals[] animalsList = sampleAPIRepository.getAnimals();

		//anmalsListsをリストとして返す(Arrays.asList)
		return Arrays.asList(animalsList);

	}
}