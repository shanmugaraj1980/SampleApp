package com.virtusa.sample.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.Length
import org.joda.time.DateTime

@Entity
@Table(name = "PATIENT")
class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@NotNull
	@Length(max = 100)
	@Column(name = "first_name", length = 100, nullable = false)
	String firstName;

	@Column(name = "last_name")
	String lastName;

	@Length(max = 1)
	@Column(length = 1)
	String gender;

	@Length(max = 100)
	@Column(length = 100)
	String email;

	@ManyToOne
	Address address;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "dob", nullable = true)
	DateTime dob;

}
