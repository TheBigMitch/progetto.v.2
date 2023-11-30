package com.progettopsw.estore.Repositories;

import com.progettopsw.estore.Entities.ProdottoCarrello;
import com.progettopsw.estore.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import java.util.List;

public interface ProdottoCarrelloRepository extends JpaRepository<ProdottoCarrello, Long> 
{
    void deleteCarrellosById(long carrelloId);
    List<ProdottoCarrello> findAllByUtente_Username(String username);
    void deleteAllByUtente(Utente utente);
}