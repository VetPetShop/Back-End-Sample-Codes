package com.app.VetPetShop.Pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Issues")
public class Issues {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issueId;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Users userId;
	
	@Enumerated(EnumType.STRING)
	private IssueCategories issueCategory;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Orders orderId;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	public Issues(IssueCategories issueCategory, String description) {
		super();
		this.issueCategory = issueCategory;
		this.description = description;
	}

	public Issues() {
		super();
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public IssueCategories getIssueCategory() {
		return issueCategory;
	}

	public void setIssueCategory(IssueCategories issueCategory) {
		this.issueCategory = issueCategory;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Issues [issueId=" + issueId + ", userId=" + userId + ", issueCategory=" + issueCategory + ", orderId="
				+ orderId + ", description=" + description + "]";
	}
	
}
