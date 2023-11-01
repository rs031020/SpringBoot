package com.example.demo.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

	public List<String> fizzbuzzService() { //fizzbuzzServiceメソッドを定義
		List<String> fizzbuzz = new ArrayList<>(); //オブジェクトを生成
		for (int i = 1; i <= 100; i++) { //処理
			if (i % 3 == 0 && i % 5 == 0) {
				fizzbuzz.add("FizzBuzz");
			} else if (i % 3 == 0) {
				fizzbuzz.add("Fizz");
			} else if (i % 5 == 0) {
				fizzbuzz.add("Buzz");
			} else {
				String number = String.valueOf(i);
				fizzbuzz.add(number);
			}
		}
		return fizzbuzz; //fizzbuzzオブジェクトを返す
	}
}