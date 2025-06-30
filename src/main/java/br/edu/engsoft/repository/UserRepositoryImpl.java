package br.edu.engsoft.repository;

import br.edu.engsoft.dto.UserDTO;
import br.edu.engsoft.model.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository, PanacheMongoRepository<User> {

    @Override
    public void save(UserDTO dto) {
        User user = dto.toEntity();
        Optional<User> userOpt = findById(user.getId());

        userOpt.ifPresentOrElse(existing -> {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setLang(user.getLang());
            existing.setLocale(user.getLocale());
            existing.setTimezoneName(user.getTimezoneName());
            existing.setTimezoneOffset(user.getTimezoneOffset());
            existing.setDefaultCurrency(user.getDefaultCurrency());
            existing.setIconUrl(user.getIconUrl());
            existing.setActiveFlag(user.getActiveFlag());
            existing.setIsDeleted(user.getIsDeleted());
            existing.setIsAdmin(user.getIsAdmin());
            existing.setRoleId(user.getRoleId());
            existing.setCreated(user.getCreated());
            existing.setHasCreatedCompany(user.getHasCreatedCompany());
            existing.setIsYou(user.getIsYou());
            existing.setPhone(user.getPhone());
            existing.setModified(user.getModified());
            existing.setLastLogin(user.getLastLogin());

            this.persistOrUpdate(existing);
        }, () -> this.persist(user));
    }

    @Override
    public void saveAll(List<UserDTO> users) {
        for (UserDTO dto : users) {
            save(dto);
        }
    }

    @Override
    public List<User> getAll() {
        return listAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return find("_id", id).firstResultOptional();
    }

    @Override
    public List<User> findByEmail(String email) {
        return find("email", email).list();
    }
}