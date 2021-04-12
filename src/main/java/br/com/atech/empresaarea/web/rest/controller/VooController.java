package br.com.atech.empresaarea.web.rest.controller;

import br.com.atech.empresaarea.dao.TransferDto;
import br.com.atech.empresaarea.dto.PainelVooDto;
import br.com.atech.empresaarea.service.VooService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@Controller
@RequestMapping(value = "/voo")
@Api(value = "Voo", description = "Api para consulta de voos")
public class VooController {

    @Autowired
    private VooService vooService;

    @GetMapping("/{numero}")
    @ResponseBody
    @ApiOperation(value = "Recupera o voo pelo seu numero")
    public DeferredResult<ResponseEntity<?>> show(   @ApiParam(value = "Retornar retorna o voo pelo seu número", required = true)
                                                     @PathVariable("numero") Long numero) {

        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();

        TransferDto<PainelVooDto> transfPainelVoo = vooService.recuperarVoo(numero);

        if(HttpStatus.OK.equals(transfPainelVoo.getHttpStatus()))
             deferred.setResult(new ResponseEntity<>(transfPainelVoo.getT(), transfPainelVoo.getHttpStatus()));
        else deferred.setResult(new ResponseEntity<>(transfPainelVoo.getHttpStatus()));

        return deferred;
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Lista todos os voo")
    public DeferredResult<ResponseEntity<?>> showAll() {

        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();

        TransferDto<List<PainelVooDto>> transfPainelVoos = vooService.recuperarVoos();

        if(HttpStatus.OK.equals(transfPainelVoos.getHttpStatus()))
            deferred.setResult(new ResponseEntity<>(transfPainelVoos.getT(), transfPainelVoos.getHttpStatus()));
        else deferred.setResult(new ResponseEntity<>(transfPainelVoos.getHttpStatus()));

        return deferred;
    }

}
