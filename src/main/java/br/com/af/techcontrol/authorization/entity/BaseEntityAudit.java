package br.com.af.techcontrol.authorization.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String createdBy;

	@Getter
	@Setter
	private String updatedBy;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	@Getter
	private LocalDateTime createdAt;

	@Column(nullable = false)
	@LastModifiedDate
	@Getter
	private LocalDateTime updatedAt;

}
