package br.edu.engsoft.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)@MongoEntity(collection = "users")
public class User extends PanacheMongoEntity {

    private Long id;
    private String name;
    private String email;
    private Integer lang;
    private String locale;
    private String timezoneName;
    private String timezoneOffset;
    private String defaultCurrency;
    private String iconUrl;
    private Boolean activeFlag;
    private Boolean isDeleted;
    private Integer isAdmin;
    private Integer roleId;
    private String created;
    private Boolean hasCreatedCompany;
    private Boolean isYou;
    private String phone;
    private String modified;
    private String lastLogin;
}