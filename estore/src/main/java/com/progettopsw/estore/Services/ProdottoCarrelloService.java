package com.progettopsw.estore.Services;

import com.progettopsw.estore.Entities.Prodotto;
import com.progettopsw.estore.Entities.ProdottoCarrello;
import com.progettopsw.estore.Entities.Utente;
import com.progettopsw.estore.Repositories.ProdottoCarrelloRepository;
import com.progettopsw.estore.Repositories.ProdottoRepository;
import com.progettopsw.estore.Repositories.UtenteRepository;
//import com.progettopsw.estore.Utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class ProdottoCarrelloService {
    @Autowired
    private ProdottoRepository prodottoRepository;
    @Autowired
    private ProdottoCarrelloRepository carrelloRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    /*
    @Transactional(readOnly = false)
    public ProdottoCarrello aggiungiAlCarrello(Prodotto prodotto) throws  Exception{
        ProdottoCarrello carrello = new ProdottoCarrello();
        try{
            String username = JwtUtil.getEmail();
            Utente utente= utenteRepository.findByUsername(username);
            Prodotto p = prodottoRepository.findById(prodotto.getId()).get();
            carrello.setUtente(utente);
            carrello.setQuantita(1);
            carrello.setPrezzo(p.getPrezzo());
            carrello.setProdottoId(p);
            carrello.setNomeProdotto(p.getNome());
            Date date = new Date();
            carrello.setData(date);
            carrelloRepository.save(carrello);
        }catch(Exception e){
            throw new Exception();
        }
        return carrello;
    }
     */


    @Transactional(readOnly = true)
    public List<ProdottoCarrello> prodottiCarrello(String username){
        return carrelloRepository.findAllByUtente_Username(username);
    }

    /*
    @Transactional(readOnly = false)
    public void rimuoviCarrello(){
        String username= JwtUtil.getEmail();
        Utente utente = utenteRepository.findByUsername(username);
        System.out.println(utente);
        carrelloRepository.deleteAllByUtente(utente);
    } */
    
    @Transactional(readOnly = false)
    public void rimuoviCarrello(long id){
        carrelloRepository.deleteCarrellosById(id);
    }

}