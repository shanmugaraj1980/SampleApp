package com.virtusa.sample.domain

import javax.persistence.*

import org.hibernate.validator.constraints.Length

/**
 * A Address.
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Length(max = 100)
	@Column(name = "line1", length = 100)
	String line1;

	@Length(max = 100)
	@Column(name = "line2", length = 100)
	String line2;

	@Length(max = 50)
	@Column(name = "city", length = 50)
	String city;

	@Length(max = 9)
	@Column(name = "zip", length = 9)
	String zip;

	@Column(name = "phone1", length = 10)
	String phone1;

	@Column(name = "phone2", length = 10)
	String phone2;
	
	@Column(name = "state", length = 50)
	String state;
}
