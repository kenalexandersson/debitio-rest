package org.kense.debitio.debitiorest.repository;

import org.kense.debitio.debitiorest.repository.entity.Happening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HappeningRepository extends JpaRepository<Happening, Long> {

    @Query("select h from Happening h where h.owner.id = :userId")
    List<Happening> getHappenings(@Param("userId") Long userId);

    @Query("select h from Happening h")
    List<Happening> getHappenings();
}
