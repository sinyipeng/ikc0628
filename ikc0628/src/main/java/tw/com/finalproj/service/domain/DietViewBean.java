package tw.com.finalproj.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dietview")
public class DietViewBean {
	@Id
	@Column(name = "dietid")
	private Integer dietid;

	@Column(name = "useraccount")
	private String useraccount;

	@Column(name = "samplename")
	private String samplename;

	@Column(name = "calories")
	private Float calories;

	@Column(name = "foodnumber")
	private Integer foodnumber;
	
	@Column(name = "dietdate")
	@Temporal(TemporalType.DATE)
	private java.util.Date dietdate;

	@Column(name = "diettime")
	private String diettime;

	@Override
	public String toString() {
		return "DietViewBean [" + dietid + ", " + useraccount + ", " + samplename + ", " + calories + ", " + foodnumber
				+ ", " + dietdate + ", " + diettime + "]";
	}

	public Integer getDietid() {
		return dietid;
	}

	public void setDietid(Integer dietid) {
		this.dietid = dietid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getSamplename() {
		return samplename;
	}

	public void setSamplename(String samplename) {
		this.samplename = samplename;
	}

	public Float getCalories() {
		return calories;
	}

	public void setCalories(Float calories) {
		this.calories = calories;
	}

	public Integer getFoodnumber() {
		return foodnumber;
	}

	public void setFoodnumber(Integer foodnumber) {
		this.foodnumber = foodnumber;
	}

	public java.util.Date getDietdate() {
		return dietdate;
	}

	public void setDietdate(java.util.Date dietdate) {
		this.dietdate = dietdate;
	}

	public String getDiettime() {
		return diettime;
	}

	public void setDiettime(String diettime) {
		this.diettime = diettime;
	}
}
