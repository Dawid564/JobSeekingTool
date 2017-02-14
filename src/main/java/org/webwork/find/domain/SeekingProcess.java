package org.webwork.find.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="seekingProcess", catalog="webwork", uniqueConstraints = @UniqueConstraint(columnNames = {"userName", "processName"}))
public class SeekingProcess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userName", nullable = false)
	private User user;
	
	@Column(name="processName", nullable = false)
	private String processName = null;
	
	@Column(name="awaitSalary", nullable = false)
	private String awaitSalary;
	
	@Column(name="comapnyName", nullable = false)
	private String companyName;
	
	@Column(name="companyDescription", nullable = false)
	private String companyDescription;
	
	@Column(name="dataResumeSend", nullable = false)
	private String dataResumeSend;
	
	@Column(name="contactEmail", nullable = false)
	private String contactEmail;
	
	@Column(name="contactPhone", nullable = false)
	private String contactPhone;
	
	@Column(name="sendResume", nullable = false, columnDefinition = "boolean default false")
	private boolean sendResume;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="responseDate", nullable = true)
	private Date responseDate;
	
	///////////////////////////////////////////////////////////Second Mile Stone
	
	@Column(name="questionsPhoneCall", nullable = false)
	private String questionsPhoneCall;
	
	@Column(name="notesPhoneCall", nullable = false)
	private String notesPhoneCall;
	
	@Column(name="weakness", nullable = false)
	private String weakness;
	
	@Column(name="strengths", nullable = false)
	private String strengths;
	
	/////////////////////////////////////////////////////////Third Mile Stone
	
	@Column(name="rightClothing", nullable = false)
	private boolean rightClothing;
	
	@Column(name="remindResume", nullable = false)
	private boolean remindResume;
	
	@Column(name="importantDocs", nullable = false)
	private boolean importantDocs;
	
	@Column(name="interviewPlace", nullable = false)
	private String interviewPlace;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="interviewTime", nullable = true)
	private Date interviewTime;

	
	public boolean isRightClothing() {
		return rightClothing;
	}

	public void setRightClothing(boolean rightClothing) {
		this.rightClothing = rightClothing;
	}

	public boolean isRemindResume() {
		return remindResume;
	}

	public void setRemindResume(boolean remindResume) {
		this.remindResume = remindResume;
	}

	public boolean isImportantDocs() {
		return importantDocs;
	}

	public void setImportantDocs(boolean importantDocs) {
		this.importantDocs = importantDocs;
	}

	public String getInterviewPlace() {
		return interviewPlace;
	}

	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace;
	}

	public Date getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public String getQuestionsPhoneCall() {
		return questionsPhoneCall;
	}

	public void setQuestionsPhoneCall(String questionsPhoneCall) {
		this.questionsPhoneCall = questionsPhoneCall;
	}

	public String getNotesPhoneCall() {
		return notesPhoneCall;
	}

	public void setNotesPhoneCall(String notesPhoneCall) {
		this.notesPhoneCall = notesPhoneCall;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(String strengths) {
		this.strengths = strengths;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public boolean isSendResume() {
		return sendResume;
	}

	public void setSendResume(boolean sendResume) {
		this.sendResume = sendResume;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getDataResumeSend() {
		return dataResumeSend;
	}

	public void setDataResumeSend(String dataResumeSend) {
		this.dataResumeSend = dataResumeSend;
	}

	public int getId() {
		return id;
	}

	public String getAwaitSalary() {
		return awaitSalary;
	}

	public void setAwaitSalary(String awaitSalary) {
		this.awaitSalary = awaitSalary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SeekingProcess(){}
	
	public SeekingProcess(String processName){
		this.processName = processName;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}
}
