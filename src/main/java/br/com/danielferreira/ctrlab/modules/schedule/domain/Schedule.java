package br.com.danielferreira.ctrlab.modules.schedule.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "schedule")
@Table(name = "schedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String laboratoryId;
    private String userId;
    private String courseId;
    private String date;
    private String startHour;
    private String endHour;
    
    public Schedule(String laboratoryId, String userId, String courseId, String date, String startHour, String endHour){
        this.laboratoryId = laboratoryId;
        this.userId = userId;
        this.courseId = courseId;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }
}
