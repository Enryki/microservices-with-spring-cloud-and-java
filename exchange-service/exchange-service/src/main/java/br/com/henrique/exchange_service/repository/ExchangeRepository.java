package br.com.henrique.exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.henrique.exchange_service.model.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, Long>{
    Exchange findByFromAndTo(String from, String to);
}
