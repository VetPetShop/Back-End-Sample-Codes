package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;

	@Column(unique = true)
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "districtId", referencedColumnName = "districtId")
	private District districtId;

	public City(String cityName) {
		super();
		this.cityName = cityName;
	}
}
