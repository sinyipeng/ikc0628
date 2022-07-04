package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.SuppliesBean;

public interface SuppliesDAO {
	public abstract SuppliesBean select(Integer suppliesid);
    public abstract List<SuppliesBean> select();
	public abstract SuppliesBean insert(SuppliesBean bean);
	public abstract SuppliesBean update(Integer suppliesid,String suppliesname,String contactperson,String position,String suppliesphone,String fax,String suppliesadress,String suppliesarea);
	public abstract boolean  delete(Integer suppliesid);
}
