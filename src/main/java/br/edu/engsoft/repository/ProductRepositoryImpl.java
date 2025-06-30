package br.edu.engsoft.repository;

import br.edu.engsoft.dto.ProductDTO;
import br.edu.engsoft.model.Product;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository, PanacheMongoRepository<Product> {

    @Override
    public void save(ProductDTO dto) {
        Product product = dto.toEntity();
        Optional<Product> productOpt = findById(product.getId());

        productOpt.ifPresentOrElse(existing -> {
            existing.setName(product.getName());
            existing.setCode(product.getCode());
            existing.setDescription(product.getDescription());
            existing.setUnit(product.getUnit());
            existing.setTax(product.getTax());
            existing.setCategory(product.getCategory());
            existing.setOwnerId(product.getOwnerId());
            existing.setIsLinkable(product.getIsLinkable());
            existing.setIsDeleted(product.getIsDeleted());
            existing.setVisibleTo(product.getVisibleTo());
            existing.setAddTime(product.getAddTime());
            existing.setUpdateTime(product.getUpdateTime());
            existing.setPrices(product.getPrices());

            this.persistOrUpdate(existing);
        }, () -> this.persist(product));
    }

    @Override
    public void saveAll(List<ProductDTO> products) {
        for (ProductDTO p : products) {
            save(p);
        }
    }

    @Override
    public List<Product> getAll() {
        return this.listAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.find("_id", id).firstResultOptional();
    }

    @Override
    public List<Product> findByName(String name) {
        return find("name", name).list();
    }

    @Override
    public List<Product> listByOwnerId(Long id) {
        return find("ownerId", id).list();
    }
}