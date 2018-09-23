package org.kense.debitio.debitiorest.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users_tab")
public class User {

    @Id
    private long id;
	@Column(name = "user_name")
	private String userName;
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "family_name")
	private String familyName;
	private int gender;
	private int level;
	private String email;
	@Column(name = "registration_email")
	private String emailRegistration;
	private String webpage;
	private String sms;
	private String account;
	@Column(name = "registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	@Column(name = "last_logon")
	private Date lastLogon;
	@Column(name = "bulletines_date")
	private Date bulletinesDate;
	
	public User() { 
		
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailRegistration() {
		return emailRegistration;
	}
	public void setEmailRegistration(String emailRegistration) {
		this.emailRegistration = emailRegistration;
	}
	public String getWebpage() {
		return webpage;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getLastLogon() {
		return lastLogon;
	}
	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}
	public Date getBulletinesDate() {
		return bulletinesDate;
	}
	public void setBulletinesDate(Date bulletinesDate) {
		this.bulletinesDate = bulletinesDate;
	}
	
	
}
