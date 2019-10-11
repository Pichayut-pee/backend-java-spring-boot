package com.starter.project.payload;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogResponse {

    private Long catalogID;
    private String description;
}
