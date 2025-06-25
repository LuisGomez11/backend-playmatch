package com.lgsoftworks.domain.port.in;

import com.lgsoftworks.application.dto.AdminDTO;
import com.lgsoftworks.application.dto.request.AdminRequest;
import com.lgsoftworks.application.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AdminUseCase {
    List<AdminDTO> findAll();
    Optional<AdminDTO> findById(Long id);
    UserDTO save(AdminRequest adminRequest);
    UserDTO update(AdminRequest adminRequest);
    boolean deleteById(Long id);
    Optional<AdminDTO> findByDocumentNumber(String documentNumber);
    Optional<AdminDTO> findByEmail(String email);
}
