package br.com.fiap.service.mapper;

import br.com.fiap.controller.dto.BeneficiarioDTO;
import br.com.fiap.entity.Beneficiario;

public class BeneficiarioMapper {


    public static Beneficiario toEntity (BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(beneficiarioDTO.getNome());
        beneficiario.setEmail(beneficiarioDTO.getEmail());
        beneficiario.setCpf(beneficiarioDTO.getCpf());
        beneficiario.setData(beneficiarioDTO.getData());
        beneficiario.setCep(beneficiarioDTO.getCep());
        beneficiario.setSenha(beneficiarioDTO.getSenha());
        return beneficiario;
    }
    public static BeneficiarioDTO toDTO (Beneficiario beneficiario) {
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setNome(beneficiario.getNome());
        beneficiarioDTO.setEmail(beneficiario.getEmail());
        beneficiarioDTO.setCpf(beneficiario.getCpf());
        beneficiarioDTO.setData(beneficiario.getData());
        beneficiarioDTO.setCep(beneficiario.getCep());
        beneficiarioDTO.setSenha(beneficiario.getSenha());
        return beneficiarioDTO;
    }
}
