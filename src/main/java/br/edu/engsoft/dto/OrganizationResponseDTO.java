package br.edu.engsoft.dto;

import java.util.List;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponseDTO {

    @JsonbProperty("success")
    private Boolean success;

    @JsonbProperty("data")
    private List<OrganizationDTO> data;
}
