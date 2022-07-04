package tw.com.finalproj.dao;

import java.util.List;

import tw.com.finalproj.service.domain.DietViewBean;
import tw.com.finalproj.service.domain.InformationViewBean;
import tw.com.finalproj.service.domain.SleepViewBean;
import tw.com.finalproj.service.domain.SportViewBean;

public interface MemberInformationDAO {
	public abstract InformationViewBean infoSelect(Integer bodyid);
	public abstract List<InformationViewBean> infoSelect(String useraccount);
	public abstract InformationViewBean infoInsert(InformationViewBean bean);
	public abstract InformationViewBean infoUpdate(Integer bodyid, String useraccount, Float memberheight, Float memberweight);
	public abstract boolean infoDelete(Integer bodyid);
	
	public abstract DietViewBean dietSelect(Integer dietid);
	public abstract List<DietViewBean> dietSelect(String useraccount);
	public abstract DietViewBean dietInsert(DietViewBean bean);
	public abstract DietViewBean dietUpdate(Integer dietid, String useraccount, String samplename, Float calories, Integer foodnumber, java.util.Date dietdate, String diettime);
	public abstract boolean dietDelete(Integer dietid);
	
	public abstract SportViewBean sportSelect(Integer sportid);
	public abstract List<SportViewBean> sportSelect(String useraccount);
	public abstract SportViewBean sportInsert(SportViewBean bean);
	public abstract SportViewBean sportUpdate(Integer sportid, String useraccount, String sporting, Float calorieexpenditure, java.util.Date sportdate, Float sporthour);
	public abstract boolean sportDelete(Integer sportid);
	
	public abstract SleepViewBean sleepSelect(Integer sleepingid);
	public abstract List<SleepViewBean> sleepSelect(String useraccount);
	public abstract SleepViewBean sleepInsert(SleepViewBean bean);
	public abstract SleepViewBean sleepUpdate(Integer sleepingid, String useraccount, String sleetimeage, Integer minsleetime, Integer maxsleetime, java.util.Date sleepingdate, Float sleepinghour);
	public abstract boolean sleepDelete(Integer sleepingid);
}
