package com.sg.sherlock.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "id_data", schema = "sherlock")
public class KycDetails extends AuditStamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_data")
	private Long id;

	@Column(name="passport_number")
	private String passportNumber;

	@Column(name="voter_id")
	private String voterId;

	@Column(name="uid")
	private String uid;

	@Column(name="ration_card_number")
	private String rationCardNumber;

	@Column(name="driving_license_number")
	private String drivingLicenseNumber;

	@Column(name="pan")
	private String pan;
	
	@Column(name="nrega_card_number")
	private String nregaCardNumber;

	@Column(name="ckyc")
	private String ckyc;

	@Column(name="other")
	private String other;

	@OneToOne
	@JoinColumn(name="sherlock_request_fk")
	@JsonBackReference
	private SherlockRequest sherlockRequest;

}
