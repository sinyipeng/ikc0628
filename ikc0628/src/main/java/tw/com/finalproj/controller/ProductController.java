package tw.com.finalproj.controller;

import java.net.URI;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.finalproj.service.ProductService;
import tw.com.finalproj.service.domain.ProductsBean;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping(path = { "/backstage/pages/product" })
	public ResponseEntity<List<ProductsBean>> findAll() {
//		成功：200 (OK)、message body包含所有resource資料
		List<ProductsBean> beans = productService.select(null);
		return ResponseEntity.ok().body(beans);
	}

	@PostMapping("/backstage/pages/productinsert")
	public ResponseEntity<?> create(@RequestBody String body) {
//		新增：POST message body包含需要新增的resource資料
//		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
//		失敗：204 (No Content)
		JSONObject jsonObj = new JSONObject(body);

		int id = 0;
		int suppid = 0;
		int standcost = 0;
		int prodstuck = 0;
		try {
			String productid = jsonObj.getString("productid");
			id = Integer.parseInt(productid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String suppliesid = jsonObj.getString("suppliesid");
			suppid = Integer.parseInt(suppliesid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String standardcost = jsonObj.getString("standardcost");
			standcost = Integer.parseInt(standardcost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String productstock = jsonObj.getString("productstock");
			prodstuck = Integer.parseInt(productstock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProductsBean bean = new ProductsBean();
		bean.setProductid(id);
		bean.setProductname(jsonObj.getString("productname"));
		bean.setSuppliesid(suppid);
		bean.setProductimg(jsonObj.getString("productimg"));
		bean.setStandardcost(standcost);
		bean.setProductstock(prodstuck);
		bean.setProductdescribe(jsonObj.getString("productdescribe"));
		bean.setProductstatus(jsonObj.getString("productstatus"));

		ProductsBean insert = productService.insert(bean);
		if (insert != null) {
			URI uri = URI.create("/public/api/products/" + insert.getProductid());
			ResponseEntity<ProductsBean> entity = ResponseEntity.created(uri).body(insert);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
	}

	@PutMapping("/backstage/pages/productupdate")
	public ResponseEntity<?> update(@RequestBody String body) {
//		修改(整體替換)：PUT message body包含需要修改(替換)的resource資料
//		成功(resource存在、替換成功)：200 (OK)、message body包含修改(整體替換)過的resource資料
//		失敗(resource不存在、不新增resource)：404 (Not Found)
		JSONObject jsonObj = new JSONObject(body);
		
		int id = 0;
		int suppid = 0;
		int standcost = 0;
		int prodstuck = 0;
		try {
			String productid = jsonObj.getString("productid");
			id = Integer.parseInt(productid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String suppliesid = jsonObj.getString("suppliesid");
			suppid = Integer.parseInt(suppliesid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String standardcost = jsonObj.getString("standardcost");
			standcost = Integer.parseInt(standardcost);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String productstock = jsonObj.getString("productstock");
			prodstuck = Integer.parseInt(productstock);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProductsBean bean = new ProductsBean();
		bean.setProductid(id);
		bean.setProductname(jsonObj.getString("productname"));
		bean.setSuppliesid(suppid);
		bean.setProductimg(jsonObj.getString("productimg"));
		bean.setStandardcost(standcost);
		bean.setProductstock(prodstuck);
		bean.setProductdescribe(jsonObj.getString("productdescribe"));
		bean.setProductstatus(jsonObj.getString("productstatus"));

		ProductsBean update = productService.update(bean);
		if (update != null) {
			ResponseEntity<ProductsBean> entity = ResponseEntity.ok().body(update);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
}
