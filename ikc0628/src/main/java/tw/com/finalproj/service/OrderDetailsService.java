package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.OrderDetailsDAO;
import tw.com.finalproj.service.domain.OrderDetailsBean;

@Service
@Transactional
public class OrderDetailsService {
	@Autowired
	private OrderDetailsDAO orderDetailsDAO;
	
	@Transactional(readOnly = true)
	public List<OrderDetailsBean> selectFK(OrderDetailsBean bean) {
		List<OrderDetailsBean> result = null;
		if (bean != null && bean.getOrderid() != null && !bean.getOrderid().equals(0)) {
			List<OrderDetailsBean> temp = orderDetailsDAO.selectFK(bean.getOrderid());
			System.out.println("[service] "+temp);
			if (temp != null) {
				result = new ArrayList<OrderDetailsBean>();
				result = temp;
			}
		}
		return result;
	}
	
	public List<OrderDetailsBean> select(OrderDetailsBean bean){
		List<OrderDetailsBean> result = null;
		if(bean!=null && bean.getOrderdetailid()!=null && !bean.getOrderdetailid().equals(0)) {
			OrderDetailsBean temp = orderDetailsDAO.select(bean.getOrderdetailid());
			if(temp!=null) {
				result = new ArrayList<OrderDetailsBean>();
				result.add(temp);
			}
		} else {
			result = orderDetailsDAO.select();
		}
		return result;	
	}

	public OrderDetailsBean insert(OrderDetailsBean bean) {
		OrderDetailsBean result = null;
		if (bean != null && bean.getOrderid() != null && bean.getProductid() != null) {
			result = orderDetailsDAO.insert(bean);
		}
		return result;
	}

	public OrderDetailsBean update(OrderDetailsBean bean) {
		OrderDetailsBean result = null;
		if (bean != null && bean.getOrderdetailid() != null) {
			result = orderDetailsDAO.update(bean.getOrderdetailid(), bean.getOrderid(), bean.getProductid(),
					bean.getUnitprice(), bean.getOrderquantity(), bean.getDiscount());
		}
		return result;
	}

	public boolean delete(OrderDetailsBean bean) {
		boolean result = false;
		if (bean != null && bean.getOrderdetailid() != null) {
			result = orderDetailsDAO.delete(bean.getOrderid());
		}
		return result;
	}

}
