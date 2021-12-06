package data;

import models.Person;
import utils.BoyerMoore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PersonsData {

    private static PersonsData instance = null;

    private List<Person> persons;

    private PersonsData(){
        persons = new ArrayList<Person>();
    }

    public static PersonsData getInstance()
    {
        if (instance == null)
            instance = new PersonsData();

        return instance;
    }

    public void add(Person person){
        if(!persons.contains(person)){
            persons.add(person);
            System.out.println("Successfully added");
        } else {
            System.out.println("Person already exists.");
        }
    }

    public List<Person> getAll(){
        return persons;
    }

    public Person getOneById(String id){
        return persons.stream().filter(person -> Objects.equals(person.getId(), id)).collect(Collectors.toList()).get(0);
    }

    public List<Person> getByEmails(String[] domains){
        List<Person> data = new ArrayList<Person>();

        for (String domain:
             domains) {
            data.addAll(getByEmail(domain));
        }

        return data;
    }

    // Base
    public List<Person> getByEmail(String domain){
        return persons.stream().filter(person -> person.getEmail().contains(domain)).collect(Collectors.toList());
    }

    // Ejemplo
    public List<Person> getByEmailUsingBoyerMoore(String domain){
        return persons.stream().filter(person -> BoyerMoore.find(person.getEmail(), domain) != -1).collect(Collectors.toList());
    }
}
