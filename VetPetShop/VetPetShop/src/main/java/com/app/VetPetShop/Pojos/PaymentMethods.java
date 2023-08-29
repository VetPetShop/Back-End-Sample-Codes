package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class PaymentMethods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payMethodId;
	
	@Column
	private String payMethodName; // UPI, COD, CREDIT, DEBIT,...
	
	@OneToMany(mappedBy = "payMethodId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PaymentMethod> paymentmethods = new ArrayList<PaymentMethod>();

	public PaymentMethods(String payMethodName) {
		super();
		this.payMethodName = payMethodName;
	}

	public PaymentMethods() {
		super();
	}

	public int getPayMethodId() {
		return payMethodId;
	}

	public void setPayMethodId(int payMethodId) {
		this.payMethodId = payMethodId;
	}

	public String getPayMethodName() {
		return payMethodName;
	}

	public void setPayMethodName(String payMethodName) {
		this.payMethodName = payMethodName;
	}

	public List<PaymentMethod> getPaymentmethods() {
		return paymentmethods;
	}

	public void setPaymentmethods(List<PaymentMethod> paymentmethods) {
		this.paymentmethods = paymentmethods;
	}

	@Override
	public String toString() {
		return "PaymentMethods [payMethodId=" + payMethodId + ", payMethodName=" + payMethodName + ", paymentmethods="
				+ paymentmethods + "]";
	}
	
}
