package com.dvoretskyi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Orest on 5/24/2018.
 */
@Entity
public class Bicycle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @Column
  private String model;
  @Column
  private String color;
  @Column
  private String passportId;

  @ManyToOne
  private Person person;

  public Bicycle() {
  }

  public Bicycle(String model, String color, String passportId) {
    this.model = model;
    this.color = color;
    this.passportId = passportId;

  }

  public Bicycle(String model, Person person) {
    this.model = model;
    this.person = person;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPassportId() {
    return passportId;
  }

  public void setPassportId(String passportId) {
    this.passportId = passportId;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Bicycle bicycle = (Bicycle) o;

    if (id != bicycle.id) {
      return false;
    }
    if (model != null ? !model.equals(bicycle.model) : bicycle.model != null) {
      return false;
    }
    if (color != null ? !color.equals(bicycle.color) : bicycle.color != null) {
      return false;
    }
    if (passportId != null ? !passportId.equals(bicycle.passportId) : bicycle.passportId != null) {
      return false;
    }
    return person != null ? person.equals(bicycle.person) : bicycle.person == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (model != null ? model.hashCode() : 0);
    result = 31 * result + (color != null ? color.hashCode() : 0);
    result = 31 * result + (passportId != null ? passportId.hashCode() : 0);
    result = 31 * result + (person != null ? person.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Bicycle{" +
        "id=" + id +
        ", model='" + model + '\'' +
        ", color='" + color + '\'' +
        ", passportId='" + passportId + '\'' +
        ", person=" + person +
        '}';
  }
}
