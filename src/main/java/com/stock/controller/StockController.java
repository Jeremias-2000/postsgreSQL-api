package com.stock.controller;

import com.stock.model.Stock;
import com.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController implements AbstractController{
    @Autowired
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public ResponseEntity<?> getAllStock() {
        return new ResponseEntity<>(stockService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getStockById(long id) {
        return new ResponseEntity<>(stockService.getById(id),HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> saveStock(Stock stock) {
        return new ResponseEntity<>(stockService.save(stock),HttpStatus.CREATED);
    }
}
