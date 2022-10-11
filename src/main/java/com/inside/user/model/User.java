package com.inside.user.model;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.inside.user.Validator.Age;
import com.inside.user.Validator.Authorized;

@Entity
@Table(name = "users")
public class User {
    public static final String[] AUTHORIZEDCOUNTRIES = new String[]{"France"};
    public static final String[] AUTHORIZEDGENDERS = new String[]{"M","F"};
    public static final long AGEMIN = 18;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String name;
    
    @NotNull(message = "Birth Date cannot be empty")
    @Age(AGEMIN)
    @Column(name = "birthDate")
    private LocalDate birthDate;
    
    @NotEmpty(message = "Country of Residence cannot be empty")
    @Authorized("country")
    @Column(name = "countryOfResidence")
    private String countryOfResidence;

    @NotNull
    @Pattern(regexp = "^$|^((\\+)33|0)[1-9](\\d{2}){4}$", message = "Must be a valid French Phone Number : 0102030405")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @NotNull
    @Authorized("gender")
    @Column(name = "gender")
    private String gender;
    
    public User(){}
	
    public User(String name, LocalDate birthDate, String countryOfResidence, String phoneNumber, String gender) {
		this.name = name;
		this.birthDate = birthDate;
		this.countryOfResidence = countryOfResidence;
        this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getCountryOfResidence() {
        return countryOfResidence;
    }
    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}
