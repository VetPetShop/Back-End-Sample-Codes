package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UserType")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;

	@Enumerated(EnumType.STRING)
	private UserTypeEnum userType;

}
