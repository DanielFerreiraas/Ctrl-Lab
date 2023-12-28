package br.com.danielferreira.ctrlab.modules.schedule.web;

import java.util.List;

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

import br.com.danielferreira.ctrlab.modules.schedule.domain.Schedule;
import br.com.danielferreira.ctrlab.modules.schedule.service.ScheduleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    ResponseEntity<Schedule> create(@Valid @RequestBody Schedule schedule) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(scheduleService.createSchedule(schedule));
    }

    @GetMapping
    List<Schedule> list() {
        return scheduleService.listSchedules();
    }

    @PutMapping("{id}")
    ResponseEntity<Schedule> update(@PathVariable String id, @RequestBody Schedule schedule) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(scheduleService.updateSchedule(id, schedule));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Schedule> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(scheduleService.deleteSchedule(id));
    }

}
