package tw.com.finalproj.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.finalproj.service.OrdersService;
import tw.com.finalproj.service.domain.OrdersBean;

@RestController
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@GetMapping(path = {"/backstage/pages/orders"})	
	public ResponseEntity<List<OrdersBean>> findAll() {
//		成功：200 (OK)、message body包含所有resource資料
		List<OrdersBean> beans = ordersService.select(null);
		return ResponseEntity.ok().body(beans);
	}
	
	@PostMapping("/backstage/pages/ordersinsert")
	public ResponseEntity<?> create(@RequestBody String body) {
//		新增：POST message body包含需要新增的resource資料
//		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
//		失敗：204 (No Content)
		JSONObject jsonObj = new JSONObject(body);
		
		int orderid = 0;
		try {
			String id = jsonObj.getString("orderid");
			orderid = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date orderdate = null;
		try {
			String ordertime = jsonObj.getString("ordertime");
			orderdate = new SimpleDateFormat("yyyy-MM-dd").parse(ordertime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date orderenddate = null;
		try {
			String orderendtime = jsonObj.getString("orderendtime");
			orderenddate = new SimpleDateFormat("yyyy-MM-dd").parse(orderendtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		OrdersBean bean = new OrdersBean();
		bean.setOrderid(orderid);
		bean.setUseraccount(jsonObj.getString("useraccount"));
		bean.setOrdertime(orderdate);
		bean.setOrderendtime(orderenddate);
		bean.setOrderadress(jsonObj.getString("orderadress"));
		bean.setOrderarea(jsonObj.getString("orderarea"));
		bean.setOrderstatus(jsonObj.getString("orderstatus"));
		bean.setPayment(jsonObj.getString("payment"));
		bean.setDelivery(jsonObj.getString("delivery"));
		
		OrdersBean insert = ordersService.insert(bean);
		if(insert!=null) {
			URI uri = URI.create("/public/api/products/"+insert.getUseraccount());
			ResponseEntity<OrdersBean> entity = ResponseEntity.created(uri).body(insert);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
	}
	
	@PutMapping("/backstage/pages/ordersupdate")
	public ResponseEntity<?> update(@RequestBody String body) {
//		修改(整體替換)：PUT message body包含需要修改(替換)的resource資料
//		成功(resource存在、替換成功)：200 (OK)、message body包含修改(整體替換)過的resource資料
//		失敗(resource不存在、不新增resource)：404 (Not Found)
		JSONObject jsonObj = new JSONObject(body);
		
		int orderid = 0;
		try {
			String id = jsonObj.getString("orderid");
			orderid = Integer.parseInt(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date orderdate = null;
		try {
			String ordertime = jsonObj.getString("ordertime");
			orderdate = new SimpleDateFormat("yyyy-MM-dd").parse(ordertime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date orderenddate = null;
		try {
			String orderendtime = jsonObj.getString("orderendtime");
			orderenddate = new SimpleDateFormat("yyyy-MM-dd").parse(orderendtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		OrdersBean bean = new OrdersBean();
		bean.setOrderid(orderid);
		bean.setUseraccount(jsonObj.getString("useraccount"));
		bean.setOrdertime(orderdate);
		bean.setOrderendtime(orderenddate);
		bean.setOrderadress(jsonObj.getString("orderadress"));
		bean.setOrderarea(jsonObj.getString("orderarea"));
		bean.setOrderstatus(jsonObj.getString("orderstatus"));
		bean.setPayment(jsonObj.getString("payment"));
		bean.setDelivery(jsonObj.getString("delivery"));
		
		OrdersBean update = ordersService.update(bean);
		if(update!=null) {
			ResponseEntity<OrdersBean> entity = ResponseEntity.ok().body(update);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
}
