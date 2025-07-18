package com.lgsoftworks.domain.port.out;

import com.lgsoftworks.domain.enums.StatusReservation;
import com.lgsoftworks.domain.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepositoryPort {
    List<Reservation> findAll();
    Page<Reservation> findByFilters(LocalDate date, StatusReservation status, Long teamId, Long fieldId, Pageable pageable);
    Optional<Reservation> findById(Long id);
    Reservation save(Reservation reservation);
    void deleteById(Long id);
    List<Reservation> findByFieldId(Long fieldId);
    List<Reservation> findByFieldIdAndStatus(Long fieldId, StatusReservation status);
    List<Reservation> findByTeamId(Long teamId);
    List<Reservation> findAllByStatus(StatusReservation status);
    void updateStatus(Long reservationId, StatusReservation status);
    Long countReservationsByTeamAndStatus(StatusReservation statusReservation, Long teamId);
    Long countReservationsByFieldAndStatus(StatusReservation statusReservation, Long fieldId);
}
