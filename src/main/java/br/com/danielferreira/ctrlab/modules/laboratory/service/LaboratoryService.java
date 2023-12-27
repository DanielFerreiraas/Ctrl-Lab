package br.com.danielferreira.ctrlab.modules.laboratory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.danielferreira.ctrlab.exception.BadRequestException;
import br.com.danielferreira.ctrlab.modules.laboratory.domain.Laboratory;
import br.com.danielferreira.ctrlab.modules.laboratory.repository.LaboratoryRepository;

@Service
public class LaboratoryService {
  private LaboratoryRepository laboratoryRepository;

  public LaboratoryService(LaboratoryRepository laboratoryRepository) {
    this.laboratoryRepository = laboratoryRepository;
  }

  public List<Laboratory> create(Laboratory laboratory) {
    laboratoryRepository.save(laboratory);
    return list();
  }

  public List<Laboratory> list() {
    Sort sort = Sort.by(Direction.ASC, "name");
    return laboratoryRepository.findAll(sort);
  }

  public Optional<Laboratory> getById(String id) {
    return laboratoryRepository.findById(id);
  }

  public List<Laboratory> update(String id, Laboratory laboratory) {
    laboratoryRepository.findById(id).ifPresentOrElse((existingLaboratory) -> {
      laboratory.setId(id);
      laboratoryRepository.save(laboratory);
    }, () -> {
      throw new BadRequestException("Laboratory %d não existe! ".formatted(id));
    });

    return list();

  }

  public List<Laboratory> delete(String id) {
    laboratoryRepository.findById(id).ifPresentOrElse((existingLaboratory) -> laboratoryRepository.delete(existingLaboratory), () -> {
      throw new BadRequestException("Laboratory %d não existe! ".formatted(id));
    });
    return list();
  }
}
