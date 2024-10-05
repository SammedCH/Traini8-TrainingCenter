package com.traini8_TrainingCenter.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//import javax.validation.constraints.Size
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a Training Center entity with details such as name, code, address, 
 * student capacity, courses offered, contact details, and creation timestamp.
 */

@Entity
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max = 40)
    private String centerName;

    //This regular expression matches a string that starts with 4 letters, followed by 8 numbers.
    @Column(nullable = false, unique = true)
    @Size(min = 12, max = 12)
    @Pattern(regexp = "^[a-zA-Z]{4}[0-9]{8}$")
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false, updatable = false)
    private Long createdOn;

    //Added unique=true to check if email already existed
    @Column(nullable = false, unique=true)
    @Email
    private String contactEmail;

    @Column(nullable = false)
    @Pattern(regexp = "\\d{10}")
    private String contactPhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	@JsonIgnore
    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        // ignore user input and set the current timestamp
        this.createdOn = System.currentTimeMillis();
    }

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

    
}
