package com.sg.sherlock.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "sherlock_response", schema = "sherlock", indexes = {
		@Index(name = "idx_sher_res_lead_id", columnList = "lead_id, customer_id"),
		@Index(name = "idx_res_case_id", columnList = "case_id") })
public class SherlockResponse extends AuditStamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "lead_id")
	private String leadId;

	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "xml_report")
	private String xmlReport;

	@Column(name = "html_report")
	private String htmlReport;

	@Column(name = "status")
	private String status;

	@Column(name = "score")
	private String score;

	@OneToOne
	@JoinColumn(name = "case_id", referencedColumnName = "case_id", nullable = false)
	private SherlockRequest sherlockRequest;

}
