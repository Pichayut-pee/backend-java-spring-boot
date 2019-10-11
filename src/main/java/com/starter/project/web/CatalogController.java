package com.starter.project.web;


import com.starter.project.payload.ApiResponse;
import com.starter.project.payload.CatalogResponse;
import com.starter.project.service.CatalogService.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/detail")
    public ResponseEntity<?> getCatalogDetail(@RequestParam(value = "catalogID") Long catalogID) {
        try {
            //To be implements logic
            CatalogResponse ret = null;
            return  ResponseEntity.ok(ret);
        } catch(Exception ex) {
            return new ResponseEntity <>(new ApiResponse(false, ex.getMessage()),
              HttpStatus.OK);
        }


    }
}
