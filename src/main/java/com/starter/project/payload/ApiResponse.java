package com.starter.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Pichayut.pee on 19/08/17.
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;

}
