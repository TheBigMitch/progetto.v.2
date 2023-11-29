package com.progettopsw.estore.Services;

import com.progettopsw.estore.Entities.Utente;
import com.progettopsw.estore.Exceptions.MailAlreadyUsedException;
import com.progettopsw.estore.Repositories.UtenteRepository;
//import com.progettopsw.estore.Utilities.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Utente registerUser(Utente utente) throws MailAlreadyUsedException {
        if (utenteRepository.existsByUsername(/*JwtUtil.getEmail()*/ utente.getUsername()) ){
            throw new MailAlreadyUsedException();
        }
        utente.setUsername(utente.getUsername() /*JwtUtil.getEmail()*/ );
        return utenteRepository.save(utente);
    }
     

    @Transactional(readOnly = true)
    public List<Utente> getUtenti() {
        return utenteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Boolean getUtente(String username) {
        return utenteRepository.existsByUsername(username);
    }

}