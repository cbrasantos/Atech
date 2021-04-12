package br.com.atech.empresaarea.web.rest.controller;

import br.com.atech.empresaarea.dao.CidadeDao;
import br.com.atech.empresaarea.dao.domain.Cidade;
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
@RequestMapping(value = "/cidade")
@Api(value = "Cidade", description = "Api para Cidade")
public class CidadeController {

    @Autowired
    private CidadeDao cidadeDao;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Recupera a cidade pelo seu código")
    public DeferredResult<ResponseEntity<?>> show(@ApiParam(value = "Retornar a cidade pelo seu código", required = true)
                                                  @PathVariable("id") Long id) {

        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Cidade> optCidade = cidadeDao.getOne(id);
            deferred.setResult(ResponseEntity.of(optCidade));
            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

    @PostMapping
    @ApiOperation(value = "Cadastra nova cidade")
    public DeferredResult<ResponseEntity<?>> create(@ApiParam(value = "Dados para cadastro de nova cidade", required = true)
                                                    @RequestBody Cidade payload) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Cidade> optionalCidade = cidadeDao.save(payload);
            deferred.setResult(ResponseEntity.of(optionalCidade));
            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }


    @PutMapping
    @ApiOperation(value = "Atualiza os dados da cidade")
    public DeferredResult<ResponseEntity<?>> update(@RequestBody  Cidade payload) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Cidade> optCidade = cidadeDao.saveAndFlush(payload);
            deferred.setResult(ResponseEntity.of(optCidade));
            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }
}
