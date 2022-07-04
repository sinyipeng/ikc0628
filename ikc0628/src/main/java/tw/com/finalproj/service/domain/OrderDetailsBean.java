package tw.com.finalproj.service.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetailsBean {
	@Id
	@Column(name = "orderdetailid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderdetailid;
	
	@Column(name = "orderid")
	private Integer orderid;
	
	@Column(name = "productid")
	private Integer productid;
	
	@Column(name = "unitprice")
	private Integer unitprice;
	
	@Column(name = "orderquantity")
	private Byte orderquantity;
	
	@Column(name = "discount")
	private Float discount;

	@Override
	public String toString() {
		return "OrderDetailsBean [" + orderdetailid + ", " + orderid + ", " + productid + ", " + unitprice + ", "
				+ orderquantity + ", " + discount + "]";
	}

	public Integer getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(Integer orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Byte getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(Byte orderquantity) {
		this.orderquantity = orderquantity;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}
}
