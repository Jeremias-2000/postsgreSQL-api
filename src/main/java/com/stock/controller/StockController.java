package com.stock.controller;

import com.stock.model.Stock;
import com.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<Stock> stocks = stockService.getAll();
        return ResponseEntity.ok(stocks);
    }

    @Override
    public ResponseEntity<?> getStockById(long id) {
        Stock search = stockService.getById(id);
        return ResponseEntity.ok(search);

    }

    @Override
    public ResponseEntity<?> saveStock(Stock stock) {
        Stock save = stockService.save(stock);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> updateStock(long id, Stock stock) {
        Stock search = stockService.update(id, stock);
        return ResponseEntity.ok(search);
    }

    @Override
    public ResponseEntity<Void> deleteStock(long id) {
        stockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
