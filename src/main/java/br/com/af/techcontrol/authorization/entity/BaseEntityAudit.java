package br.com.af.techcontrol.authorization.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Getter
	@CreatedBy
	private String createdBy;

	@Getter
	@CreatedDate
	private LocalDateTime createdDate;

	@Getter
	@LastModifiedBy
	private String lastModifiedBy;

	@Getter
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

}
