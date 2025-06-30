package br.edu.engsoft.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    @JsonbProperty("product_id")
    private Long productId;

    private Double price;
    private String currency;
    private Double cost;

    @JsonbProperty("direct_cost")
    private Double directCost;

    private String notes;
}