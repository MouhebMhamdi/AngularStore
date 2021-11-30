package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.Stock;
import tn.esprit.services.StockServiceImpl;

@SpringBootTest
public class StockTest {
    @Autowired
    StockServiceImpl stockServiceImpl;
    @Test
    public void Test(){
        Stock s=new Stock();
        s.setQtemin(50);
        s.setQtemin(250);
        s.setLibellStock("Vetement");
        stockServiceImpl.addStock(s);
    }
}
