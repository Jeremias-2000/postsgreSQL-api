package com.stock.controller;

import com.stock.model.Stock;
import com.stock.service.exception.LotNotFoundException;
import com.stock.service.exception.UniqueLotException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface StockController {
    @GetMapping("/all")
    ResponseEntity<?> getAllStock();

    @GetMapping("/search/id/{id}")
    ResponseEntity<?> getStockById(@PathVariable("id") long id);

    @GetMapping("/search/lot/{lot}")
    ResponseEntity<?> getStockByLot(@PathVariable("lot") String lot) throws LotNotFoundException;

    @PostMapping("/save")
    ResponseEntity<?> saveStock(@RequestBody Stock stock) throws UniqueLotException;



    @PutMapping("/update/{id}")
    ResponseEntity<?> updateStock(@PathVariable("id") long id, @Validated @RequestBody Stock stock);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteStock(@PathVariable("id") long id);
}
