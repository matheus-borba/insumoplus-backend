package br.edu.engsoft.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    @JsonbProperty("success")
    private Boolean success;

    @JsonbProperty("data")
    private List<ProductDTO> data;

}