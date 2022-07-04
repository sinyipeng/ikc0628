package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.OrdersDAO;
import tw.com.finalproj.service.domain.OrdersBean;

@Service
@Transactional
public class OrdersService {
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Transactional(readOnly = true)
	public List<OrdersBean> select(OrdersBean bean){
		List<OrdersBean> result = null;
		if(bean!=null && bean.getOrderid()!=null && !bean.getOrderid().equals(0)) {
			OrdersBean temp = ordersDAO.select(bean.getOrderid());
			if(temp!=null) {
				result = new ArrayList<OrdersBean>();
				result.add(temp);
			}
		} else {
			result = ordersDAO.select();
		}
		return result;
	}
	public List<OrdersBean> selectPage(int page){
		if(page>=1) {
			return ordersDAO.selectPage(page);
		}
		return null;
	}
	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.insert(bean);
			System.out.println("I'm from service and i have result");
		}
		return result;
	}
	public OrdersBean update(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.update(bean.getOrderid(), bean.getUseraccount(),
					bean.getOrdertime(), bean.getOrderendtime(), bean.getOrderadress(),
					bean.getOrderarea(),bean.getOrderstatus(),bean.getPayment(),bean.getDelivery());
		}
		return result;
	}
	public boolean delete(OrdersBean bean) {
		boolean result = false;
		if(bean!=null && bean.getOrderid()!=null) {
			result = ordersDAO.delete(bean.getOrderid());
		}
		return result;
	}
}
