package org.kense.debitio.debitiorest.resource;

import com.googlecode.jmapper.JMapper;
import org.kense.debitio.debitiorest.repository.DebtRepository;
import org.kense.debitio.debitiorest.repository.HappeningRepository;
import org.kense.debitio.debitiorest.repository.entity.Debt;
import org.kense.debitio.debitiorest.repository.entity.Happening;
import org.kense.debitio.debitiorest.resource.dto.DebtDto;
import org.kense.debitio.debitiorest.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DebitioResource {

    @Autowired
    private HappeningRepository happeningRepository;

    @Autowired
    private DebtService debtService;

    @GetMapping("/happenings")
    public List<Happening> retrieveAllHappenings() {

       return happeningRepository.getHappenings();
    }

    @GetMapping("/debts/{userId}")
    public List<DebtDto> retrieveDebts(@PathVariable Long userId) {

        List<Debt> debts = debtService.getDebts(userId);
        return mapToDto(debts);
    }

    @GetMapping("/debts/{userId}/happenings/{happeningId}")
    public List<DebtDto> retrieveDebts(@PathVariable Long userId, @PathVariable Long happeningId) {

        List<Debt> debts = debtService.getDebts(userId, happeningId);
        return mapToDto(debts);
    }

    @GetMapping("/debts/{userId}/to/{claimingUser}")
    public List<DebtDto> retrieveDebtsTo(@PathVariable Long userId, @PathVariable Long claimingUser) {

        List<Debt> debts = debtService.getDebtsToClaimingUser(userId, claimingUser);
        return mapToDto(debts);
    }

    private List<DebtDto> mapToDto(List<Debt> debts) {

        JMapper<DebtDto, Debt> mapper = new JMapper<>(DebtDto.class, Debt.class);
        return debts.stream()
                .map(mapper::getDestination)
                .collect(Collectors.toList());
    }
}
