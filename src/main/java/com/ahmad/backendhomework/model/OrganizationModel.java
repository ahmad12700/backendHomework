package com.ahmad.backendhomework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;

@JsonComponent
public class OrganizationModel {
    private List<OrgElementModel> elements;

    public OrganizationModel(@JsonProperty("organization") List<OrgElementModel> elements) {
        this.elements = elements;
    }

    public List<OrgElementModel> getElements() {
        return elements;
    }

    public void setElements(List<OrgElementModel> elements) {
        this.elements = elements;
    }
}
