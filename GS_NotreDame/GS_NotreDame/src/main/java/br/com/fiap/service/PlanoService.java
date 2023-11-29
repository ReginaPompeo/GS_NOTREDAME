package br.com.fiap.service;

import br.com.fiap.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {
    @Autowired
    private PlanoRepository planoRepository;
}
