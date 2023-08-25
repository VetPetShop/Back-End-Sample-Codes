package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Sellers")
public class Seller {

	@Id
	private String gstNo;

	@OneToOne
	@JoinColumn(name = "sellerId", referencedColumnName = "userId")
	private User sellerId;

	public Seller(String gstNo) {
		super();
		this.gstNo = gstNo;
		
	}

}
