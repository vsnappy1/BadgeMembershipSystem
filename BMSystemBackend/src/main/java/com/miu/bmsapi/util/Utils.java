package com.miu.bmsapi.util;

import jakarta.transaction.Status;
import org.springframework.http.ResponseEntity;

public class Utils {
    public static final ResponseEntity<?> getNotFoundResponse(){
        return ResponseEntity.notFound().build();
    }
}
