package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "cities")
public class City extends BaseEntity {

	@Column
	private String cityName;

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District districtId;

	@OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL, orphanRemoval = true)
	List<PostOffice> postOffices;
}
