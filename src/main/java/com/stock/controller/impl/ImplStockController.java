package com.stock.controller.impl;

import com.stock.model.Stock;
import com.stock.service.exceptionService.LotNotFoundException;
import com.stock.service.exceptionService.UniqueLotException;
import com.stock.service.impl.ImplStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/api/v1/stock")
public class ImplStockController implements com.stock.controller.StockController {
    @Autowired
    private ImplStockService implStockService;

    public ImplStockController(ImplStockService implStockService) {
        this.implStockService = implStockService;
    }

    @Override
    public ResponseEntity<?> getAllStock() {
        List<Stock> stocks = implStockService.getAll();
        return ResponseEntity.ok(stocks);
    }

    @Override
    public ResponseEntity<?> getStockById(long id) {
        Stock search = implStockService.getById(id);
        return ResponseEntity.ok(search);

    }

    @Override
    public ResponseEntity<?> getStockByLot(String lot) throws LotNotFoundException {
        return ResponseEntity.ok(implStockService.findStockByLot(lot));
    }

    @Override
    public ResponseEntity<?> saveStock(Stock stock) throws UniqueLotException {
        try {
            Stock save = implStockService.save(stock);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        }catch (MethodNotAllowed e){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @Override
    public ResponseEntity<?> updateStock(long id, Stock stock) {
        Stock search = implStockService.update(id, stock);
        return ResponseEntity.ok(search);
    }

    @Override
    public ResponseEntity<Void> deleteStock(long id) {
        implStockService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
