package br.com.atech.empresaarea.service;

import br.com.atech.empresaarea.dao.TransferDto;
import br.com.atech.empresaarea.dao.VooDao;
import br.com.atech.empresaarea.dao.domain.Voo;
import br.com.atech.empresaarea.dto.PainelVooDto;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VooServiceImpl implements VooService{


    @Autowired
    private VooDao vooDao;

    @Override
    public TransferDto<PainelVooDto> recuperarVoo(Long numero) {
        Optional<Voo> optVoo = vooDao.getOne(numero);

        if(!optVoo.isPresent())
            return new TransferDto<PainelVooDto>(HttpStatus.OK, new PainelVooDto());

        return new TransferDto<PainelVooDto>(HttpStatus.OK,
                                                PainelVooDto.builder()
                                                .cidadeDestino(optVoo.get().getCidadeDestino().getNome())
                                                .cidadeOrigem(optVoo.get().getCidadeOrigem().getNome())
                                                .dataChegada(new DateTime(optVoo.get().getHoraSaida()).toString(DATE_TIME_FORMAT))
                                                .dataPartida(new DateTime(optVoo.get().getHoraChegada()).toString(DATE_TIME_FORMAT))
                                                .descricaoAviao(optVoo.get().getAviao().getDescricao())
                                                .nomePiloto(optVoo.get().getPiloto().getNome())
                                                .status(optVoo.get().getStatus().name())
                                                .build());
    }

    @Override
    public TransferDto<List<PainelVooDto>> recuperarVoos() {
        Optional<List<Voo>> optVoos = vooDao.findAll();

        if(!optVoos.isPresent())
            return new TransferDto<List<PainelVooDto>>(HttpStatus.OK, new ArrayList());


        List<PainelVooDto> listVoos = optVoos.get().stream().map(v -> PainelVooDto.builder()
                                            .cidadeDestino(v.getCidadeDestino().getNome())
                                            .cidadeOrigem(v.getCidadeOrigem().getNome())
                                            .dataChegada(new DateTime(v.getHoraSaida()).toString(DATE_TIME_FORMAT))
                                            .dataPartida(new DateTime(v.getHoraChegada()).toString(DATE_TIME_FORMAT))
                                            .descricaoAviao(v.getAviao().getDescricao())
                                            .nomePiloto(v.getPiloto().getNome())
                                            .status(v.getStatus().name())
                                            .build())
                                .collect(Collectors.toList());

        return new TransferDto<List<PainelVooDto>>(HttpStatus.OK,
                                                    listVoos);
    }


}
