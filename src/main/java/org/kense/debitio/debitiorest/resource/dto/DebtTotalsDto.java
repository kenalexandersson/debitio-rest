package org.kense.debitio.debitiorest.resource.dto;

import java.math.BigDecimal;

public class DebtTotalsDto {

    private String username;

    private BigDecimal amount;

    public DebtTotalsDto(String username, BigDecimal amount) {
        this.username = username;
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
