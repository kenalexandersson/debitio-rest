package org.kense.debitio.debitiorest.repository.entity;

import com.googlecode.jmapper.annotations.JMapConversion;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "debt_tab")
public class Debt {

	@Id
	private long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "happening_id")
	private Happening happening;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "from_user_id")
	private User fromUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "to_user_id")
	private User toUser;
	
	private BigDecimal amount;
	private String comment;
	private String harvest;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Happening getHappening() {
		return happening;
	}
	public void setHappening(Happening happening) {
		this.happening = happening;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getHarvest() {
		return harvest;
	}
	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}
}
