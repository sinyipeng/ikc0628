package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.ProductsDAO;
import tw.com.finalproj.service.domain.ProductsBean;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductsDAO productdao;

	@Transactional(readOnly = true)
	public List<ProductsBean> select(ProductsBean bean) {
		List<ProductsBean> result = null;
		if(bean!=null && bean.getProductid()!=null && bean.getProductid() != 0) {
			ProductsBean temp = productdao.select(bean.getProductid());
			if(temp!=null) {
				result = new ArrayList<ProductsBean>();
				result.add(temp);
			}
		} else {
			result = productdao.select();
		}
		return result;
	}
	
	public ProductsBean insert(ProductsBean bean) {
		
		ProductsBean result = null;
		if(bean!=null && bean.getProductid()!=null) {
			System.out.println("7777777777");
			result = productdao.insert(bean);
			System.out.println("888888888888");
			System.out.println("I'm from service and i have result");
		}
		return result;
	}
	public ProductsBean update(ProductsBean bean) {
		ProductsBean result = null;
		if(bean!=null && bean.getProductid()!=null) {
			result = productdao.update(bean.getProductid(), bean.getProductname(),
					bean.getSuppliesid(), bean.getProductimg(), bean.getStandardcost(),
					bean.getProductstock(), bean.getProductdescribe(), bean.getProductstatus());
		}
		return result;
	}
	public boolean delete(ProductsBean bean) {
		boolean result = false;
		if(bean!=null && bean.getProductid()!=null) {
			result = productdao.delete(bean.getProductid());
		}
		return result;
	}
}
