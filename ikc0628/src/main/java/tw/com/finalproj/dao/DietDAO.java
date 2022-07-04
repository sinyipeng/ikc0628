package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.DietBean;

public interface DietDAO {
	public abstract DietBean select(Integer dietid);
	public abstract List<DietBean> select();
	public abstract List<DietBean> selectaccount(String useraccount);	
	public abstract DietBean insert(DietBean bean);
	public abstract DietBean delete(Integer dietid);
	public abstract DietBean updata(Integer dietid,String useraccount,java.util.Date dietdate,String  diettime);
}