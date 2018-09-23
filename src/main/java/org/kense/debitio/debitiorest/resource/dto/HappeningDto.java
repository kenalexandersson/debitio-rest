package org.kense.debitio.debitiorest.resource.dto;

import org.kense.debitio.debitiorest.repository.entity.Happening;

import java.time.LocalDateTime;
import java.util.Set;

public class HappeningDto {

    private String name;

    private String comment;

    private LocalDateTime officialDateTime;

    private Set<DebtDto> debts;

    public HappeningDto(Happening happening, Set<DebtDto> debts) {
        this.name = happening.getHappening();
        this.setComment(happening.getComment());
        this.setOfficialDateTime(happening.getOfficialDate());
        this.debts = debts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getOfficialDateTime() {
        return officialDateTime;
    }

    public void setOfficialDateTime(LocalDateTime officialDateTime) {
        this.officialDateTime = officialDateTime;
    }

    public Set<DebtDto> getDebts() {
        return debts;
    }

    public void setDebts(Set<DebtDto> debts) {
        this.debts = debts;
    }
}
