package br.com.henrique.exchange_service.controller;

import java.math.BigDecimal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henrique.exchange_service.environment.InstanceInformationService;
import br.com.henrique.exchange_service.model.Exchange;
import br.com.henrique.exchange_service.repository.ExchangeRepository;

@RestController
@RequestMapping(path="exchange-service")
public class ExchangeController {
    
    @Autowired
    InstanceInformationService informationService;
    @Autowired
    ExchangeRepository exchangeRepository;

    @GetMapping(value = "{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)     
    public Exchange getExchange(
        @PathVariable("amount") BigDecimal amount, 
         @PathVariable("from") String from, 
        @PathVariable("to") String to){
            Exchange exchange = exchangeRepository.findByFromAndTo(from, to);
            if(exchange == null){
                throw new RuntimeException("Currency Unsupported!");
            }
            BigDecimal conversionFactor = exchange.getConversionFactor();
            BigDecimal convertedValue = conversionFactor.multiply(amount);
            exchange.setConvertedValue(convertedValue);
            exchange.setEnvironment("PORT:" + informationService.retrieveServerPort());
            return exchange;
    }

    // @GetMapping(value = "{amount}/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)     
    // public Exchange getExchange(
    //     @PathVariable("amount") BigDecimal amount, 
    //      @PathVariable("from") String from, 
    //     @PathVariable("to") String to){
    //     return new Exchange(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT:" + informaaInformationService.retrieveServerPort());
    // }
}
