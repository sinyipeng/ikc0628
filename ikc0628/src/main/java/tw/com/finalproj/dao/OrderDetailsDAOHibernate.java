package tw.com.finalproj.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.finalproj.service.domain.OrderDetailsBean;

@Repository
public class OrderDetailsDAOHibernate implements OrderDetailsDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<OrderDetailsBean> select() {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrderDetailsBean> criteriaQuery = criteriaBuilder.createQuery(OrderDetailsBean.class);
		
		Root<OrderDetailsBean> root = criteriaQuery.from(OrderDetailsBean.class);
		
		TypedQuery<OrderDetailsBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<OrderDetailsBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			System.out.println("[hibernate]:"+result);
			return result;
		}
		
		return null;
	}

	@Override
	public List<OrderDetailsBean> selectFK(Integer orderID) {
		if (orderID != null) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderDetailsBean> criteriaQuery = criteriaBuilder.createQuery(OrderDetailsBean.class);

			Root<OrderDetailsBean> root = criteriaQuery.from(OrderDetailsBean.class);
			criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("orderID"), orderID));
			
			TypedQuery<OrderDetailsBean> typedQuery = this.getSession().createQuery(criteriaQuery);
			List<OrderDetailsBean> result = typedQuery.getResultList();
			if (result != null) {
				System.out.println("[hibernate]:" + result);
				return result;
			}
		}
		return null;
	}

	@Override
	public OrderDetailsBean select(Integer orderDetailID) {
		if (orderDetailID != null) {
			return this.getSession().get(OrderDetailsBean.class, orderDetailID);
		}
		return null;
	}

	@Override
	public OrderDetailsBean selectFK(Integer orderID, Integer ProductID) {
		if (orderID != null && ProductID != null) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderDetailsBean> criteriaQuery = criteriaBuilder.createQuery(OrderDetailsBean.class);

			Root<OrderDetailsBean> root = criteriaQuery.from(OrderDetailsBean.class);
			criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("orderID"), orderID),criteriaBuilder.equal(root.get("ProductID"), ProductID));
			
			TypedQuery<OrderDetailsBean> typedQuery = this.getSession().createQuery(criteriaQuery);
			OrderDetailsBean result = typedQuery.getSingleResult();
			if (result != null) {
				System.out.println("[hibernate]:" + result);
				return result;
			}
		}
		return null;
	}

	@Override
	public OrderDetailsBean insert(OrderDetailsBean bean) {
		if(bean!=null&&bean.getOrderid()!=null&&bean.getProductid()!=null) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderDetailsBean> criteriaQuery = criteriaBuilder.createQuery(OrderDetailsBean.class);

			Root<OrderDetailsBean> root = criteriaQuery.from(OrderDetailsBean.class);
			criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("orderID"), bean.getOrderid()),criteriaBuilder.equal(root.get("ProductID"), bean.getProductid()));
			
			TypedQuery<OrderDetailsBean> typedQuery = this.getSession().createQuery(criteriaQuery);
			OrderDetailsBean temp = typedQuery.getSingleResult();
			if(temp==null) {
				System.out.println("[DAOHibernate]I got bean also it have saved");
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	public OrderDetailsBean update(OrderDetailsBean bean) {
		if(bean!=null && bean.getOrderdetailid()!=null) {
			OrderDetailsBean temp = this.getSession().get(OrderDetailsBean.class, bean.getOrderdetailid());
			if(temp!=null) {
				return (OrderDetailsBean)this.getSession().merge(bean);
			}
		}
		return null;
	}

	@Override
	public OrderDetailsBean update(Integer orderDetailID, Integer orderID, Integer productID, Integer unitPrice,
			Byte orderQuantity, Float discount) {
		if(orderDetailID!=null) {
			OrderDetailsBean temp = this.getSession().get(OrderDetailsBean.class, orderDetailID);
			if(temp!=null) {
				temp.setOrderid(orderID);
				temp.setProductid(productID);
				temp.setUnitprice(unitPrice);
				temp.setOrderquantity(orderQuantity);
				temp.setDiscount(discount);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer orderDetailID) {
		if(orderDetailID!=null) {
			OrderDetailsBean temp = this.getSession().get(OrderDetailsBean.class, orderDetailID);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

}
