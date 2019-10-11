package com.starter.project.repository;

import com.starter.project.model.Catalog;
import com.starter.project.payload.CatalogResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

        @Query("SELECT  new com.starter.project.payload.CatalogResponse(" +
          "             c.catalogID" +
          "           , c.description)" +
          "        FROM Catalog c "
          + "     WHERE c.catalogID = ?1 "
        )
        List<CatalogResponse> findByCatalogID(Long CatalogID);


}
