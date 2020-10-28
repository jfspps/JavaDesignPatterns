package com.designPatterns.BuilderPattern;

import java.time.LocalDate;

//Abstract builder (DTO - data transfer object); implemented by UserWebDTOBuilder

public interface UserDTOBuilder {
	//methods to build "parts" of product at a time (via method chaining)
	UserDTOBuilder withFirstName(String fname) ;

	UserDTOBuilder withLastName(String lname);

	UserDTOBuilder withBirthday(LocalDate date);

	UserDTOBuilder withAddress(Address address);

	//method to "assemble" final product (after running above chained methods)
	UserDTO build();

	//(optional) method to fetch already built object
	UserDTO getUserDTO();
}

