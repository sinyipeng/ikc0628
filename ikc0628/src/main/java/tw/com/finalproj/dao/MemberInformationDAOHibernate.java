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

import tw.com.finalproj.service.domain.DietViewBean;
import tw.com.finalproj.service.domain.InformationViewBean;
import tw.com.finalproj.service.domain.MembersBean;
import tw.com.finalproj.service.domain.SleepViewBean;
import tw.com.finalproj.service.domain.SportViewBean;

@Repository
public class MemberInformationDAOHibernate implements MemberInformationDAO{
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}

	@Override
	public InformationViewBean infoSelect(Integer bodyid) {
		if(bodyid!=null) {
			return this.getSession().get(InformationViewBean.class, bodyid);
		}
		return null;
	}

	@Override
	public List<InformationViewBean> infoSelect(String useraccount) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<InformationViewBean> criteriaQuery = criteriaBuilder.createQuery(InformationViewBean.class);

		Root<InformationViewBean> root = criteriaQuery.from(InformationViewBean.class);
		
		criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("useraccount"), useraccount));

		TypedQuery<InformationViewBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<InformationViewBean> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public InformationViewBean infoInsert(InformationViewBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InformationViewBean infoUpdate(Integer bodyid, String useraccount, Float memberheight, Float memberweight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean infoDelete(Integer bodyid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DietViewBean dietSelect(Integer dietid) {
		if(dietid!=null) {
			return this.getSession().get(DietViewBean.class, dietid);
		}
		return null;
	}

	@Override
	public List<DietViewBean> dietSelect(String useraccount) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<DietViewBean> criteriaQuery = criteriaBuilder.createQuery(DietViewBean.class);

		Root<DietViewBean> root = criteriaQuery.from(DietViewBean.class);
		
		criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("useraccount"), useraccount));

		TypedQuery<DietViewBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<DietViewBean> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public DietViewBean dietInsert(DietViewBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DietViewBean dietUpdate(Integer dietid, String useraccount, String samplename, Float calories,
			Integer foodnumber, Date dietdate, String diettime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dietDelete(Integer dietid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SportViewBean sportSelect(Integer sportid) {
		if(sportid!=null) {
			return this.getSession().get(SportViewBean.class, sportid);
		}
		return null;
	}

	@Override
	public List<SportViewBean> sportSelect(String useraccount) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<SportViewBean> criteriaQuery = criteriaBuilder.createQuery(SportViewBean.class);

		Root<SportViewBean> root = criteriaQuery.from(SportViewBean.class);
		
		criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("useraccount"), useraccount));

		TypedQuery<SportViewBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<SportViewBean> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public SportViewBean sportInsert(SportViewBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SportViewBean sportUpdate(Integer sportid, String useraccount, String sporting, Float calorieexpenditure,
			Date sportdate, Float sporthour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sportDelete(Integer sportid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SleepViewBean sleepSelect(Integer sleepingid) {
		if(sleepingid!=null) {
			return this.getSession().get(SleepViewBean.class, sleepingid);
		}
		return null;
	}

	@Override
	public List<SleepViewBean> sleepSelect(String useraccount) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<SleepViewBean> criteriaQuery = criteriaBuilder.createQuery(SleepViewBean.class);

		Root<SleepViewBean> root = criteriaQuery.from(SleepViewBean.class);
		
		criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("useraccount"), useraccount));

		TypedQuery<SleepViewBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<SleepViewBean> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public SleepViewBean sleepInsert(SleepViewBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SleepViewBean sleepUpdate(Integer sleepingid, String useraccount, String sleetimeage, Integer minsleetime,
			Integer maxsleetime, Date sleepingdate, Float sleepinghour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sleepDelete(Integer sleepingid) {
		// TODO Auto-generated method stub
		return false;
	}

}
