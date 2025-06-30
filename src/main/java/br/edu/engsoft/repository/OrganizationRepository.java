package br.edu.engsoft.repository;

import java.util.List;
import java.util.Optional;

import br.edu.engsoft.dto.OrganizationDTO;
import br.edu.engsoft.model.Organization;

public interface OrganizationRepository {
    void save(OrganizationDTO organization);
    void saveAll(List<OrganizationDTO> organizations);
    List<Organization> getAll();
    Optional<Organization> findById(Long id);
    List<Organization> findByName(String name);
    List<Organization> listByOwnerId(Long id);
}
