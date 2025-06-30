package br.edu.engsoft.dto;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import br.edu.engsoft.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double tax;

    @JsonbProperty("add_time")
    private String addTime;

    @JsonbProperty("update_time")
    private String updateTime;

    private String description;
    private String code;
    private String unit;

    @JsonbProperty("owner_id")
    private Long ownerId;

    private Integer category;

    @JsonbProperty("is_deleted")
    private Boolean isDeleted;

    @JsonbProperty("is_linkable")
    private Boolean isLinkable;

    private List<PriceDTO> prices;

    @JsonbProperty("visible_to")
    private Integer visibleTo;

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setCode(this.code);
        product.setDescription(this.description);
        product.setUnit(this.unit);
        product.setTax(this.tax);
        product.setCategory(this.category);
        product.setOwnerId(this.ownerId);
        product.setIsLinkable(this.isLinkable);
        product.setIsDeleted(this.isDeleted);
        product.setVisibleTo(this.visibleTo);
        product.setAddTime(this.addTime);
        product.setUpdateTime(this.updateTime);
        product.setPrices(this.prices);

        return product;
    }

}
