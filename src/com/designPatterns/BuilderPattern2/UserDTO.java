package com.designPatterns.BuilderPattern2;

import com.designPatterns.BuilderPattern.Address;

import java.time.LocalDate;
import java.time.Period;

//Product class (DTO - data transfer object)
public class UserDTO {

	private String name;
	
	private String address;
	
	private String age;

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getAge() {
		return age;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	private void setAddress(String address) {
		this.address = address;
	}

	private void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address ;
	}

	//Get builder instance (common practice, and optional, since the builder class is public)
	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}

	//Builder (declared within the class that it builds objects of) ==============================================
	public static class UserDTOBuilder {
		
		private String firstName;
		
		private String lastName;
		
		private String age;
		
		private String address;
		
		private UserDTO userDTO;		// link between the Builder and the object it builds (UserDTO)

		//chain methods (note how they return the UserDTOBuilder object; this permits chaining)
		public UserDTOBuilder withFirstName(String fname) {
			this.firstName = fname;
			return this;
		}
		
		public UserDTOBuilder withLastName(String lname) {
			this.lastName = lname;
			return this;
		}
		
		public UserDTOBuilder withBirthday(LocalDate date) {
			this.age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + " " +address.getStreet()
						+ "\n"+address.getCity()+", "+address.getState()+" "+address.getZipcode();
			return this;
		}

		// use the private setters of the outer class and return an object of its type (this means one can build
		// an immutable object within the class; external classes cannot access private setters; the policies of the
		// builder are also easier to locate)
		public UserDTO build() {
			this.userDTO = new UserDTO();
			userDTO.setName(firstName + " " + lastName);
			userDTO.setAddress(address);
			userDTO.setAge(age);
			return this.userDTO;
		}
		
		public UserDTO getUserDTO() {
			return this.userDTO;
		}
	}
}
