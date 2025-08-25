package br.com.erudio.person_api.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.debug("This is a DEBUG log."); 
        logger.info("This is an INFO log.");
        logger.warn("This is an WARN log.");
        logger.error("This is and ERROR log.");
        return "Logs generated successfully.";
    }
}
