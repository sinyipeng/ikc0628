package tw.com.finalproj.service.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplies")
public class SuppliesBean {
	@Id
	@Column(name = "suppliesid ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer suppliesid ;

	@Column(name = "suppliesname ")
	private String suppliesname ;
	
	@Column(name = "contactperson ")
	private String contactperson ;
	
	@Column(name = "position ")
	private String position ;
	
	@Column(name = "suppliesphone ")
	private String suppliesphone ;
	
	@Column(name = "fax ")
	private String fax ;
	
	@Column(name = "suppliesadress ")
	private String suppliesadress ;

	@Column(name = "suppliesarea ")
	private String suppliesarea ;

	@Override
	public String toString() {
		return "SuppliesBean [" + suppliesid + ", " + suppliesname + ", " + contactperson + ", " + position + ", "
				+ suppliesphone + ", " + fax + ", " + suppliesadress + ", " + suppliesarea + "]";
	}

	public Integer getSuppliesid() {
		return suppliesid;
	}

	public void setSuppliesid(Integer suppliesid) {
		this.suppliesid = suppliesid;
	}

	public String getSuppliesname() {
		return suppliesname;
	}

	public void setSuppliesname(String suppliesname) {
		this.suppliesname = suppliesname;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSuppliesphone() {
		return suppliesphone;
	}

	public void setSuppliesphone(String suppliesphone) {
		this.suppliesphone = suppliesphone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSuppliesadress() {
		return suppliesadress;
	}

	public void setSuppliesadress(String suppliesadress) {
		this.suppliesadress = suppliesadress;
	}

	public String getSuppliesarea() {
		return suppliesarea;
	}

	public void setSuppliesarea(String suppliesarea) {
		this.suppliesarea = suppliesarea;
	}
}
