package data;

import models.Person;
import utils.BoyerMoore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonsData {

    private static PersonsData instance = null;

    private List<Person> persons;

    private PersonsData() {
        persons = new ArrayList<Person>();
    }

    public static PersonsData getInstance() {
        if (instance == null)
            instance = new PersonsData();

        return instance;
    }

    public void add(Person person) {
        if (persons.contains(person)) {
            System.out.println("Person already exists." + person);
        } else {
            persons.add(person);
        }
    }

    public List<Person> getByCondition(Predicate<Person> condition) {
        return persons.stream().filter(condition).collect(Collectors.toList());
    }

    // Base
    public List<Person> getByEmail(String domain) {
        return getByCondition(person -> person.getEmail().contains(domain));
    }

    // Ejemplo
    public List<Person> getByEmailUsingBoyerMoore(String domain) {
        return getByCondition(person -> BoyerMoore.find(person.getEmail(), domain) != -1);
    }

    // Personalizar algoritmo
    public List<Person> getByEmails(String[] domains) {
        List<Person> data = new ArrayList<Person>();

        for (String domain : domains) {
            data.addAll(getByEmail(domain));
        }

        return data;
    }

    public List<Person> getByEmails(String[] domains, Function<String, List<Person>> method) {
        List<Person> data = new ArrayList<Person>();

        for (String domain : domains) {
            data.addAll(method.apply(domain));
        }

        return data;
    }

    public List<Person> getByEmailsUsingBoyerMoore(String[] domains) {
        return getByEmails(domains, domain -> getByEmailUsingBoyerMoore(domain));
    }
}
