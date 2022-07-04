package tw.com.finalproj.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping( path = {"/public/api"}	)
public class Linepaycontroller {

//	
//	@PostMapping("/products")
//	public ResponseEntity<?> create(@RequestBody String body) {
////		新增：POST message body包含需要新增的resource資料
////		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
////		失敗：204 (No Content)
//		JSONObject data=new JSONObject(); 
//		data.put("amount", 200);
//		data.put("productName", "ithome");
//		data.put("productImageUrl","https://ithelp.ithome.com.tw/images/ironman/11th/event/kv_event/kv-bg-addfly.png");
//		data.put("confirmUrl", "http://127.0.0.1:3000");
//		data.put("orderId", "1111111231323333323qwd22qdq");
//		data.put("currency", "TWD");
//
//		
//		
//		if(data!=null) {
//			URI uri = "https://sandbox-api-pay.line.me/v2/payments/request
//			ResponseEntity<ProductBean> entity = ResponseEntity.created(uri).body(insert);
//			return entity;
//		} else {
//			ResponseEntity<?> entity = ResponseEntity.noContent().build();
//			return entity;
//		}
//	}
	
	
	
	
}
