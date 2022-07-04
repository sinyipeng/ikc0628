package tw.com.finalproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tw.com.finalproj.service.MemberInformationService;
import tw.com.finalproj.service.domain.DietViewBean;
import tw.com.finalproj.service.domain.InformationViewBean;
import tw.com.finalproj.service.domain.SleepViewBean;
import tw.com.finalproj.service.domain.SportViewBean;

@Controller
public class MemberInformationController {
	@Autowired
	private MemberInformationService memberInformationService;
	
	@GetMapping(path = {"/backstage/pages/memberinformation/info/{useraccount}"})	
	public ResponseEntity<List<InformationViewBean>> findAllInfo(@PathVariable(name = "useraccount")String useraccount) {
//		成功：200 (OK)、message body包含所有resource資料
		List<InformationViewBean> beans = memberInformationService.infoSelect(useraccount);
		return ResponseEntity.ok().body(beans);
	}
	
	@GetMapping(path = {"/backstage/pages/memberinformation/diet"})	
	public ResponseEntity<List<DietViewBean>> findAllDiet(String useraccount) {
//		成功：200 (OK)、message body包含所有resource資料
		List<DietViewBean> beans = memberInformationService.dietSelect(useraccount);
		return ResponseEntity.ok().body(beans);
	}
	
	@GetMapping(path = {"/backstage/pages/memberinformation/sport"})	
	public ResponseEntity<List<SportViewBean>> findAllSport(String useraccount) {
//		成功：200 (OK)、message body包含所有resource資料
		List<SportViewBean> beans = memberInformationService.sportSelect(useraccount);
		return ResponseEntity.ok().body(beans);
	}
	
	@GetMapping(path = {"/backstage/pages/memberinformation/sleep"})	
	public ResponseEntity<List<SleepViewBean>> findAllSleep(String useraccount) {
//		成功：200 (OK)、message body包含所有resource資料
		List<SleepViewBean> beans = memberInformationService.sleepSelect(useraccount);
		return ResponseEntity.ok().body(beans);
	}
}
