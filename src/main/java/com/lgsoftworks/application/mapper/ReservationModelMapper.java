package com.lgsoftworks.application.mapper;

import com.lgsoftworks.domain.enums.StatusReservation;
import com.lgsoftworks.application.dto.ReservationDTO;
import com.lgsoftworks.application.dto.request.ReservationRequest;
import com.lgsoftworks.application.dto.summary.ReservationAvailabilityDTO;
import com.lgsoftworks.application.dto.summary.ReservationFieldDTO;
import com.lgsoftworks.application.dto.summary.ReservationTeamDTO;
import com.lgsoftworks.domain.model.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationModelMapper {

    public static Reservation toModel(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setHours(reservationDTO.getHours());
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setTeam(TeamModelMapper.dtoSummaryToModel(reservationDTO.getTeam()));
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        reservation.setStatus(reservationDTO.getStatus());
        reservation.setField(FieldModelMapper.dtoSummaryToField(reservationDTO.getField()));
        return reservation;
    }

    public static Reservation toModelOfAvailability(ReservationAvailabilityDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setHours(reservationDTO.getHours());
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setTeam(TeamModelMapper.dtoSummaryToModel(reservationDTO.getTeam()));
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        reservation.setStatus(StatusReservation.ACTIVE);
        reservation.setField(FieldModelMapper.dtoSummaryToField(reservationDTO.getField()));
        return reservation;
    }

    public static Reservation toModelRequest(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationRequest.getId());
        reservation.setHours(reservationRequest.getHours());
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setStartTime(reservationRequest.getStartTime());
        reservation.setStatus(reservationRequest.getStatus());
        return reservation;
    }

    public static ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setHours(reservation.getHours());
        reservationDTO.setField(FieldModelMapper.toFieldSummaryDTO(reservation.getField()));
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setStatus(reservation.getStatus());
        reservationDTO.setTeam(TeamModelMapper.toTeamSummary(reservation.getTeam()));
        return reservationDTO;
    }

    public static ReservationAvailabilityDTO toAvailabilityDTO(Reservation reservation) {
        ReservationAvailabilityDTO reservationDTO = new ReservationAvailabilityDTO();
        reservationDTO.setHours(reservation.getHours());
        reservationDTO.setField(FieldModelMapper.toFieldSummaryDTO(reservation.getField()));
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setTeam(TeamModelMapper.toTeamSummary(reservation.getTeam()));
        return reservationDTO;
    }

    public static ReservationTeamDTO toReservationTeamDTO(Reservation reservation) {
        if (reservation == null) return null;
        ReservationTeamDTO reservationDTO = new ReservationTeamDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setHours(reservation.getHours());
        reservationDTO.setField(FieldModelMapper.toFieldSummaryDTO(reservation.getField()));
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setStatus(reservation.getStatus());
        return reservationDTO;
    }

    public static ReservationFieldDTO toReservationFieldDTO(Reservation reservation) {
        if (reservation == null) return null;
        ReservationFieldDTO reservationDTO = new ReservationFieldDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setHours(reservation.getHours());
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setTeam(TeamModelMapper.toTeamSummary(reservation.getTeam()));
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        reservationDTO.setStatus(reservation.getStatus());
        return reservationDTO;
    }

    public static Reservation toReservationField(ReservationFieldDTO reservationFieldDTO) {
        if (reservationFieldDTO == null) return null;
        Reservation reservation = new Reservation();
        reservation.setId(reservationFieldDTO.getId());
        reservation.setHours(reservationFieldDTO.getHours());
        reservation.setReservationDate(reservationFieldDTO.getReservationDate());
        reservation.setTeam(TeamModelMapper.dtoSummaryToModel(reservationFieldDTO.getTeam()));
        reservation.setStartTime(reservationFieldDTO.getStartTime());
        reservation.setEndTime(reservationFieldDTO.getEndTime());
        reservation.setStatus(reservationFieldDTO.getStatus());
        return reservation;
    }

    public static Reservation toReservationTeam(ReservationTeamDTO reservationTeamDTO) {
        if (reservationTeamDTO == null) return null;
        Reservation reservation = new Reservation();
        reservation.setId(reservationTeamDTO.getId());
        reservation.setHours(reservationTeamDTO.getHours());
        reservation.setReservationDate(reservationTeamDTO.getReservationDate());
        reservation.setField(FieldModelMapper.dtoSummaryToField(reservationTeamDTO.getField()));
        reservation.setStartTime(reservationTeamDTO.getStartTime());
        reservation.setEndTime(reservationTeamDTO.getEndTime());
        reservation.setStatus(reservationTeamDTO.getStatus());
        return reservation;
    }

    public static List<ReservationFieldDTO> toReservationFieldDTOList(List<Reservation> reservations) {
        if (reservations == null) return null;
        return reservations.stream()
                .map(ReservationModelMapper::toReservationFieldDTO)
                .collect(Collectors.toList());
    }

    public static List<ReservationTeamDTO> toReservationTeamDTOList(List<Reservation> reservations) {
        if (reservations == null) return null;
        return reservations.stream()
                .map(ReservationModelMapper::toReservationTeamDTO)
                .collect(Collectors.toList());
    }

    public static List<Reservation> toReservationTeamList(List<ReservationTeamDTO> reservations) {
        if (reservations == null) return null;
        return reservations.stream()
                .map(ReservationModelMapper::toReservationTeam)
                .collect(Collectors.toList());
    }

    public static List<Reservation> toReservationFieldList(List<ReservationFieldDTO> reservations) {
        if (reservations == null) return null;
        return reservations.stream()
                .map(ReservationModelMapper::toReservationField)
                .collect(Collectors.toList());
    }

}
