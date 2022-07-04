package tw.com.finalproj.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sportview")
public class SportViewBean {
	@Id
	@Column(name = "sportid")
	private Integer sportid;
	
	@Column(name = "useraccount")
	private String useraccount;
	
	@Column(name = "sporting")
	private String sporting;
	
	@Column(name = "calorieexpenditure")
	private Float calorieexpenditure;
	
	@Column(name = "sportdate")
	private java.util.Date sportdate;
	
	@Column(name ="sporthour")
	private Float sporthour;

	@Override
	public String toString() {
		return "SportViewBean [" + sportid + ", " + useraccount + ", " + sporting + ", " + calorieexpenditure + ", "
				+ sportdate + ", " + sporthour + "]";
	}

	public Integer getSportid() {
		return sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getSporting() {
		return sporting;
	}

	public void setSporting(String sporting) {
		this.sporting = sporting;
	}

	public Float getCalorieexpenditure() {
		return calorieexpenditure;
	}

	public void setCalorieexpenditure(Float calorieexpenditure) {
		this.calorieexpenditure = calorieexpenditure;
	}

	public java.util.Date getSportdate() {
		return sportdate;
	}

	public void setSportdate(java.util.Date sportdate) {
		this.sportdate = sportdate;
	}

	public Float getSporthour() {
		return sporthour;
	}

	public void setSporthour(Float sporthour) {
		this.sporthour = sporthour;
	}

}
