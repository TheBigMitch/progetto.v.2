package com.progettopsw.estore.Repositories;

import com.progettopsw.estore.Entities.ProdottoCarrello;
import com.progettopsw.estore.Entities.ProdottoOrdinato;
import com.progettopsw.estore.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoOrdinatoRepository extends JpaRepository<ProdottoOrdinato, Long> {

}
