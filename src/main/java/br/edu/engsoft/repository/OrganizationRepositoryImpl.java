package br.edu.engsoft.repository;

import java.util.List;
import java.util.Optional;

import br.edu.engsoft.dto.OrganizationDTO;
import br.edu.engsoft.model.Organization;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrganizationRepositoryImpl implements OrganizationRepository, PanacheMongoRepository<Organization> {

    @Override
    public void save(OrganizationDTO dto) {
        Organization organization = dto.toEntity();
        Optional<Organization> organizationOpt = findById(organization.getId());
        organizationOpt.ifPresentOrElse(existing -> {
            existing.setName(organization.getName());
            existing.setAddTime(organization.getAddTime());
            existing.setUpdateTime(organization.getUpdateTime());
            existing.setVisibleTo(organization.getVisibleTo());
            existing.setOwnerId(organization.getOwnerId());
            existing.setLabelIds(organization.getLabelIds());
            existing.setWebsite(organization.getWebsite());
            existing.setLinkedin(organization.getLinkedin());
            existing.setIndustry(organization.getIndustry());
            existing.setAnnualRevenue(organization.getAnnualRevenue());
            existing.setEmployeeCount(organization.getEmployeeCount());
            existing.setIsDeleted(organization.getIsDeleted());
            existing.setAddress(organization.getAddress());

            this.persistOrUpdate(existing);
        }, () ->  this.persist(organization));
    }

    @Override
    public void saveAll(List<OrganizationDTO> organizations) {
        for (OrganizationDTO o : organizations) {
            save(o);
        }
    }

    @Override
    public List<Organization> getAll() {
        return this.listAll();
    }

    @Override
    public Optional<Organization> findById(Long id) {
        return this.find("_id", id).firstResultOptional();
    }

    @Override
    public List<Organization> findByName(String name) {
        return find("name", name).list();
    }

    @Override
    public List<Organization> listByOwnerId(Long id) {
        return find("ownerId", id).list();
    }
}