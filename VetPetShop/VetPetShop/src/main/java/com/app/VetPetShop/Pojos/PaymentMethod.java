package com.app.VetPetShop.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentMethod_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private Users userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payMethodId")
	private PaymentMethods payMethodId;
	
	@Column(columnDefinition = "TEXT")
	private String paymentDetails;

	public PaymentMethod(String paymentDetails) {
		super();
		this.paymentDetails = paymentDetails;
	}

	public PaymentMethod() {
		super();
	}

	public int getPaymentMethod_id() {
		return paymentMethod_id;
	}

	public void setPaymentMethod_id(int paymentMethod_id) {
		this.paymentMethod_id = paymentMethod_id;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public PaymentMethods getPayMethodId() {
		return payMethodId;
	}

	public void setPayMethodId(PaymentMethods payMethodId) {
		this.payMethodId = payMethodId;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String toString() {
		return "PaymentMethod [paymentMethod_id=" + paymentMethod_id + ", userId=" + userId + ", payMethodId="
				+ payMethodId + ", paymentDetails=" + paymentDetails + "]";
	}

}
