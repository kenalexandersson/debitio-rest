package org.kense.debitio.debitiorest.service;

import org.junit.jupiter.api.Test;
import org.kense.debitio.debitiorest.repository.entity.User;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DebtTotalTest {

    @Test
    void debtTotal_add() {

        User claimingUser = createUser(1,"claimingUser");
        User toUser1 = createUser(2,"toUser1");
        User toUser2 = createUser(3,"toUser2");

        DebtTotal debtTotal = DebtTotal.of(claimingUser.getId());
        debtTotal.add(new BigDecimal(78), toUser1);
        debtTotal.add(new BigDecimal(105), toUser2);
        debtTotal.add(new BigDecimal(22), toUser1);
        debtTotal.add(new BigDecimal(145), toUser2);

        assertThat(debtTotal.getTotalFor(toUser1)).isEqualTo(new BigDecimal(100));
        assertThat(debtTotal.getTotalFor(toUser2)).isEqualTo(new BigDecimal(250));
    }

    @Test
    void debtTotal_subtract() {

        User claimingUser = createUser(1,"claimingUser");
        User toUser1 = createUser(2,"toUser1");
        User toUser2 = createUser(3,"toUser2");

        DebtTotal debtTotal = DebtTotal.of(claimingUser.getId());
        debtTotal.add(new BigDecimal(80), toUser1);
        debtTotal.add(new BigDecimal(200), toUser2);
        debtTotal.subtract(new BigDecimal(100), toUser1);
        debtTotal.subtract(new BigDecimal(200), toUser2);

        assertThat(debtTotal.getTotalFor(toUser1)).isEqualTo(new BigDecimal(-20));
        assertThat(debtTotal.getTotalFor(toUser2)).isEqualTo(new BigDecimal(0));
    }

    private User createUser(long userId, String username) {
        User user = new User();
        user.setId(userId);
        user.setUserName(username);

        return user;
    }
}