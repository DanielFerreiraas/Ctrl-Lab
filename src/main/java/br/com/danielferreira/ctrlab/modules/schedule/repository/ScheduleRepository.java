package br.com.danielferreira.ctrlab.modules.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.ctrlab.modules.schedule.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    
}
