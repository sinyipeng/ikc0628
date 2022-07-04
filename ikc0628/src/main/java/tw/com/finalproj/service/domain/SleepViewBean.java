package tw.com.finalproj.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sleepview")
public class SleepViewBean {
	@Id
	@Column(name = "sleepingid ")
	private Integer sleepingid ;
	
	@Column(name = "useraccount ")
	private String useraccount ;
	
	@Column(name = "sleetimeage ")
	private String sleetimeage ;

	@Column(name = "sleepingdate ")
	private java.util.Date sleepingdate ;
	
	@Column(name = "sleepinghour ")
	private Float sleepinghour ;

	@Override
	public String toString() {
		return "SleepViewBean [" + sleepingid + ", " + useraccount + ", " + sleetimeage + ", " + sleepingdate + ", "
				+ sleepinghour + "]";
	}

	public Integer getSleepingid() {
		return sleepingid;
	}

	public void setSleepingid(Integer sleepingid) {
		this.sleepingid = sleepingid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getSleetimeage() {
		return sleetimeage;
	}

	public void setSleetimeage(String sleetimeage) {
		this.sleetimeage = sleetimeage;
	}

	public java.util.Date getSleepingdate() {
		return sleepingdate;
	}

	public void setSleepingdate(java.util.Date sleepingdate) {
		this.sleepingdate = sleepingdate;
	}

	public Float getSleepinghour() {
		return sleepinghour;
	}

	public void setSleepinghour(Float sleepinghour) {
		this.sleepinghour = sleepinghour;
	}

}
