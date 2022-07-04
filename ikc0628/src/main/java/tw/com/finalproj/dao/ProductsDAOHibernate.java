package tw.com.finalproj.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.finalproj.service.domain.MembersBean;
import tw.com.finalproj.service.domain.ProductsBean;

@Repository
public class ProductsDAOHibernate implements ProductsDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public ProductsBean select(Integer productid) {
		if (productid != null) {
			return this.getSession().get(ProductsBean.class, productid);
		}
		return null;
	}

	@Override
	public ProductsBean insert(ProductsBean bean) {
		if (bean != null && bean.getProductid() != null) {
			ProductsBean temp = this.getSession().get(ProductsBean.class, bean.getProductid());
			if (temp == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public List<ProductsBean> select() {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ProductsBean> criteriaQuery = criteriaBuilder.createQuery(ProductsBean.class);

		Root<ProductsBean> root = criteriaQuery.from(ProductsBean.class);
		
		TypedQuery<ProductsBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<ProductsBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public ProductsBean update(Integer productid, String productname,
			Integer suppliesid, String productlmg, Integer standardcost, Integer productstock, String productdescribe, String productstatus) {
		if(productid!=null) {
			ProductsBean temp = this.getSession().get(ProductsBean.class, productid);
			if(temp!=null) {
				temp.setProductid(productid);
				temp.setProductname(productname);
				temp.setSuppliesid(suppliesid);
				temp.setProductimg(productlmg);
				temp.setStandardcost(standardcost);
				temp.setProductstock(productstock);
				temp.setProductdescribe(productdescribe);
				temp.setProductstatus(productstatus);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer productname) {
		if(productname!=null) {
			ProductsBean temp = this.getSession().get(ProductsBean.class, productname);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}
}
