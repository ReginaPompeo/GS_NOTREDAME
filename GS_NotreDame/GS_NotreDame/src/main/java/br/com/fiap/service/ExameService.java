package br.com.fiap.service;

import br.com.fiap.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameService {
    @Autowired
    private ExameRepository exameRepository;
}
