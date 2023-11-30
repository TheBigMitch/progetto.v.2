package com.progettopsw.estore.Repositories;

import com.progettopsw.estore.Entities.Ordine;
//import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> { List<Ordine> findAllByUtente(String utente); }