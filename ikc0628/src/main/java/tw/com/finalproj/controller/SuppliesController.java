package tw.com.finalproj.controller;

import java.net.URI;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tw.com.finalproj.service.SuppliesService;
import tw.com.finalproj.service.domain.SuppliesBean;

@Controller
public class SuppliesController {
	@Autowired
	private SuppliesService suppliesService;

	@GetMapping(path = { "/backstage/pages/supplies" })
	public ResponseEntity<List<SuppliesBean>> findAll() {
//		成功：200 (OK)、message body包含所有resource資料
		List<SuppliesBean> beans = suppliesService.select(null);
		return ResponseEntity.ok().body(beans);
	}

	@PostMapping("/backstage/pages/suppliesinsert")
	public ResponseEntity<?> create(@RequestBody String body) {
//		新增：POST message body包含需要新增的resource資料
//		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
//		失敗：204 (No Content)
		JSONObject jsonObj = new JSONObject(body);

		SuppliesBean bean = new SuppliesBean();
		bean.setSuppliesname(jsonObj.getString("suppliesname"));
		bean.setContactperson(jsonObj.getString("contactperson"));
		bean.setPosition(jsonObj.getString("position"));
		bean.setSuppliesphone(jsonObj.getString("suppliesphone"));
		bean.setFax(jsonObj.getString("fax"));
		bean.setSuppliesadress(jsonObj.getString("suppliesadress"));
		bean.setSuppliesarea(jsonObj.getString("suppliesarea"));

		SuppliesBean insert = suppliesService.insert(bean);
		if (insert != null) {
			URI uri = URI.create("/public/api/products/" + insert.getSuppliesid());
			ResponseEntity<SuppliesBean> entity = ResponseEntity.created(uri).body(insert);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
	}

	@PutMapping("/backstage/pages/suppliesupdate")
	public ResponseEntity<?> update(@RequestBody String body) {
//		修改(整體替換)：PUT message body包含需要修改(替換)的resource資料
//		成功(resource存在、替換成功)：200 (OK)、message body包含修改(整體替換)過的resource資料
//		失敗(resource不存在、不新增resource)：404 (Not Found)
		JSONObject jsonObj = new JSONObject(body);

		int suppliesid = 0;
		try {
			String supid = jsonObj.getString("suppliesid");
			suppliesid = Integer.parseInt(supid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SuppliesBean bean = new SuppliesBean();
		bean.setSuppliesid(suppliesid);
		bean.setSuppliesname(jsonObj.getString("suppliesname"));
		bean.setContactperson(jsonObj.getString("contactperson"));
		bean.setPosition(jsonObj.getString("position"));
		bean.setSuppliesphone(jsonObj.getString("suppliesphone"));
		bean.setFax(jsonObj.getString("fax"));
		bean.setSuppliesadress(jsonObj.getString("suppliesadress"));
		bean.setSuppliesarea(jsonObj.getString("suppliesarea"));

		SuppliesBean update = suppliesService.update(bean);
		if (update != null) {
			ResponseEntity<SuppliesBean> entity = ResponseEntity.ok().body(update);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
}
