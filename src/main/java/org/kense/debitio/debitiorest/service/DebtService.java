package org.kense.debitio.debitiorest.service;

import org.kense.debitio.debitiorest.repository.DebtRepository;
import org.kense.debitio.debitiorest.repository.entity.Debt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DebtService {

    @Autowired
    private DebtRepository debtRepository;

    public Set<Debt> getDebts(Long userId) {
        return debtRepository.getDebts(userId);
    }

    public Set<Debt> getDebts(Long userId, Long happeningId) {
        return debtRepository.getDebts(userId, happeningId);
    }

    public Set<Debt> getDebtsForHappening(Long happeningId) {
        return debtRepository.getDebtsForHappening(happeningId);
    }

    public Set<Debt> getDebtsToClaimingUser(Long userId, Long claimingUser) {
        return getDebts(claimingUser).stream()
                .filter(debt -> userId.equals(debt.getToUser().getId()))
                .collect(Collectors.toSet());
    }

    public Map<String, BigDecimal> getDebtsTotal(Long userId) {

        DebtTotal debtTotal = DebtTotal.of(userId);

        Set<Debt> debts = debtRepository.getDebts(userId);

        // Add total for all people owing me
        debts.stream()
                .filter(debt -> userId.equals(debt.getFromUser().getId()))
                .forEach(debt -> debtTotal.add(debt.getAmount(), debt.getToUser()));

        // Subtract total for all people that I owe
        debts.stream()
                .filter(debt -> userId.equals(debt.getToUser().getId()))
                .forEach(debt -> debtTotal.subtract(debt.getAmount(), debt.getFromUser()));


        return debtTotal.getTotals();
    }
}
