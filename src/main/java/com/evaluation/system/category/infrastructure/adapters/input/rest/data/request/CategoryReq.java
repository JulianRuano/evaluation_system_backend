package com.evaluation.system.category.infrastructure.adapters.input.rest.data.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryReq {
    
    @JsonIgnore
    Long id;
    String name;
    String description;
}
