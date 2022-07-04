package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.ProductsBean;

public interface ProductsDAO {
	public abstract ProductsBean select( Integer productid);
	
	public abstract List<ProductsBean> select();
	
	public abstract ProductsBean insert(ProductsBean bean);
	
	public abstract ProductsBean update(Integer productid, String productname,
			Integer suppliesid, String productimg, Integer standardcost, Integer productstock, String productdescribe, String productstatus);
	
	public abstract boolean delete(Integer productid);	
}
