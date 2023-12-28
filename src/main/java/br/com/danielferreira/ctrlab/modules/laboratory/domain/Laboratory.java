package br.com.danielferreira.ctrlab.modules.laboratory.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "laboratory")
@Table(name = "laboratory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laboratory {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String name;
  private String source;
  private String location;
  private String hourOpen;
  private String hourClose;

  public Laboratory(String name, String source, String location, String hourOpen, String hourClose) {
    this.name = name;
    this.source = source;
    this.location = location;
    this.hourOpen = hourOpen;
    this.hourClose = hourClose;
  }

}