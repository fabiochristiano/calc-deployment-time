package br.com.fchristiano.calcdeploymenttime.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "deployments_time")
public class DeploymentTime implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@NotNull
	@Column(name = "component")
	private String component;

	@NotNull
	@Column(name = "action")
	private String action;

	@NotNull
	@Column(name = "version")
	private String version;

	@Column(name = "status")
	private String status;

	@NotNull
	@Column(name = "date")
	private Date date;

	// Public methods
	public DeploymentTime() {
	}

	public DeploymentTime(long id) {
		this.id = id;
	}

	public DeploymentTime(String component, String action, String version, Date date) {
		this.component = component;
		this.action = action;
		this.version = version;
		this.date = date;
	}

	public DeploymentTime(String component, String action, String version, Date date, String status) {
		this.component = component;
		this.action = action;
		this.version = version;
		this.date = date;
		this.status = status;
	}

	// Getter and setter methods
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getBuildNumber() {
		return version;
	}

	public void setBuildNumber(String buildNumber) {
		this.version = buildNumber;
	}

	public String getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
