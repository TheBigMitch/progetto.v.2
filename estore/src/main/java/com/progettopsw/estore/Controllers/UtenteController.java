package com.progettopsw.estore.Controllers;

//import com.progettopsw.estore.Utilities.JwtUtil;
import com.progettopsw.estore.Entities.Utente;
import com.progettopsw.estore.Exceptions.MailAlreadyUsedException;
import com.progettopsw.estore.Services.UtenteService;
import com.progettopsw.estore.Utilities.MessaggioRisposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController 
{
    @Autowired
    private UtenteService utenteService;

    @SuppressWarnings(value = { "all" })
    @PostMapping("/registrazione")
    //@PreAuthorize("hasAnyAuthority('customer')")
    public ResponseEntity create(@RequestBody @Valid Utente utente) 
    {
        try 
        {
            Utente added = utenteService.registerUser(utente);
            return new ResponseEntity(added, HttpStatus.OK);
        }
        catch (MailAlreadyUsedException e) { return new ResponseEntity<>(new MessaggioRisposta("ERROR_MAIL_USER_ALREADY_EXISTS"), HttpStatus.BAD_REQUEST); }
    }

    @GetMapping("/getAll")
    public List<Utente> getAll() { return utenteService.getUtenti(); }

    @GetMapping("/getUtente")
    //@PreAuthorize("hasAnyAuthority('customer')")
    public Boolean getUtente(){ return utenteService.getUtente(/*JwtUtil.getEmail()*/ "a" ); } 
}