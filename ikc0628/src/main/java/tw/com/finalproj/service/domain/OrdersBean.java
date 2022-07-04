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
@Table(name = "orders")
public class OrdersBean {
	@Id
	@Column(name = "orderid ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	
	@Column(name = "useraccount")
	private String useraccount;
	
	@Column(name = "ordertime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ordertime;
	
	@Column(name = "orderendtime")
	@Temporal(TemporalType.DATE)
	private java.util.Date orderendtime;
	
	@Column(name = "orderadress")
	private String orderadress;
	
	@Column(name = "orderarea")
	private String orderarea;
	
	@Column(name = "orderstatus")
	private String orderstatus;
	
	@Column(name = "payment")
	private String payment;
	
	@Column(name = "delivery")
	private String delivery;

	@Override
	public String toString() {
		return "ordersbean [" + orderid + ", " + useraccount + ", " + ordertime + ", " + orderendtime + ", "
				+ orderadress + ", " + orderarea + ", " + orderstatus + ", " + payment + ", " + delivery + "]";
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public java.util.Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(java.util.Date ordertime) {
		this.ordertime = ordertime;
	}

	public java.util.Date getOrderendtime() {
		return orderendtime;
	}

	public void setOrderendtime(java.util.Date orderendtime) {
		this.orderendtime = orderendtime;
	}

	public String getOrderadress() {
		return orderadress;
	}

	public void setOrderadress(String orderadress) {
		this.orderadress = orderadress;
	}

	public String getOrderarea() {
		return orderarea;
	}

	public void setOrderarea(String orderarea) {
		this.orderarea = orderarea;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

}
