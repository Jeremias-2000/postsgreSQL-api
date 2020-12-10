package com.stock.controller;

import com.stock.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface AbstractController {
    @GetMapping("/all")
    ResponseEntity<?> getAllStock();

    @GetMapping("/search/{id}")
    ResponseEntity<?> getStockById(@PathVariable("id") long id);

    @PostMapping("/save")
    ResponseEntity<?> saveStock(@RequestBody Stock stock);

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateStock(@PathVariable("id") long id, @Validated @RequestBody Stock stock);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteStock(@PathVariable("id") long id);
}
