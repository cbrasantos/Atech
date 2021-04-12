package br.com.atech.empresaarea.web.rest.controller;

import br.com.atech.empresaarea.dao.PilotoDao;
import br.com.atech.empresaarea.dao.domain.Piloto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Controller
@RequestMapping(value = "/piloto")
@Api(value = "Piloto", description = "Api para Piloto")
public class PilotoController {

    @Autowired
    private PilotoDao pilotoDao;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Recupera o piloto pelo seu id")
    public DeferredResult<ResponseEntity<?>> show(@ApiParam(value = "Retornar o piloto pelo seu id", required = true)
                                                  @PathVariable("id") Long id) {

        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Piloto> optPiloto = pilotoDao.getOne(id);
            deferred.setResult(ResponseEntity.of(optPiloto));
            return deferred;
        } catch (Exception e) {
            deferred.setResult(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

    @PostMapping
    @ApiOperation(value = "Cadastra novo piloto")
    public DeferredResult<ResponseEntity<?>> create(@ApiParam(value = "Dados para cadastro de novo piloto", required = true)
                                                    @RequestBody Piloto payload) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Piloto> optPiloto = pilotoDao.save(payload);
            deferred.setResult(ResponseEntity.of(optPiloto));
            return deferred;
        } catch (Exception e) {
            deferred.setResult(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }


    @PutMapping
    @ApiOperation(value = "Atualiza os dados do piloto")
    public DeferredResult<ResponseEntity<?>> update(@RequestBody Piloto piloto) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Piloto> optPiloto = pilotoDao.saveAndFlush(piloto);
            deferred.setResult(ResponseEntity.of(optPiloto));
            return deferred;
        } catch (Exception e) {
            deferred.setResult(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

}