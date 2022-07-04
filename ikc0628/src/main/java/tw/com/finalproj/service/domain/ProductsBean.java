package tw.com.finalproj.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsBean {

	@Id
	@Column(name = "productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "suppliesid")
	private Integer suppliesid;
	
	@Column(name = "productimg")
	private String productimg;

	@Column(name = "standardcost")
	private Integer standardcost;
	
	@Column(name = "productstock")
	private Integer productstock;
	
	@Column(name = "productdescribe")
	private String productdescribe;
	
	@Column(name = "productstatus")
	private String productstatus;

	@Override
	public String toString() {
		return "ProductsBean [" + productid + ", " + productname + ", " + suppliesid + ", " + productimg + ", "
				+ standardcost + ", " + productstock + ", " + productdescribe + ", " + productstatus + "]";
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getSuppliesid() {
		return suppliesid;
	}

	public void setSuppliesid(Integer suppliesid) {
		this.suppliesid = suppliesid;
	}

	public String getProductimg() {
		return productimg;
	}

	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}

	public Integer getStandardcost() {
		return standardcost;
	}

	public void setStandardcost(Integer standardcost) {
		this.standardcost = standardcost;
	}

	public Integer getProductstock() {
		return productstock;
	}

	public void setProductstock(Integer productstock) {
		this.productstock = productstock;
	}

	public String getProductdescribe() {
		return productdescribe;
	}

	public void setProductdescribe(String productdescribe) {
		this.productdescribe = productdescribe;
	}

	public String getProductstatus() {
		return productstatus;
	}

	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}

}
