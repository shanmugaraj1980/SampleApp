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
@Table(name = "pmsn")
class Pmsn {
	@Id
	@Column(name = "pmsn_num", length = 11, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pmsnnum;

	@NotNull
	@Column(name = "pmsn_name", length = 255, nullable = false)
	String pmsnName;
	
	@NotNull
	@Column(name = "pmsn_desc", length = 255, nullable = false)
	String pmsnDesc;
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "row_add_stp", nullable = false)
	DateTime rowAddStp;
	
	@NotNull
	@Column(name = "row_add_userid", length = 255, nullable = false)
	String rowAddUserid;
	
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "row_update_stp", nullable = false)
	DateTime rowUpdateStp;
	
	
	@NotNull
	@Column(name = "row_update_userid", length = 255, nullable = false)
	String rowUpdateUserid;
	


}
