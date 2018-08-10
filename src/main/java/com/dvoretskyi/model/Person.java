package com.dvoretskyi.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Created by Orest on 5/24/2018.
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getAllPersons",query = "select p from Person p")
})
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @Column
  private String name;
  @Column
  private String surname;
  @Column
  private String middleName;
  @Column
  private String passport;



  @OneToMany(mappedBy = "person")
  @Column
  private Set<Bicycle> bicycleSet;

  public Person() {
  }

  public Person(String name, String surname, String middleName, String passport) {

    this.name = name;
    this.surname = surname;
    this.middleName = middleName;
    this.passport = passport;

  }

  public Person(int id, String name, String surname, String middleName, String passport,
      String bicycleSet) {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public Set<Bicycle> getBicycleSet() {
    return bicycleSet;
  }

  public void setBicycleSet(Set<Bicycle> bicycleSet) {
    this.bicycleSet = bicycleSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Person person = (Person) o;

    if (id != person.id) {
      return false;
    }
    if (name != null ? !name.equals(person.name) : person.name != null) {
      return false;
    }
    if (surname != null ? !surname.equals(person.surname) : person.surname != null) {
      return false;
    }
    if (middleName != null ? !middleName.equals(person.middleName) : person.middleName != null) {
      return false;
    }
    if (passport != null ? !passport.equals(person.passport) : person.passport != null) {
      return false;
    }
    return bicycleSet != null ? bicycleSet.equals(person.bicycleSet) : person.bicycleSet == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    result = 31 * result + (passport != null ? passport.hashCode() : 0);
    result = 31 * result + (bicycleSet != null ? bicycleSet.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", middleName='" + middleName + '\'' +
        ", passport='" + passport + '\'' +
        ", bicycleSet=" + bicycleSet +
        '}';
  }
}
