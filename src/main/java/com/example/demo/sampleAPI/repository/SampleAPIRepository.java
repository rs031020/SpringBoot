package com.example.demo.sampleAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SampleAPIRepository {

	public Animals[] getAnimals() throws IOException {

		String url = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

		RestTemplate rest = new RestTemplate();

		//URLからエンティティ（箱：ここではURLのHTMLの全容かな？）を取得
		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		//レスポンスボディ（中身）を取得
		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		//readValue：JSON→オブジェクトへ変換
		Animals[] animalsList = mapper.readValue(json, Animals[].class);

		return animalsList;
	}

}