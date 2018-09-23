package org.kense.debitio.debitiorest.service;

import org.kense.debitio.debitiorest.repository.entity.User;

import java.math.BigDecimal;

public class DebtTotal {

    private User claimingUser;

    private User indebtedUser;

    private BigDecimal total;

    public User getClaimingUser() {
        return claimingUser;
    }

    public void setClaimingUser(User claimingUser) {
        this.claimingUser = claimingUser;
    }

    public User getIndebtedUser() {
        return indebtedUser;
    }

    public void setIndebtedUser(User indebtedUser) {
        this.indebtedUser = indebtedUser;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
