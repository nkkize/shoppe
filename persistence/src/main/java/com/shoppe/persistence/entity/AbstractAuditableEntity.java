package com.shoppe.persistence.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.transaction.Status;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NarenderK
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractPersistable<Long>
		implements Auditable<String, Long> {

	@Version
	@Column(name = "version")
	protected Long version;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("createdDate")
	protected DateTime createdDate;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("lastModifiedDate")
	protected DateTime lastModifiedDate;

	protected String createdBy;

	protected String lastModifiedBy;

	@Enumerated(EnumType.STRING)
	protected Status status;
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
