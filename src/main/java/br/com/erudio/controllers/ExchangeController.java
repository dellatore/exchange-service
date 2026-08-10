package br.com.erudio.controllers;

import br.com.erudio.environment.InstanceInformationService;
import br.com.erudio.models.Exchange;
import br.com.erudio.repositories.ExchangeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Tag(name = "Exchange Microservice API", description = "API to convert currencies")
@RestController
@RequestMapping("/exchange-service")
public class ExchangeController {

    private final InstanceInformationService instanceInformationService;
    private final ExchangeRepository repository;

    public ExchangeController(InstanceInformationService instanceInformationService, ExchangeRepository repository) {
        this.instanceInformationService = instanceInformationService;
        this.repository = repository;
    }

    @Operation(summary = "Get exchange rate")
    @GetMapping(value = "{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Exchange getExchange(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {
        Exchange exchange = repository.findByFromAndTo(from, to).orElseThrow(() -> new RuntimeException("Currency Unsupported"));

        BigDecimal conversionFactor = exchange.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        exchange.setConvertedValue(convertedValue);
        exchange.setEnvironment(instanceInformationService.retrievePort());

        return exchange;

    }
}
