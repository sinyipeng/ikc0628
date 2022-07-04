package tw.com.finalproj.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.finalproj.service.MembersService;
import tw.com.finalproj.service.domain.MembersBean;

@RestController
public class MemberController {
	@Autowired
	private MembersService membersService;

	@GetMapping(path = {"/backstage/pages/members"})
	public ResponseEntity<List<MembersBean>> findAll() {
//		成功：200 (OK)、message body包含所有resource資料
		List<MembersBean> beans = membersService.selectlevel(null);
		return ResponseEntity.ok().body(beans);
	}
	
	@PostMapping("/backstage/pages/membersinsert")
	public ResponseEntity<?> create(@RequestBody String body) {
//		新增：POST message body包含需要新增的resource資料
//		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
//		失敗：204 (No Content)
		JSONObject jsonObj = new JSONObject(body);
		
		Date birthdate = null;
		try {
			String birthday = jsonObj.getString("birthday");
			birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MembersBean bean = new MembersBean();
		bean.setUseraccount(jsonObj.getString("useraccount"));
		bean.setUserpassword(jsonObj.getString("userpassword"));
		bean.setMembername(jsonObj.getString("membername"));
		bean.setBirthday(birthdate);
		bean.setAddress(jsonObj.getString("address"));
		bean.setTelephone(jsonObj.getString("telephone"));
		bean.setCellphone(jsonObj.getString("cellphone"));
		bean.setEmail(jsonObj.getString("email"));
		bean.setUserlevel(jsonObj.getString("userlevel"));
		bean.setArea(jsonObj.getString("area"));
		bean.setGender(jsonObj.getString("gender"));
		
		MembersBean insert = membersService.insert(bean);
		if(insert!=null) {
			URI uri = URI.create("/public/api/products/"+insert.getUseraccount());
			ResponseEntity<MembersBean> entity = ResponseEntity.created(uri).body(insert);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
	}
	
	@PutMapping("/backstage/pages/membersupdate")
	public  ResponseEntity<?> update(@RequestBody String body) {
//		修改(整體替換)：PUT message body包含需要修改(替換)的resource資料
//		成功(resource存在、替換成功)：200 (OK)、message body包含修改(整體替換)過的resource資料
//		失敗(resource不存在、不新增resource)：404 (Not Found)
		JSONObject jsonObj = new JSONObject(body);
		
		Date birthdate = null;
		try {
			String birthday = jsonObj.getString("birthday");
			birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MembersBean bean = new MembersBean();
		bean.setUseraccount(jsonObj.getString("useraccount"));
		bean.setUserpassword(jsonObj.getString("userpassword"));
		bean.setMembername(jsonObj.getString("membername"));
		bean.setBirthday(birthdate);
		bean.setAddress(jsonObj.getString("address"));
		bean.setTelephone(jsonObj.getString("telephone"));
		bean.setCellphone(jsonObj.getString("cellphone"));
		bean.setEmail(jsonObj.getString("email"));
		bean.setUserlevel(jsonObj.getString("userlevel"));
		bean.setArea(jsonObj.getString("area"));
		bean.setGender(jsonObj.getString("gender"));
		
		MembersBean update = membersService.update(bean);
		if(update!=null) {
			ResponseEntity<MembersBean> entity = ResponseEntity.ok().body(update);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
}
