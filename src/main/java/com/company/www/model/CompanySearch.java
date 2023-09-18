package com.company.www.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public class CompanySearch {
    @NotEmpty(message = "Company name is mandatory")
    @JsonProperty
    String companyName;
    @JsonProperty
    String companyNumber;

    public CompanySearch(String companyName, String companyNumber) {
        this.companyName = companyName;
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }
}
