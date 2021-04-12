package br.com.atech.empresaarea.web.rest.controller;

import br.com.atech.empresaarea.dao.AviaoDao;
import br.com.atech.empresaarea.dao.domain.Aviao;
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
@RequestMapping(value = "/aviao")
@Api(value = "Aviao", description = "Api para Avião")
public class AviaoController {

    @Autowired
    private AviaoDao aviaoDao;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Recupera o avião pelo seu id")
    public DeferredResult<ResponseEntity<?>> show(@ApiParam(value = "Retornar o avião pelo seu código", required = true)
                                                  @PathVariable("id") Long id) {

        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {

            Optional<Aviao> optAviao = aviaoDao.getOne(id);
            deferred.setResult(ResponseEntity.of(optAviao));

            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

    @PostMapping
    @ApiOperation(value = "Cadastra novo avião")
    public DeferredResult<ResponseEntity<?>> create(@ApiParam(value = "Dados para cadastro de novo avião", required = true)
                                                    @RequestBody Aviao payload) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Aviao> optAviao = aviaoDao.save(payload);
            deferred.setResult(ResponseEntity.of(optAviao));

            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

    @PutMapping
    @ApiOperation(value = "Atualiza os dados da cidade")
    public DeferredResult<ResponseEntity<?>> update(@RequestBody  Aviao payload) {
        DeferredResult<ResponseEntity<?>> deferred = new DeferredResult<>();
        try {
            Optional<Aviao> optAvao = aviaoDao.saveAndFlush(payload);
            deferred.setResult(ResponseEntity.of(optAvao));
            return deferred;
        }catch (Exception e ){
            deferred.setResult(new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST));
            return deferred;
        }
    }

}
