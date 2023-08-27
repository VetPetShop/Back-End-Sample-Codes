package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_offices")
public class PostOffice extends BaseEntity {

//	@PrimaryKeyJoinColumn
//	@ManyToOne
//	@JoinColumn(name = "postoffice", nullable = false)
//	private City cityId;

//	@PrimaryKeyJoinColumn
//	@ManyToOne
//	@JoinColumn(name = "district_id")
//	private District districtId;
//	
//	@PrimaryKeyJoinColumn
//	@ManyToOne
//	@JoinColumn(name = "district_id")
//	private District districtId;

	@OneToMany(mappedBy = "postOfficeId", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<User> users;

//	@Column
//	private String cityName;
//
//	@PrimaryKeyJoinColumn
//	@ManyToOne
//	@JoinColumn(name = "district_id")
//	private District districtId;
//
//	@OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL, orphanRemoval = true)
//	List<PostOffice> postOffices;

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City cityId;
	
	


}
