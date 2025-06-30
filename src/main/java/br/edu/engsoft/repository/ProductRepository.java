package br.edu.engsoft.repository;

import br.edu.engsoft.dto.ProductDTO;
import br.edu.engsoft.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(ProductDTO dto);
    void saveAll(List<ProductDTO> products);
    List<Product> getAll();
    Optional<Product> findById(Long id);
    List<Product> findByName(String name);
    List<Product> listByOwnerId(Long id);
}