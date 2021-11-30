package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Stock;
import tn.esprit.services.StockServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockServiceImpl stockService;

    public StockController( StockServiceImpl stockService){
        this.stockService=stockService;
    }

    @GetMapping("/getAllStocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }


    @PostMapping("/addStock")
    public String addStock(@RequestBody Stock stock){

        stockService.addStock(stock);
        return "Stock add !!";
    }




}
