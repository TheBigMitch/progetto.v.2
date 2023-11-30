package com.progettopsw.estore.Controllers;

import com.progettopsw.estore.Entities.Ordine;
import com.progettopsw.estore.Exceptions.QuantitaNonDisponibileException;
//import com.progettopsw.estore.Exceptions.UtenteNonTrovatoException;
import com.progettopsw.estore.Exceptions.VariazionePrezzoException;
import com.progettopsw.estore.Services.OrdineService;
//import com.progettopsw.estore.Utilities.JwtUtil;
//import com.progettopsw.estore.Utilities.MessaggioRisposta;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;

import com.progettopsw.estore.Entities.Utente;

import javax.validation.Valid;
//import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ordini")
public class OrdineController 
{
    @Autowired
    private OrdineService ordineService;

    @SuppressWarnings(value = { "unused" })
    @PostMapping("/creazione")
    //@PreAuthorize("hasAnyAuthority('customer')")
    public Boolean create(@RequestBody @Valid Ordine ordine)
    {
        try
        {
            Ordine nuovoOrdine=ordineService.aggiungiOrdine(ordine);
            return true;
        }
        catch(QuantitaNonDisponibileException e){ return false; }
        catch (VariazionePrezzoException e){ return false; }
    }
    
    @GetMapping("/effettuati")
    //@PreAuthorize("hasAnyAuthority('customer')")
    public List<Ordine> mostraOrdini()
    {
        Utente u = new Utente();
        List<Ordine> listaOrdini= ordineService.mostraOrdiniUtente(u);
        return listaOrdini;
    }
    /*
    @PostMapping ("/{utente}")
    @PreAuthorize("hasAnyAuthority('customer')")
    public ResponseEntity mostraOrdini(@Valid @PathVariable("utente") String utente){
        try{
            List<Ordine> listaOrdini= ordineService.mostraOrdiniUtente(utente);
            return new ResponseEntity<>(listaOrdini, HttpStatus.OK);
        }catch(UtenteNonTrovatoException e){
            return new ResponseEntity<>(new MessaggioRisposta("Utente Sconosciuto"), HttpStatus.BAD_REQUEST);
        }
    }
    */
}