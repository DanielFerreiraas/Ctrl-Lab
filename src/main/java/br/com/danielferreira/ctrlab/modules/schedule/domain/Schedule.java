package br.com.danielferreira.ctrlab.modules.schedule.domain;

import br.com.danielferreira.ctrlab.modules.course.domain.Course;
import br.com.danielferreira.ctrlab.modules.laboratory.domain.Laboratory;
import br.com.danielferreira.ctrlab.modules.user.domain.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laboratory_id", referencedColumnName = "id")
    private Laboratory laboratory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    private String date;
    private String startHour;
    private String endHour;

    public Schedule(Laboratory laboratory,User user, Course course, String date, String startHour,
            String endHour) {
        this.laboratory = laboratory;
        this.user = user;
        this.course = course;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }
}
