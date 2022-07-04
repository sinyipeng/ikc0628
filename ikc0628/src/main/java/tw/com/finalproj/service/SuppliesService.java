package tw.com.finalproj.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.SuppliesDAO;
import tw.com.finalproj.service.domain.SuppliesBean;

@Service
@Transactional
public class SuppliesService {
	@Autowired
	private SuppliesDAO suppliesDAO ;

	@Transactional(readOnly = true)
	public List<SuppliesBean> select(SuppliesBean bean){
		List<SuppliesBean> result = null;
		if(bean!=null && bean.getSuppliesid()!=null && !bean.getSuppliesid().equals(0)) {
			SuppliesBean temp = suppliesDAO.select(bean.getSuppliesid());
			if(temp!=null) {
				result = new ArrayList<SuppliesBean>();
				result.add(temp);
			}
		} else {
			result = suppliesDAO.select();
		}
		return result;
	}

	public SuppliesBean insert(SuppliesBean bean) {
		SuppliesBean result = null;
		System.out.println("[service]"+bean);
		if (bean != null && bean.getSuppliesname() != null) {
			result = suppliesDAO.insert(bean);
		}
		
		return result;
	}
	
	public SuppliesBean update(SuppliesBean bean) {
		SuppliesBean result = null;
		System.out.println("[service got bean(編輯) : ]" + bean);
		if(bean!=null && bean.getSuppliesname()!=null) {
			result = suppliesDAO.update(bean.getSuppliesid(),bean.getSuppliesname(), bean.getContactperson(),
					bean.getPosition(), bean.getSuppliesphone(), bean.getFax(),bean.getSuppliesadress()
					,bean.getSuppliesarea());
		}
		return result;
	}
	public boolean delete(SuppliesBean bean) {
		boolean result = false;
		System.out.println("[service got bean(delete) : ]" + bean);
		if(bean!=null && bean.getSuppliesname()!=null) {
			result = suppliesDAO.delete(bean.getSuppliesid());
		}
		return result;
	}
	
	
}
