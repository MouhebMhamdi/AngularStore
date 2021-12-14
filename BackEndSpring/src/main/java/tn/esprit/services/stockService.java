package tn.esprit.services;

import tn.esprit.model.Produit;
import tn.esprit.model.Stock;
import tn.esprit.model.Stock;

import java.util.List;

public interface stockService {

     void addStock(Stock stock);
     Stock getStockById(long id);
     List<Stock> getAllStocks();
     void deleteStockById(long id);
     void deleteAllStocks();
     void updateStock(Stock stock,long id);
     Stock getStockByProduit(Produit produit);
     void updateStockByProduit(Produit produit);

     String retrieveStatusStock();
}
