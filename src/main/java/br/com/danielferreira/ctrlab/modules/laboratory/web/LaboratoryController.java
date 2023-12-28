package br.com.danielferreira.ctrlab.modules.laboratory.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielferreira.ctrlab.modules.laboratory.domain.Laboratory;
import br.com.danielferreira.ctrlab.modules.laboratory.service.LaboratoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

  private LaboratoryService laboratoryService;

  public LaboratoryController(LaboratoryService laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  @PostMapping
  ResponseEntity<Laboratory> create(@Valid @RequestBody Laboratory laboratory) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(laboratoryService.createLaboratory(laboratory));
  }

  @GetMapping
  List<Laboratory> list() {
    return laboratoryService.listLaboratories();
  }

  @GetMapping("{id}")
  Optional<Laboratory> getById(@PathVariable String id) {
    return laboratoryService.getById(id);
  }

  @PutMapping("{id}")
  ResponseEntity<Laboratory> update(@PathVariable String id, @RequestBody Laboratory laboratory) {
    return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(laboratoryService.updateLaboratory(id, laboratory));
  }

  @DeleteMapping("{id}")
  ResponseEntity<Laboratory> delete(@PathVariable String id) {
    return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(laboratoryService.deleteLaboratory(id));
  }
}
