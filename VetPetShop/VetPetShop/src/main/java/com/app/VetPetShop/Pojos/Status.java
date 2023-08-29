package com.app.VetPetShop.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Status")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
	
	@Enumerated(EnumType.STRING)
	private Statuses status;
	
	@OneToMany(mappedBy = "statusId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Payments> payments = new ArrayList<Payments>();
	
	@OneToMany(mappedBy = "statusId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orders = new ArrayList<Orders>();

	public Status(Statuses status) {
		super();
		this.status = status;
	}

	public Status() {
		super();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Statuses getStatus() {
		return status;
	}

	public void setStatus(Statuses status) {
		this.status = status;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + ", payments=" + payments + ", orders=" + orders
				+ "]";
	}

}
