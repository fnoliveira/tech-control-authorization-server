package br.com.af.techcontrol.authorization.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Getter
	@JsonIgnore
	@CreatedBy
	private String createdBy;

	@JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
	@Getter
	@JsonIgnore
	@CreatedDate
	private LocalDateTime createdDate;

	@Getter
	@JsonIgnore
	@LastModifiedBy
	private String lastModifiedBy;

	@JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
	@Getter
	@JsonIgnore
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

}
