package org.kense.debitio.debitiorest.resource;

import com.googlecode.jmapper.JMapper;
import org.kense.debitio.debitiorest.repository.HappeningRepository;
import org.kense.debitio.debitiorest.repository.entity.Debt;
import org.kense.debitio.debitiorest.repository.entity.Happening;
import org.kense.debitio.debitiorest.resource.dto.DebtDto;
import org.kense.debitio.debitiorest.resource.dto.HappeningDto;
import org.kense.debitio.debitiorest.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class DebitioResource {

    @Autowired
    private HappeningRepository happeningRepository;

    @Autowired
    private DebtService debtService;

    @GetMapping("/happenings")
    public Set<HappeningDto> retrieveAllHappenings() {

        Set<Happening> happenings = happeningRepository.getHappenings();

        return mapToHappeningDto(happenings).stream()
                .sorted(Comparator.comparing(HappeningDto::getOfficialDateTime).reversed())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @GetMapping("/debts/{userId}")
    public Set<DebtDto> retrieveDebts(@PathVariable Long userId) {

        Set<Debt> debts = debtService.getDebts(userId);
        return mapToDebtDto(debts);
    }

    @GetMapping("/debts/{userId}/totals")
    public Map<String, BigDecimal> retrieveDebtsTotal(@PathVariable Long userId) {

        return debtService.getDebtsTotal(userId);
    }

    @GetMapping("/debts/{userId}/happenings/{happeningId}")
    public Set<DebtDto> retrieveDebts(@PathVariable Long userId, @PathVariable Long happeningId) {

        Set<Debt> debts = debtService.getDebts(userId, happeningId);
        return mapToDebtDto(debts);
    }

    @GetMapping("/happenings/{happeningId}")
    public Set<DebtDto> retrieveDebtsForHappening(@PathVariable Long happeningId) {

        Set<Debt> debts = debtService.getDebtsForHappening(happeningId);
        return mapToDebtDto(debts);
    }

    @GetMapping("/debts/{userId}/to/{claimingUser}")
    public Set<DebtDto> retrieveDebtsTo(@PathVariable Long userId, @PathVariable Long claimingUser) {

        Set<Debt> debts = debtService.getDebtsToClaimingUser(userId, claimingUser);
        return mapToDebtDto(debts);
    }

    private Set<HappeningDto> mapToHappeningDto(Set<Happening> happenings) {

        return happenings.stream()
                .map(happening -> new HappeningDto(happening, mapToDebtDto(happening.getDebtList())))
                .collect(Collectors.toSet());
    }

    private Set<DebtDto> mapToDebtDto(Set<Debt> debts) {

        JMapper<DebtDto, Debt> mapper = new JMapper<>(DebtDto.class, Debt.class);
        return debts.stream()
                .map(mapper::getDestination)
                .collect(Collectors.toSet());
    }
}
