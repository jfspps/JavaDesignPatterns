package com.designPatterns.BuilderPattern;

import java.time.LocalDate;

// the main director bringing together objects, in the correct order, to build other objects

public class Client {

	public static void main(String[] args) {
		User user = createUser();		//can come from a DB
		UserDTOBuilder builder = new UserWebDTOBuilder();

		UserDTO userDTO = directBuild(builder, user);

		System.out.println(userDTO);
	}

	private static UserDTO directBuild(UserDTOBuilder userDTOBuilder, User user){
		return userDTOBuilder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withAddress(user.getAddress())
				.withBirthday(user.getBirthday()).build();
	}

	/**
	 * Returns a sample user. 
	 */
	public static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}
}
