package tw.com.finalproj.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.finalproj.service.domain.OrdersBean;

@Repository
public class OrdersDAOHibernate implements OrdersDAO{
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}

	@Override
	public OrdersBean select(Integer orderid) {
		if(orderid!=null) {
			return this.getSession().get(OrdersBean.class, orderid);
		}
		return null;
	}

	@Override
	public List<OrdersBean> select() {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrdersBean> criteriaQuery = criteriaBuilder.createQuery(OrdersBean.class);
		
		Root<OrdersBean> root = criteriaQuery.from(OrdersBean.class);
		criteriaQuery = criteriaQuery.orderBy(criteriaBuilder.desc(root.get("orderid")));
		
		TypedQuery<OrdersBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<OrdersBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			System.out.println("[hibernate]:"+result);
			return result;
		}
		return null;
	}
	
	public List<OrdersBean> selectPage(int page){
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<OrdersBean> criteriaQuery = criteriaBuilder.createQuery(OrdersBean.class);
		
		Root<OrdersBean> root = criteriaQuery.from(OrdersBean.class);
		criteriaQuery = criteriaQuery.orderBy(criteriaBuilder.desc(root.get("orderid")));
		
		TypedQuery<OrdersBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		typedQuery.setFirstResult((page-1)*10);
		typedQuery.setMaxResults(10);
		List<OrdersBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			System.out.println("[hibernate]:"+result);
			return result;
		}
		return null;
	}

	@Override
	public OrdersBean insert(OrdersBean bean) {
		if(bean!=null && bean.getOrderid()!=null) {
			System.out.println("[DAOHibernate]I got bean and i'm going to select");
			OrdersBean temp = this.getSession().get(OrdersBean.class, bean.getOrderid());
			if(temp==null) {
				System.out.println("[DAOHibernate]I got bean also it have saved");
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	public OrdersBean update(OrdersBean bean) {
		if(bean!=null && bean.getOrderid()!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, bean.getOrderid());
			if(temp!=null) {
				return (OrdersBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Override
	public OrdersBean update(Integer orderid, String useraccount, Date ordertime, Date orderendtime, String orderadress,
			String orderarea, String orderstatus, String payment, String delivery) {
		if(orderid!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, orderid);
			if(temp!=null) {
				temp.setUseraccount(useraccount);
				temp.setOrdertime(ordertime);
				temp.setOrderendtime(orderendtime);
				temp.setOrderadress(orderadress);
				temp.setOrderarea(orderarea);
				temp.setOrderstatus(orderstatus);
				temp.setPayment(payment);
				temp.setDelivery(delivery);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer orderid) {
		if(orderid!=null) {
			OrdersBean temp = this.getSession().get(OrdersBean.class, orderid);
			if(temp!=null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}
	
}
