package br.com.erudio.controllers;

import br.com.erudio.models.Exchange;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange-service")
public class ExchangeController {


    @GetMapping(value = "{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchenge(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
        return new Exchange(
                1L,
                from,
                to,
                BigDecimal.ONE,
                BigDecimal.TWO,
                "8000"
        );
    }
}
