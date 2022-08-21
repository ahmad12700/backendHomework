package com.ahmad.backendhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class OrgElementModel {
    @Nullable
    private Long id;
    @Nullable
    private Long parentId;
    @NotBlank(message = "Name is mandatory") @NotNull(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Type is mandatory") @NotNull(message = "Type is mandatory")
    private String type;

    public OrgElementModel(@JsonProperty("id")  Long id,
                           @JsonProperty("parent_id")  Long parentId,
                           @JsonProperty("name")  String name,
                           @JsonProperty("type")  String type) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
