package pl.edu.pwsztar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PizzaMenu {

    private static final Logger LOGGER = LoggerFactory.getLogger(PizzaMenu.class);

    @CrossOrigin
    @GetMapping(value = "/Test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getRuleActualValue() {

        return new ResponseEntity("TEST", HttpStatus.OK);
    }



}
