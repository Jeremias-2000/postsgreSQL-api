package com.stock.controller;

import com.stock.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AbstractController {
    @GetMapping("/allStock")
    ResponseEntity<?> getAllStock();

    @GetMapping("/search/{id}")
    ResponseEntity<?> getStockById(@PathVariable("id") long id);

    @PostMapping("/saveStock")
    ResponseEntity<?> saveStock(@RequestBody Stock stock);
}
