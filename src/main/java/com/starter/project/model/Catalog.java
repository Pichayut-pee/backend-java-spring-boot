package com.starter.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Catalog", indexes = {
  @Index(name = "idx_catalog_id", columnList = "CatalogID", unique = true)
})
public class Catalog {
    public Catalog() {
    }

    @Id
    @GenericGenerator(
      name = "catalog_generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @org.hibernate.annotations.Parameter(name = "sequence_name", value = "seq_approval"),
        @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
        @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
      }
    )

    @GeneratedValue(generator = "catalog_generator")
    @Column(name = "CatalogID", columnDefinition = "bigint", nullable = false)
    private Long catalogID;

    @Column(name = "Description", columnDefinition = "nvarchar(255)")
    private String description;

    @Column(name = "PlantID")
    private Long plantID;

}
