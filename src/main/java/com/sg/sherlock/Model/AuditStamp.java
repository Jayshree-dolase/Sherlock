package com.sg.sherlock.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditStamp {

	@CreationTimestamp
	@Column(updatable = false, name = "created_on")
	private LocalDateTime createdOn;

	@UpdateTimestamp
	@Column(name = "update_on")
	private LocalDateTime updateOn;

	@CreatedBy
	@Column(name = "create_by")
	private String createdBy;

	@LastModifiedBy
	@Column(name = "modified_by")
	private String modifiedBy;

	@Version
	@Column(name = "version")
	private Integer version;

}
