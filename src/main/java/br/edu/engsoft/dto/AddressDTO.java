package br.edu.engsoft.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String value;

    @JsonbProperty("street_number")
    private String streetNumber;

    private String route;

    private String sublocality;

    private String locality;

    @JsonbProperty("admin_area_level_1")
    private String adminAreaLevel1;

    @JsonbProperty("admin_area_level_2")
    private String adminAreaLevel2;

    private String country;

    @JsonbProperty("postal_code")
    private String postalCode;

    @JsonbProperty("formatted_address")
    private String formattedAddress;
}