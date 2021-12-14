package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Stock;
import tn.esprit.services.StockServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
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

  @GetMapping("/getStockById/{id}")
  public Stock getStockById(@PathVariable long id){
    return stockService.getStockById(id);
  }

  @PostMapping("/updatestock/{id}")
  public String UpdateStock(@RequestBody Stock stock ,@PathVariable long id){
    stockService.updateStock(stock,id);
    return "Stock updated";
  }
    @PostMapping("/addStock")
    public String addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
        return "Stock add !!";
    }
  @DeleteMapping("/delete/{id}")
  public String deleteStock(@PathVariable long id){
    stockService.deleteStockById(id);
    return "Stock deleted !!";
  }



}
