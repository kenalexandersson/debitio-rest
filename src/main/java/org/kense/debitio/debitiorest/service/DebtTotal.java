package org.kense.debitio.debitiorest.service;

import org.kense.debitio.debitiorest.repository.entity.User;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class DebtTotal {

    private long claimingUserId;

    private Map<String, BigDecimal> totals = new HashMap<>();

    static DebtTotal of(long claimingUserId) {
        return new DebtTotal(claimingUserId);
    }

    private DebtTotal(long claimingUserId) {
        this.claimingUserId = claimingUserId;
    }

    void add(BigDecimal amount, User toUser) {

        BigDecimal current = getCurrentValueForUser(toUser.getUserName());
        totals.replace(toUser.getUserName(), current.add(amount));
    }

    void subtract(BigDecimal amount, User fromUser) {
        BigDecimal current = getCurrentValueForUser(fromUser.getUserName());
        totals.replace(fromUser.getUserName(), current.subtract(amount));
    }

    public long getClaimingUserId() {
        return claimingUserId;
    }

    Map<String, BigDecimal> getTotals() {
        return totals;
    }

    BigDecimal getTotalFor(User user) {
        return totals.get(user.getUserName());
    }

    private BigDecimal getCurrentValueForUser(String username) {
        totals.putIfAbsent(username, new BigDecimal(0));
        return totals.get(username);
    }

}
