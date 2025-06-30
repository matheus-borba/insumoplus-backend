package br.edu.engsoft.dto;

import br.edu.engsoft.model.User;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Integer lang;
    private String locale;

    @JsonbProperty("timezone_name")
    private String timezoneName;

    @JsonbProperty("timezone_offset")
    private String timezoneOffset;

    @JsonbProperty("default_currency")
    private String defaultCurrency;

    @JsonbProperty("icon_url")
    private String iconUrl;

    @JsonbProperty("active_flag")
    private Boolean activeFlag;

    @JsonbProperty("is_deleted")
    private Boolean isDeleted;

    @JsonbProperty("is_admin")
    private Integer isAdmin;

    @JsonbProperty("role_id")
    private Integer roleId;

    private String created;

    @JsonbProperty("has_created_company")
    private Boolean hasCreatedCompany;

    @JsonbProperty("is_you")
    private Boolean isYou;

    private String phone;
    private String modified;

    @JsonbProperty("last_login")
    private String lastLogin;

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setLang(this.lang);
        user.setLocale(this.locale);
        user.setTimezoneName(this.timezoneName);
        user.setTimezoneOffset(this.timezoneOffset);
        user.setDefaultCurrency(this.defaultCurrency);
        user.setIconUrl(this.iconUrl);
        user.setActiveFlag(this.activeFlag);
        user.setIsDeleted(this.isDeleted);
        user.setIsAdmin(this.isAdmin);
        user.setRoleId(this.roleId);
        user.setCreated(this.created);
        user.setHasCreatedCompany(this.hasCreatedCompany);
        user.setIsYou(this.isYou);
        user.setPhone(this.phone);
        user.setModified(this.modified);
        user.setLastLogin(this.lastLogin);
        return user;
    }
}