package org.webwork.find.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="alert_message", catalog="webwork")
public class AlertMessage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private int id;
	
	@Column(name="message", nullable=true)
	private String message;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fromDate", nullable=true)
	private Date from;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="toDate", nullable=true)
	private Date to;
	
	public AlertMessage(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
	
	

}
