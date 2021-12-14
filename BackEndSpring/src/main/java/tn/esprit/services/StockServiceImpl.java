package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.StockRepository;

import tn.esprit.model.Stock;


import tn.esprit.model.Produit;
import tn.esprit.model.Stock;

import java.util.List;


@Service
public class StockServiceImpl implements stockService{
    @Autowired
    StockRepository stockRepository;

    @Override
    public void addStock(Stock stock) {
        if(!stockRepository.findById(stock.getIdStock()).isPresent()){
            stockRepository.save(stock);
        }
    }

    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id).get();
    }


    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public void deleteStockById(long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void deleteAllStocks() {
        stockRepository.deleteAll();
    }

    @Override
    public void updateStock(Stock stock, long id) {
        Stock st=stockRepository.findById(id).get();



        if(stock.getQte()!=0) st.setQte(stock.getQte());
        if(stock.getLibelle()!=null) st.setLibelle(stock.getLibelle());
        if(stock.getQtemin()!=0)st.setQtemin(stock.getQtemin());

        stockRepository.save(st);
    }

    @Override
    public Stock getStockByProduit(Produit produit) {
        return null;
    }

    @Override
    public void updateStockByProduit(Produit produit) {

    }

    @Override
    public String retrieveStatusStock() {
        return null;
    }

}
