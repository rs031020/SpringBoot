//パッケージの読み込み
package multi.controller;

//外部のアノテーションを読み込み
import org.springframework.stereotype.Controller; //modelとviewの仲介
import org.springframework.ui.Model; //データの取得
import org.springframework.web.bind.annotation.GetMapping; //HTTPリクエストのGETメソッドを受け付ける

import multi.service.MultiService; //serviceファイルのMultiService　ファイルを読み込む

@Controller
public class MultiController { //アノテーションを付与することで、このクラスをcontrollerとして認識する

	private final MultiService multiService; //serviseファイルのMultiServicesをmultiserviceという定数に定義している

	public MultiController(MultiService multiService) { //コンストラクタを定義	
		this.multiService = multiService;
	}

//HTTPリクエストのGETメソッドを受け付けるとメソッドを実行する
	@GetMapping("multi")
	public String multi(Model model) { //multiメソッドを定義

		String result = ""; //空の変数を定義

		result = String.valueOf(multiService.multi(5, 6)); //数値を文字列へ変換

		model.addAttribute("result", result); //controllerとserviceのresultを結びつける

		return "multi.html"; //HTMLに反映
	}

}