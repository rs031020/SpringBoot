//パッケージ宣言
package com.example.demo.controller;

//異なるパッケージ内にあるクラスを利用する場合の読み込み
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	//アノテーション：Java開発でのアノテーションはコードに注釈として補足を加えることで、
	//プログラムの動作を変更したり、開発時のルールを統一できたり、
	//フレームワークに処理を指示したりできる仕組みのこと
	@GetMapping("hello")
	
	//Greetingメソッドを実行するとindex.htmlがretrnされる
	public String greeting() {
		return "index.html";
	}

}
