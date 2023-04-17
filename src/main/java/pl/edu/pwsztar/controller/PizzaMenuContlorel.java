package pl.edu.pwsztar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.model.BillDto;
import pl.edu.pwsztar.domain.model.Product;
import pl.edu.pwsztar.service.serviceImpl.PizzaMenuImp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class PizzaMenuContlorel {
  private final PizzaMenuImp pizzaMenuImp;
  @Autowired
    public  PizzaMenuContlorel(PizzaMenuImp pizzaMenuImp){
    this.pizzaMenuImp = pizzaMenuImp;
  }


    private static final Logger LOGGER = LoggerFactory.getLogger(PizzaMenuContlorel.class);

  /*  @CrossOrigin
    @GetMapping(value = "/Test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getRuleActualValue() {

        return new ResponseEntity("TEST", HttpStatus.OK);
    }
*/
    @CrossOrigin
    @GetMapping(value = "/getMenu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity(pizzaMenuImp.getMenu(),HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/getBill", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BillDto> getBillFromIndexList(@RequestBody List<Long> indexList) {
        return new ResponseEntity(pizzaMenuImp.getBillFronIndexList(indexList,1), HttpStatus.OK);
    }
  @CrossOrigin
  @PostMapping(value = "/Bill", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<BillDto> getBill() {
    return new ResponseEntity(pizzaMenuImp.getBillFronIndexList(Arrays.asList(1L, 2L, 3L),1), HttpStatus.OK);
  }

    @CrossOrigin
    @PostMapping(value ="/addProduct",produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addNewProduckt(@RequestBody Product product){
      pizzaMenuImp.addProduck(product);
    }
  }










