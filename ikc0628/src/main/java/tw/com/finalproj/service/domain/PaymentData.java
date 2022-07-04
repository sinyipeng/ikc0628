package tw.com.finalproj.service.domain;

public class PaymentData {
	public String amount;
	public String currency;
	public String paymentmethodtype;
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPaymentmethodtype() {
		return paymentmethodtype;
	}
	public void setPaymentmethodtype(String paymentmethodtype) {
		this.paymentmethodtype = paymentmethodtype;
	}
}
