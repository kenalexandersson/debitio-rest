package org.kense.debitio.debitiorest.repository;

import org.kense.debitio.debitiorest.repository.entity.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long> {

    @Query("select d from Debt d where lower(d.fromUser) = lower(:userId) or lower(d.toUser) = lower(:userId)")
    List<Debt> getDebts(@Param("userId") Long userId);

    @Query("select d from Debt d where d.happening.id = :happeningId and (lower(d.fromUser) = lower(:userId) or lower(d.toUser) = lower(:userId))")
    List<Debt> getDebts(@Param("userId") Long userId, @Param("happeningId") Long happeningId);
}
