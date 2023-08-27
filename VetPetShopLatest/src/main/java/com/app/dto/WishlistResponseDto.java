package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.app.pojo.Pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishlistResponseDto {
	private Long id;
	private List<Pet> petsInWishlist = new ArrayList<>();
}
