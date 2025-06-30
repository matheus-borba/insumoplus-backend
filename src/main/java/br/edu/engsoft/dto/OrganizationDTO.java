package br.edu.engsoft.dto;

import java.util.List;

import br.edu.engsoft.model.Organization;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    private Long id;

    private String name;

    @JsonbProperty("add_time")
    private String addTime;

    @JsonbProperty("update_time")
    private String updateTime;

    @JsonbProperty("visible_to")
    private Integer visibleTo;

    @JsonbProperty("owner_id")
    private Long ownerId;

    @JsonbProperty("label_ids")
    private List<Integer> labelIds;

    private String website;

    private String linkedin;

    private String industry;

    @JsonbProperty("annual_revenue")
    private Double annualRevenue;

    @JsonbProperty("employee_count")
    private Integer employeeCount;

    @JsonbProperty("is_deleted")
    private Boolean isDeleted;

    private AddressDTO address;

    public Organization toEntity() {
        Organization entity = new Organization();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setAddTime(this.addTime);
        entity.setUpdateTime(this.updateTime);
        entity.setVisibleTo(this.visibleTo);
        entity.setOwnerId(this.ownerId);
        entity.setLabelIds(this.labelIds);
        entity.setWebsite(this.website);
        entity.setLinkedin(this.linkedin);
        entity.setIndustry(this.industry);
        entity.setAnnualRevenue(this.annualRevenue);
        entity.setEmployeeCount(this.employeeCount);
        entity.setIsDeleted(this.isDeleted);
        entity.setAddress(this.address);

        return entity;
    }
}
