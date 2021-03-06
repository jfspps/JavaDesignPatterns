package com.designPatterns.BuilderPattern2;

import com.designPatterns.BuilderPattern.Address;
import com.designPatterns.BuilderPattern.User;
import com.designPatterns.BuilderPattern2.UserDTO.UserDTOBuilder;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
		User user = createUser();
		// Client has to provide director with concrete builder (DTO - data transfer object)
		UserDTO dto = directBuild(UserDTO.getBuilder(), user);

		//called directly (change the parameters as required); note the with_() methods are not all mandatory
		UserDTO userDTO_2 = new UserDTOBuilder()
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress()).build();

		System.out.println(dto);
		System.out.println("==============================");
		System.out.println(userDTO_2);
	}

	/**
	 * This method serves the role of director in builder pattern.
	 */
	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
		return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
				.withBirthday(user.getBirthday()).withAddress(user.getAddress()).build();
	}

	/**
	 * Returns a sample user. Simulates a DB datasource
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
