package com.stock.service.impl;

import com.stock.model.Stock;
import com.stock.repository.StockRepository;
import com.stock.service.StockService;
import com.stock.service.exceptionService.LotNotFoundException;
import com.stock.service.exceptionService.UniqueLotException;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplStockService implements StockService<Stock> {
    @Autowired
    private StockRepository stockRepository;

    public ImplStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    @SneakyThrows
    public Stock getById(long id)  {
        return validStockById(id);
    }
    public Optional<Stock> findStockByLot(String lot) throws LotNotFoundException {
        Optional<Stock> search = stockRepository.findByLot(lot);
        if (search.isPresent()){
            return search;
        }
        else {
            throw new LotNotFoundException(search);
        }
    }

    public Stock save(Stock stock) throws UniqueLotException {
        Optional<Stock> search = stockRepository.findByLot(stock.getLot());
        if (search.isPresent()){
            throw new UniqueLotException("lot already registered: '" + stock.getLot() + "'");
        }
        return stockRepository.save(stock);
    }

    @SneakyThrows
    public Stock update(long id, Stock stock)  {
        Stock validStock = validStockById(id);
        validStock.setDescription(stock.getDescription());
        validStock.setPrice(stock.getPrice());
        validStock.setSale_price(stock.getSale_price());
        validStock.setPurcharse_date(stock.getPurcharse_date());
        validStock.setLot(stock.getLot());

        return validStock;
    }

    @SneakyThrows
    public void delete(long id){
       Stock validStock =  validStockById(id);
        stockRepository.delete(validStock);
    }

    protected Stock validStockById(long id) throws NotFoundException {
        return   stockRepository.findById(id).orElseThrow(()
                 -> new NotFoundException("Invalid id" + id));
    }
//    public boolean valisData(String data) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
//            sdf.setLenient(false);
//            sdf.parse(data);
//            return true;
//        } catch (ParseException ex) {
//            return false;
//        }
//    }
}
