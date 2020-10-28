package com.designPatterns.BuilderPattern;

//The concrete builder for UserWebDTO (known as the product class)

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {

    //UserWebDTO name will combine firstName and lastName
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserWebDTO dto;

    //the return of each method stores the ultimate UserWebDTO object on calling build()

    @Override
    public UserDTOBuilder withFirstName(String fname) {
        firstName = fname;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lname) {
        lastName = lname;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate date) {
        Period yearsOld = Period.between(date, LocalDate.now());
        age = Integer.toString(yearsOld.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address.getHouseNumber() + ", " + address.getStreet() + "\n" + address.getCity() + "\n" +
                address.getState() + " " + address.getZipcode();
        return this;
    }

    //more fractured constructor to UserDTO
    @Override
    public UserDTO build() {
        dto = new UserWebDTO(firstName + " " + lastName, address, age);
        return dto;
    }

    @Override
    public UserDTO getUserDTO() {
        return dto;
    }
}
