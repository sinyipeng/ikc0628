package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.OrderDetailsBean;

public interface OrderDetailsDAO {
	public abstract List<OrderDetailsBean> select();
	public abstract List<OrderDetailsBean> selectFK(Integer orderID);
	public abstract OrderDetailsBean select(Integer orderDetailID);
	public abstract OrderDetailsBean selectFK(Integer orderID, Integer ProductID);
	public abstract OrderDetailsBean insert(OrderDetailsBean bean);
	public abstract OrderDetailsBean update(Integer orderDetailID,Integer orderID,Integer productID,Integer unitPrice,Byte orderQuantity,Float discount);
	public abstract boolean delete(Integer orderDetailID);
}
