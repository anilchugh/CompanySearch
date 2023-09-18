package com.company.www.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty
    String locality;
    @JsonProperty("postal_code")
    String postalCode;
    @JsonProperty
    String premises;
    @JsonProperty("address_line_1")
    String addressLine1;
    @JsonProperty
    String country;
}
