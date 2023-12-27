package br.com.danielferreira.ctrlab.modules.laboratory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.ctrlab.modules.laboratory.domain.Laboratory;

public interface LaboratoryRepository extends JpaRepository<Laboratory, String> {

}
