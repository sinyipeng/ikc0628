package tw.com.finalproj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.finalproj.dao.MembersDAO;
import tw.com.finalproj.service.domain.MembersBean;
import tw.com.finalproj.service.domain.OrdersBean;

@Service
@Transactional
public class MembersService {
	@Autowired
	private MembersDAO membersDAO;

	@Transactional(readOnly = true)
	public MembersBean login(String useraccount, String userpassword) {
		MembersBean bean = membersDAO.select(useraccount);
		if (bean != null) {
			if (userpassword != null && userpassword.length() != 0) {
				String pass = bean.getUserpassword();
				String temp = userpassword;
				if (pass.equals(temp)) {
					return bean;
				}
			}
		}
		return null;
	}

	public MembersBean insert(MembersBean bean) {
		MembersBean result = null;
		if (bean != null && bean.getUseraccount() != null) {
			result = membersDAO.insert(bean);
		}
		return result;
	}

	public List<MembersBean> select(MembersBean bean) {
		List<MembersBean> result = null;
		if (bean != null && bean.getUseraccount() != null) {
			MembersBean temp = membersDAO.select(bean.getUseraccount());
			if (temp != null) {
				result = new ArrayList<MembersBean>();
				result.add(temp);
			}
		} else {
			result = membersDAO.select();
		}
		return result;
	}

	public List<MembersBean> selectlevel(MembersBean bean) {
		List<MembersBean> result = membersDAO.selectlevel();
		return result;
	}

	public MembersBean selectaccount(String useraccount) {
		MembersBean result = null;
		if (useraccount != null && useraccount.length() != 0) {
			result = membersDAO.select(useraccount);
		}
		return result;
	}

	public MembersBean update(MembersBean bean) {
		MembersBean result = null;
		if (bean != null && bean.getUseraccount() != null) {
			result = membersDAO.update(bean.getUseraccount(), bean.getUserpassword(), bean.getMembername(),
					bean.getBirthday(), bean.getAddress(), bean.getTelephone(), bean.getCellphone(), bean.getEmail(),
					bean.getUserlevel(), bean.getArea(), bean.getGender());
		}
		System.out.println(result);
		return result;
	}
}
