package br.com.henrique.book_service.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.henrique.book_service.dto.Exchange;
import br.com.henrique.book_service.environment.InstanceInformationService;
import br.com.henrique.book_service.model.Book;
import br.com.henrique.book_service.proxy.ExchangeProxy;
import br.com.henrique.book_service.repository.BookRepository;

@RestController
@RequestMapping(path = "book-service")
public class BookController {
    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ExchangeProxy exchangeProxy;

    @GetMapping(value = "/{id}/{currency}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency){
        var book = bookRepository.findById(id).orElseThrow();

  
        Exchange exchange = exchangeProxy.getExchange(
            book.getPrice(), 
            "USD", 
            currency);
        
        
        book.setEnvironment(informationService.retrieveServerPort() + " feign");
        book.setPrice(exchange.getConvertedValue());
        book.setCurrency(currency);
        return book;
    }

    /* 
    @GetMapping(value = "/{id}/{currency}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency){
        var book = bookRepository.findById(id).orElseThrow();

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate()
                            .getForEntity("http://localhost:8000/exchange-service/" + "{amount}/{from}/{to}",
                             Exchange.class, params);
        
        Exchange exchange = response.getBody();
        
        
        book.setEnvironment(informationService.retrieveServerPort());
        book.setPrice(exchange.getConvertedValue());
        book.setCurrency(currency);
        return book;
    }
*/
    //     @GetMapping(value = "/{id}/{currency}",
    //             produces = MediaType.APPLICATION_JSON_VALUE)
    // public Book findBook(@PathVariable("id") Long id,
    //                      @PathVariable("currency") String currency){
    //     var book = bookRepository.findById(id).orElseThrow();
    //     book.setEnvironment(informationService.retrieveServerPort());
    //     book.setCurrency(currency);
    //     return book;
    // }

    //     @GetMapping(value = "/{id}/{currency}",
    //             produces = MediaType.APPLICATION_JSON_VALUE)
    // public Book findBook(@PathVariable("id") Long id,
    //                      @PathVariable("currency") String currency){
    //     return new Book(
    //         1L,
    //         "Henrique Watanabe",
    //         "Computer Science",
    //         new Date(),
    //         15.8,
    //         "BRL",
    //         informationService.retrieveServerPort()
    //     );
    // }
}
