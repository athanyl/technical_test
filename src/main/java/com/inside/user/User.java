package com.inside.user;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    
    @Column(name = "name")
    private String name;
    
    @Column(name = "birthDate")
    private Date birthDate;
    
    @Column(name = "countryOfResidence")
    private String countryOfResidence;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;
    
    public User(){}
	
    public User(String name, Date birthDate, String countryOfResidence, String phoneNumber, String gender) {
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
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
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
