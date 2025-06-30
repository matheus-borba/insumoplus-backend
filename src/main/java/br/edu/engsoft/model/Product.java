package br.edu.engsoft.model;

import br.edu.engsoft.dto.PriceDTO;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "products")
public class Product extends PanacheMongoEntity {

    private Long id;
    private String name;
    private String code;
    private String description;
    private String unit;
    private Double tax;
    private Integer category;
    private Long ownerId;
    private Boolean isLinkable;
    private Boolean isDeleted;
    private Integer visibleTo;
    private String addTime;
    private String updateTime;
    private List<PriceDTO> prices;
}