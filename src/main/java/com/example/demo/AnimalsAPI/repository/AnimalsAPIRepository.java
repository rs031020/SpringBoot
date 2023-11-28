package com.example.demo.AnimalsAPI.repository;

//java.io　＝　システム入出力に使うクラス、インターフェース等が提供されているパッケージ
//IOException = 入出力処理中の例外を管理するクラス　あとで消せる?
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AnimalsAPI.data.AnimalsAPI;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsAPIRepository {

	public AnimalsAPI[] getAnimals() throws IOException {

		String serchUrl = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi";

		//RestTemplate=APIを呼び出すメソッド
		RestTemplate rest = new RestTemplate();

		//ResponsEntity =ステータスコード・ヘッダー・本文のこと
		//getForEntity=URLからエンティティ（箱：ここではURLのHTMLの全容かな？）を取得
		ResponseEntity<String> response = rest.getForEntity(serchUrl, String.class);

		//レスポンスボディ（中身）を取得
		String json = response.getBody();

		//ObjectMapper=JavaのオブジェクトとJson間の変換をする
		ObjectMapper mapper = new ObjectMapper();

		//readValue：JSON→オブジェクトへ変換して　javaファイルで使えるようにする
		AnimalsAPI[] animalsListRepository = mapper.readValue(json, AnimalsAPI[].class);

		return animalsListRepository;

	}

	public AnimalsAPI[] getAnimalsDetail(int id) throws IOException {
		String detailUrl = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/sampleapi?id=" + id;

		//RestTemplate=APIを呼び出すメソッド
		RestTemplate detailRest = new RestTemplate();

		//ResponsEntity =ステータスコード・ヘッダー・本文のこと
		//getForEntity=URLからエンティティ（箱：ここではURLのHTMLの全容かな？）を取得
		ResponseEntity<String> detailResponse = detailRest.getForEntity(detailUrl, String.class);

		//レスポンスボディ（中身）を取得
		String detailjson = detailResponse.getBody();

		//ObjectMapper=JavaのオブジェクトとJson間の変換をする
		ObjectMapper detailMapper = new ObjectMapper();

		//readValue：JSON→オブジェクトへ変換して　javaファイルで使えるようにする
		AnimalsAPI[] animalsListDetail = detailMapper.readValue(detailjson, AnimalsAPI[].class);

		return animalsListDetail;

	}

}