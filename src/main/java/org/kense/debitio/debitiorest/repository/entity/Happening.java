package org.kense.debitio.debitiorest.repository.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "happening_tab")
public class Happening {

	@Id
	private long id;
	
	private String happening;
	
	@Column(name = "official_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date officialDate;
	
	@Column(name = "registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User owner;
	private String comment;
	
    @OneToMany(mappedBy = "happening", orphanRemoval = true,  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Debt> debtList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHappening() {
		return happening;
	}

	public void setHappening(String happening) {
		this.happening = happening;
	}

	public Date getOfficialDate() {
		return officialDate;
	}

	public void setOfficialDate(Date officialDate) {
		this.officialDate = officialDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<Debt> getDebtList() {
		return debtList;
	}

	public void setDebtList(Set<Debt> debtList) {
		this.debtList = debtList;
	}
}
