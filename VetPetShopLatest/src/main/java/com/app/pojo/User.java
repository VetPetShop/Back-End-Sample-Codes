package com.app.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "users")
public class User extends BaseEntity {

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)

	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)

	private LocalDate dob;

	@Column(nullable = false)

	private String gender;

	@Column(unique = true)
	private Long phoneNumber;

	public Role role;

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "post_office_id", nullable = false)
	private PostOffice postOfficeId;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pet> pets;

	@OneToOne
	@JoinColumn(name = "wishlist_id", referencedColumnName = "id")
	private Wishlist wishlistId;

}
