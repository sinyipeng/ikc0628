package tw.com.finalproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.MemberInformationDAO;
import tw.com.finalproj.service.domain.DietViewBean;
import tw.com.finalproj.service.domain.InformationViewBean;
import tw.com.finalproj.service.domain.MembersBean;
import tw.com.finalproj.service.domain.SleepViewBean;
import tw.com.finalproj.service.domain.SportViewBean;

@Service
@Transactional
public class MemberInformationService {
	@Autowired
	private MemberInformationDAO memberInformationDAO;
	
	public List<InformationViewBean> infoSelect(String useraccount) {
		List<InformationViewBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = memberInformationDAO.infoSelect(useraccount);
		}
		return result;
	}
	
	public InformationViewBean infoInsert(InformationViewBean bean) {

		return null;
	}
	
	public InformationViewBean infoUpdate(InformationViewBean bean) {

		return null;
	}
	
	public boolean infoDelete(InformationViewBean bean) {
		
		return false;
	}
	
	public List<DietViewBean> dietSelect(String useraccount) {
		List<DietViewBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = memberInformationDAO.dietSelect(useraccount);
		}
		return result;
	}
	
	public DietViewBean dietInsert(DietViewBean bean) {

		return null;
	}
	
	public DietViewBean dietUpdate(DietViewBean bean) {

		return null;
	}
	
	public boolean dietDelete(DietViewBean bean) {
		
		return false;
	}
	
	public List<SportViewBean> sportSelect(String useraccount) {
		List<SportViewBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = memberInformationDAO.sportSelect(useraccount);
		}
		return result;
	}
	
	public SportViewBean sportInsert(SportViewBean bean) {

		return null;
	}
	
	public SportViewBean sportUpdate(SportViewBean bean) {

		return null;
	}
	
	public boolean sportDelete(SportViewBean bean) {
		
		return false;
	}
	
	public List<SleepViewBean> sleepSelect(String useraccount) {
		List<SleepViewBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = memberInformationDAO.sleepSelect(useraccount);
		}
		return result;
	}
	
	public SleepViewBean sleepInsert(SleepViewBean bean) {

		return null;
	}
	
	public SleepViewBean sleepUpdate(SleepViewBean bean) {

		return null;
	}
	
	public boolean sleepDelete(SleepViewBean bean) {
		
		return false;
	}
}
