package com.app.VetPetShop;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.VetPetShop.DTO.NewPetDto;
import com.app.VetPetShop.Pojos.Pets;

@SpringBootApplication
@EnableAutoConfiguration
public class VetPetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetPetShopApplication.class, args);
	}
	@Bean
	public ModelMapper mapper()
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		//custom mapping for associations
		mapper.createTypeMap(Pets.class, NewPetDto.class)
        .addMappings(mapr -> {
        	mapr.map(src -> src.getBreedId().getBreedName(), NewPetDto::setBreedName);
            mapr.map(src -> src.getSellerId().getSellerId().getFirstName(), NewPetDto::setSellerFirstName);
            mapr.map(src -> src.getSellerId().getSellerId().getLastName(), NewPetDto::setSellerLastName);
        });
		
		return mapper;
	}
	
	@Bean
    public UriComponents uriComponents() {
        return UriComponentsBuilder.newInstance().build();
    }
	
	

}
