package tw.com.finalproj.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.com.finalproj.service.domain.SuppliesBean;

@Repository
public class SuppliesDAOHibernate implements SuppliesDAO {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public SuppliesBean insert(SuppliesBean bean) {
		if (bean != null && bean.getSuppliesname().length() != 0) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public List<SuppliesBean> select() {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<SuppliesBean> criteriaQuery = criteriaBuilder.createQuery(SuppliesBean.class);

		Root<SuppliesBean> root = criteriaQuery.from(SuppliesBean.class);

		TypedQuery<SuppliesBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<SuppliesBean> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;

		}
		return null;
	}

	public SuppliesBean update(SuppliesBean bean) {
		if (bean != null && bean.getSuppliesid() != null) {
			System.out.println("[DAO got bean(編輯) : ]" + bean);
			SuppliesBean temp = this.getSession().get(SuppliesBean.class, bean.getSuppliesid());
			if (temp != null) {
				return (SuppliesBean) this.getSession().merge(bean);
			}
		}
		return null;
	}

	@Override
	public SuppliesBean update(Integer suppliesid, String suppliesname, String contactperson, String position,
			String suppliesphone, String fax, String suppliesadress, String suppliesarea) {
		if (suppliesid != 0) {
			SuppliesBean temp = this.getSession().get(SuppliesBean.class, suppliesid);
			if (temp != null) {
				temp.setSuppliesid(suppliesid);
				temp.setSuppliesname(suppliesname);
				temp.setContactperson(contactperson);
				temp.setPosition(position);
				temp.setSuppliesphone(suppliesphone);
				temp.setFax(fax);
				temp.setSuppliesadress(suppliesadress);
				temp.setSuppliesarea(suppliesarea);
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer suppliesid) {
		if (suppliesid > 0) {
			System.out.println("[DAO got id(delete) : ]" + suppliesid);
			SuppliesBean temp = this.getSession().get(SuppliesBean.class, suppliesid);
			if (temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public SuppliesBean select(Integer suppliesid) {
		if (suppliesid != null) {
			return this.getSession().get(SuppliesBean.class, suppliesid);
		}
		return null;
	}
}
