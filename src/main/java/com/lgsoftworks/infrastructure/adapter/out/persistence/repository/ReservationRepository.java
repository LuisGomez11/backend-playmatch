package com.lgsoftworks.infrastructure.adapter.out.persistence.repository;

import com.lgsoftworks.domain.enums.StatusReservation;
import com.lgsoftworks.infrastructure.adapter.out.persistence.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByFieldId(Long fieldId);
    List<ReservationEntity> findByTeamId(Long teamId);
    List<ReservationEntity> findAllByStatus(StatusReservation status);
    Long countByStatusAndTeam_Id(StatusReservation status, Long teamId);
    Long countByStatusAndField_Id(StatusReservation status, Long fieldId);

    @Modifying
    @Transactional
    @Query("UPDATE ReservationEntity r SET r.status = :status WHERE r.id = :id")
    void updateStatusById(@Param("id") Long id, @Param("status") StatusReservation status);
}
