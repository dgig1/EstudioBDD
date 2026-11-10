package br.com.estudiobdd.controller;

import br.com.estudiobdd.dto.Requests.*;
import br.com.estudiobdd.dto.Responses.*;
import br.com.estudiobdd.model.Prioridade;
import br.com.estudiobdd.service.EstudioService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController @RequestMapping("/api")
public class ApiController {
 private final EstudioService service; public ApiController(EstudioService s){service=s;}
 @GetMapping("/usuarios") public List<UsuarioRes> usuarios(){return service.listarUsuarios();}
 @PostMapping("/usuarios") @ResponseStatus(HttpStatus.CREATED) public UsuarioRes criarUsuario(@Valid @RequestBody UsuarioReq r){return service.criarUsuario(r);}
 @GetMapping("/projetos") public List<ProjetoRes> projetos(){return service.listarProjetos();}
 @PostMapping("/projetos") @ResponseStatus(HttpStatus.CREATED) public ProjetoRes criarProjeto(@Valid @RequestBody ProjetoReq r){return service.criarProjeto(r);}
 @PutMapping("/projetos/{id}") public ProjetoRes atualizarProjeto(@PathVariable Long id,@Valid @RequestBody ProjetoReq r){return service.atualizarProjeto(id,r);}
 @DeleteMapping("/projetos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluirProjeto(@PathVariable Long id){service.excluirProjeto(id);}
 @GetMapping("/historias") public List<HistoriaRes> historias(@RequestParam(required=false) Long projetoId,@RequestParam(required=false) Prioridade prioridade){return service.listarHistorias(projetoId,prioridade);}
 @GetMapping("/historias/{id}") public HistoriaRes historia(@PathVariable Long id){return service.obterHistoria(id);}
 @PostMapping("/historias") @ResponseStatus(HttpStatus.CREATED) public HistoriaRes criarHistoria(@Valid @RequestBody HistoriaReq r){return service.criarHistoria(r);}
 @PutMapping("/historias/{id}") public HistoriaRes atualizarHistoria(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid,@Valid @RequestBody HistoriaReq r){return service.atualizarHistoria(id,r,uid);}
 @DeleteMapping("/historias/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluirHistoria(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid){service.excluirHistoria(id,uid);}
 @PostMapping("/historias/{id}/cenarios") @ResponseStatus(HttpStatus.CREATED) public CenarioRes criarCenario(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid,@Valid @RequestBody CenarioReq r){return service.criarCenario(id,r,uid);}
 @PostMapping("/cenarios/{id}/passos") @ResponseStatus(HttpStatus.CREATED) public PassoRes criarPasso(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid,@Valid @RequestBody PassoReq r){return service.criarPasso(id,r,uid);}
 @GetMapping("/cenarios/{id}") public CenarioRes cenario(@PathVariable Long id){return service.obterCenario(id);}
 @PutMapping("/cenarios/{id}") public CenarioRes atualizarCenario(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid,@RequestBody Map<String,String> body){return service.atualizarCenario(id,body.get("titulo"),uid);}
 @DeleteMapping("/cenarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluirCenario(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid){service.excluirCenario(id,uid);}
 @PutMapping("/passos/{id}") public PassoRes atualizarPasso(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid,@Valid @RequestBody PassoReq r){return service.atualizarPasso(id,r,uid);}
 @DeleteMapping("/passos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluirPasso(@PathVariable Long id,@RequestHeader("X-Usuario-Id") Long uid){service.excluirPasso(id,uid);}
 @PostMapping("/historias/{id}/sugestoes") @ResponseStatus(HttpStatus.CREATED) public SugestaoRes criarSugestao(@PathVariable Long id,@Valid @RequestBody SugestaoReq r){return service.criarSugestao(id,r);}
 @PutMapping("/sugestoes/{id}/decisao") public SugestaoRes decidir(@PathVariable Long id,@Valid @RequestBody DecisaoReq r){return service.decidirSugestao(id,r);}
 @GetMapping("/historias/{id}/exportar") public ResponseEntity<byte[]> exportar(@PathVariable Long id){byte[] b=service.exportarFeature(id).getBytes(StandardCharsets.UTF_8);return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=historia-"+id+".feature").contentType(MediaType.parseMediaType("text/plain; charset=UTF-8")).body(b);}
 @GetMapping("/resumo") public Map<String,Object> resumo(@RequestParam(required=false) Long projetoId){return service.resumo(projetoId);}
}
