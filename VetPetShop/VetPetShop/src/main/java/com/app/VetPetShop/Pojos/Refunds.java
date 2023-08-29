package com.app.VetPetShop.Pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Refunds")
public class Refunds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refundId;
	
	@OneToOne
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Orders orderId;
	
	@OneToOne
	@JoinColumn(name = "issueId",referencedColumnName = "issueId")
	private Issues issueId;
	
	@OneToOne
	@JoinColumn(name = "statusId",referencedColumnName = "statusId")
	private Status statusId;

	public Refunds() {
		super();
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Issues getIssueId() {
		return issueId;
	}

	public void setIssueId(Issues issueId) {
		this.issueId = issueId;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "Refunds [refundId=" + refundId + ", orderId=" + orderId + ", issueId=" + issueId + ", statusId="
				+ statusId + "]";
	}
	
}
