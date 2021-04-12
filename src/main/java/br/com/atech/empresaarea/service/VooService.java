package br.com.atech.empresaarea.service;

import br.com.atech.empresaarea.dao.TransferDto;
import br.com.atech.empresaarea.dto.PainelVooDto;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface VooService {

    String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);


    TransferDto<PainelVooDto> recuperarVoo(Long numero);

    TransferDto<List<PainelVooDto>> recuperarVoos();

}
