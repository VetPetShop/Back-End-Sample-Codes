package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PostOffices")
public class PostOffice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postOfficeId;

	@Column
	private String postOfficeName;

	@ManyToOne
	@JoinColumn(name = "cityId", referencedColumnName = "cityId")
	private City cityId;

}
