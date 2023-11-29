package br.com.fiap.service;

import br.com.fiap.entity.Beneficiario;
import br.com.fiap.repository.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario criarBeneficiario(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> procurarBeneficiario() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario buscarBeneficiarioID(Long id) {
        return beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiario não encontrado com o ID"));
    }
    @Transactional
    public Beneficiario atualizarBeneficiario(Long id, Beneficiario newBeneficiario) {
        Beneficiario existingBeneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiario não encontrado com o ID"));

        existingBeneficiario.setNome(newBeneficiario.getNome());
        existingBeneficiario.setBeneficiario(newBeneficiario.getBeneficiario());

        return existingBeneficiario;
    }

    public void deletarBeneficiario(Long id) {
        beneficiarioRepository.deleteById(id);
    }

    public Beneficiario encontrarBeneficiario(String nome) {
        return BeneficiarioRepository.encontrarBeneficiario(nome);
    }
}

