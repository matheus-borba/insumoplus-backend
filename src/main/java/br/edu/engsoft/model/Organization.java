package br.edu.engsoft.model;

import java.util.List;

import br.edu.engsoft.dto.AddressDTO;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "organizations")
public class Organization extends PanacheMongoEntity {
    private Long id;
    private String name;
    private String addTime;
    private String updateTime;
    private Integer visibleTo;
    private Long ownerId;
    private List<Integer> labelIds;
    private String website;
    private String linkedin;
    private String industry;
    private Double annualRevenue;
    private Integer employeeCount;
    private Boolean isDeleted;
    private AddressDTO address;
}
