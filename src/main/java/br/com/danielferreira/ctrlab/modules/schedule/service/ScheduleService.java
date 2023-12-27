package br.com.danielferreira.ctrlab.modules.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.danielferreira.ctrlab.exception.BadRequestException;
import br.com.danielferreira.ctrlab.modules.schedule.domain.Schedule;
import br.com.danielferreira.ctrlab.modules.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {
    
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> listSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule updateSchedule(String id, Schedule schedule) {
      scheduleRepository.findById(id).ifPresentOrElse((existingSchedule) -> {
        schedule.setId(id);
        scheduleRepository.save(schedule);
      }, () -> {
        throw new BadRequestException("Schedule %d não existe! ".formatted(id));
      });

      return schedule;
  }

  public Schedule deleteSchedule(String id) {
    scheduleRepository.findById(id).ifPresentOrElse((existingSchedule) -> scheduleRepository.delete(existingSchedule), () -> {
      throw new BadRequestException("Schedule %d não existe! ".formatted(id));
    });
    return null;
  }
}
