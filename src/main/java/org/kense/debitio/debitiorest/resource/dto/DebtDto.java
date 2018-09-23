package org.kense.debitio.debitiorest.resource.dto;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.annotations.JMapConversion;
import org.kense.debitio.debitiorest.repository.entity.Happening;
import org.kense.debitio.debitiorest.repository.entity.User;

import java.math.BigDecimal;

public class DebtDto {

    @JMap("id")
    private long debtId;

    @JMap("happening")
    private long happeningId;

    @JMap("happening")
    private String happeningName;

    @JMap
    private BigDecimal amount;

    @JMap
    private String comment;

    @JMap("fromUser")
    private String fromUserName;

    @JMap("toUser")
    private String toUserName;

    public long getDebtId() {
        return debtId;
    }

    public void setDebtId(long debtId) {
        this.debtId = debtId;
    }

    public long getHappeningId() {
        return happeningId;
    }

    public void setHappeningId(long happeningId) {
        this.happeningId = happeningId;
    }

    public String getHappeningName() {
        return happeningName;
    }

    public void setHappeningName(String happeningName) {
        this.happeningName = happeningName;
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

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    @JMapConversion(from = {"happening"}, to = {"happeningId"})
    public long convertHappeningId(Happening happening) {
        return happening.getId();
    }

    @JMapConversion(from = {"happening"}, to = {"happeningName"})
    public String convertHappeningName(Happening happening) {
        return happening.getHappening();
    }

    @JMapConversion(from = {"fromUser"}, to = {"fromUserName"})
    public String convertFromUser(User user) {
        return user.getUserName();
    }

    @JMapConversion(from = {"toUser"}, to = {"toUserName"})
    public String convertToUser(User user) {
        return user.getUserName();
    }
}
