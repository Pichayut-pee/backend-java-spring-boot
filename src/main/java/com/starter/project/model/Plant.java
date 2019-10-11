package com.starter.project.model;

import javax.persistence.*;

public class Plant {

    @Id
    @Column(name = "PlantID", columnDefinition = "bigint", nullable = false)
    private Long plantID;

    @Column(name = "plantName", columnDefinition = "nvarchar(255)", nullable = false)
    private String plantName;

}
