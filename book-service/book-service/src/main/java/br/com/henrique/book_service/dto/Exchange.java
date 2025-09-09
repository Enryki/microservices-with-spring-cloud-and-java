package br.com.henrique.book_service.dto;

import java.io.Serializable;


public class Exchange implements Serializable {
    private static final long seriaVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue; 
    private String environment;

    

    public Exchange() {
    }

    public Exchange(Long id, String from, String to, Double conversionFactor, Double convertedValue,
            String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }
    public static long getSeriaversionuid() {
        return seriaVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public Double getConversionFactor() {
        return conversionFactor;
    }
    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public Double getConvertedValue() {
        return convertedValue;
    }
    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
