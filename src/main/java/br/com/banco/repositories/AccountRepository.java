package br.com.banco.repositories;

import br.com.banco.entities.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    Account findByIdConta(Integer accountId);

}
