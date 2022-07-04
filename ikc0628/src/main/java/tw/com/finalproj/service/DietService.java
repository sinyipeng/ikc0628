package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.DietDAO;
import tw.com.finalproj.service.domain.DietBean;

@Service
@Transactional
public class DietService {
	@Autowired
	private DietDAO dietDAO;

	public List<DietBean> select(DietBean bean) {
		List<DietBean> result = null;
		if (bean != null && bean.getUseraccount() != null) {
			DietBean temp = dietDAO.select(bean.getDietid());
			if (temp != null) {
				result = new ArrayList<DietBean>();
				result.add(temp);
			}
		} else {
			result = dietDAO.select();
		}
		return result;
	}
	
	public List<DietBean> selectaccount(String useraccount) {
		List<DietBean> result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = dietDAO.selectaccount(useraccount);
		}
		return result;
	}
}
