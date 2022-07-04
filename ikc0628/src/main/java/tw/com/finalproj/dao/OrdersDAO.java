package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.OrdersBean;

public interface OrdersDAO {
	public abstract OrdersBean select(Integer orderid);
	public abstract List<OrdersBean> selectPage(int page);
	public abstract List<OrdersBean> select();
	public abstract OrdersBean insert(OrdersBean bean);
	public abstract OrdersBean update(Integer orderid,String useraccount,java.util.Date ordertime,java.util.Date orderendtime,String orderadress,String orderarea,String orderstatus,String payment,String delivery);
	public abstract boolean delete(Integer orderid);
}
