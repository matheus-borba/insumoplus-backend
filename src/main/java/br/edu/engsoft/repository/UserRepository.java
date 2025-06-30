package br.edu.engsoft.repository;

import br.edu.engsoft.dto.UserDTO;
import br.edu.engsoft.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(UserDTO dto);
    void saveAll(List<UserDTO> users);
    List<User> getAll();
    Optional<User> findById(Long id);
    List<User> findByEmail(String email);
}