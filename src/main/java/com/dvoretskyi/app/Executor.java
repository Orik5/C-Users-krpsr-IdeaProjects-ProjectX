package com.dvoretskyi.app;

import com.dvoretskyi.model.Bicycle;
import com.dvoretskyi.model.Person;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Orest on 5/25/2018.
 */
public class Executor {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bmx");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
//Inserting DATA
//    String [] model={"BMX","RGD","REINER","WINNER","GT","CATALINA","GNOM"};
//    String [] color ={"red","black","white","yellow","green","grey","violet"};
//    String [] pasportId={"fg34345","hg779767","hu87787","ghy787","cv76t7","vg7786"};
//    Random random = new Random();
//    for (int i=1;i<=100;i++){
//      entityManager.persist(new Bicycle(model[random.nextInt(model.length)],
//          color[random.nextInt(color.length)],
//          pasportId[random.nextInt(pasportId.length)]));
//         }

//    Integer[] id = {1,2,3,4,5,6,7,8,9,0};
//    String[] name = {"Oleg", "Iwar", "Orest", "Ragnar", "Igor", "Volodymyr", "Gnom"};
//    String[] surname = {"Knife", "Black", "Gulock", "Master", "Geser", "Kiy", "Horyv"};
//    String[] middleName = {"Kuyomijk", "Yornyk", "Byorson", "Olgerson", "Ragnarson", "Olegich"};
//    String[] passport = {"fg34345", "hg779767", "hu87787", "ghy787", "cv76t7", "vg7786"};
//    Random random3 = new Random();
//    for (int i = 1; i <= 100; i++) {
//      entityManager.persist(new Person(
//          name[random3.nextInt(name.length)],
//          surname[random3.nextInt(surname.length)],
//          middleName[random3.nextInt(middleName.length)],
//          passport[random3.nextInt(passport.length)]));
//    }

//MEging change values
    //Person person =entityManager.find(Person.class,56);
    //  System.out.println(person);

    //Inserting value

//    Person person = new Person("Orest", "Dertocob", "Magnorson", "");
//
//    person.setId(1);
//    entityManager.merge(person);

    //Remove value
    //  entityManager.remove(entityManager.find(Person.class,8));

    ///Query!!!!!!!!!!
//    Query query = entityManager.createQuery("select p from Person as p");
//    List<Person> personList=query.getResultList();
//    for (Person person:personList) {
//      System.out.println(person);
//    }

    //Query more quickly

//    for(Person p:(List<Person>)entityManager.createQuery("select p from Person  p").getResultList()){
//      System.out.println(p);
//    }

    //With lambda e xpressions
//entityManager.createQuery("select a from Person as a").
//    getResultList().forEach(p -> System.out.println(p));

//    entityManager.createQuery("select p from Person as p").
//        getResultList().forEach(System.out::println);


    //Input values
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Input name of person");
//
//    Query query = entityManager.createQuery
//        ("select p from Person as  p where p.name = :name and p.surname = :surname");
//    query.setParameter("name", scanner.next());
//    System.out.println("Input surname of person");
//    query.setParameter("surname", scanner.next());
//    //Input list of persons
//   // List<Person>personList =query.getResultList();
//   // personList.forEach(System.out::println);
//
//    //Input single person
//    Person person= (Person) query.setMaxResults(1).getSingleResult();
//
//    System.out.println(person);



    //NamedQuery!!!!!! Very fast. Fastly then query!!
    //entityManager.createNamedQuery("getAllPersons").getResultList().forEach(System.out::println);



    // Set bicycle to person id

//    Bicycle bicycle = new Bicycle("GT","Blue","12342");
//    bicycle.setPerson(entityManager.find(Person.class,19));
//    entityManager.persist(bicycle);
  Random random = new Random();
    List <Person> personList = entityManager.createNamedQuery("getAllPersons").getResultList();
    String[] bicycleModels ={"GT","WhiteR","WINNER","bmx"};
    for(int i =0;i<100;i++){
      entityManager.persist(new Bicycle(bicycleModels
          [random.nextInt(bicycleModels.length)],personList.get(random.nextInt(personList.size()))));
    }
    entityManager.getTransaction().commit();
    entityManager.close();

    entityManagerFactory.close();
  }
}

