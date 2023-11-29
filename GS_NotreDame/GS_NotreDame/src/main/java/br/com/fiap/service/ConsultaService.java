package br.com.fiap.service;

import br.com.fiap.entity.Beneficiario;
import br.com.fiap.entity.Consulta;
import br.com.fiap.repository.BeneficiarioRepository;
import br.com.fiap.repository.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> procurarConsulta() {
        return consultaRepository.findAll();
    }

    public Consulta buscarConsultaID(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com o ID"));
    }
    @Transactional
    public Consulta atualizarConsulta(Long id, Consulta newConsulta) {
        Consulta existingConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com o ID"));

        existingConsulta.setId(newConsulta.getId());
        existingConsulta.setConsulta(newConsulta.getConsulta());

        return existingConsulta;
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta encontrarConsulta(String Especialidade) {
        return ConsultaRepository.encontrarConsulta(especialidade);
    }
}
