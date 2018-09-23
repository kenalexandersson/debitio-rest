package org.kense.debitio.debitiorest.service;

import org.kense.debitio.debitiorest.repository.DebtRepository;
import org.kense.debitio.debitiorest.repository.entity.Debt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DebtService {

    @Autowired
    private DebtRepository debtRepository;

    public List<Debt> getDebts(Long userId) {
        return debtRepository.getDebts(userId);
    }

    public List<Debt> getDebts(Long userId, Long happeningId) {
        return debtRepository.getDebts(userId, happeningId);
    }

    public List<Debt> getDebtsToClaimingUser(Long userId, Long claimingUser) {
        return getDebts(userId).stream()
                .filter(debt -> claimingUser.equals(debt.getToUser().getId()))
                .collect(Collectors.toList());
    }

    public List<DebtTotal> getDebtsTotals(Long userId) {
        List<DebtTotal> debtTotals = new ArrayList<>();

        List<Debt> debts = debtRepository.getDebts(userId);

        return debtTotals;
    }
}
