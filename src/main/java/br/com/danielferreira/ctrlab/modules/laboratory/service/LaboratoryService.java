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

  public Laboratory createLaboratory(Laboratory laboratory) {
    return laboratoryRepository.save(laboratory);
  }

  public List<Laboratory> listLaboratories() {
    Sort sort = Sort.by(Direction.ASC, "name");
    return laboratoryRepository.findAll(sort);
  }

  public Laboratory getById(String id) throws Exception {
    Optional<Laboratory> laboratoryOptional = laboratoryRepository.findById(id);

    if (laboratoryOptional.isEmpty()) {
        throw new Exception("Esse laboratório não existe!");
    }

    return laboratoryOptional.get();
}

  public Laboratory updateLaboratory(String id, Laboratory laboratory) {
    laboratoryRepository.findById(id).ifPresentOrElse((existingLaboratory) -> {
      laboratory.setId(id);
      laboratoryRepository.save(laboratory);
    }, () -> {
      throw new BadRequestException("Laboratory %d não existe! ".formatted(id));
    });

    return laboratory;
  }

  public Laboratory deleteLaboratory(String id) {
    laboratoryRepository.findById(id)
        .ifPresentOrElse((existingLaboratory) -> laboratoryRepository.delete(existingLaboratory), () -> {
          throw new BadRequestException("Laboratory %d não existe! ".formatted(id));
        });
    return null;
  }
}
