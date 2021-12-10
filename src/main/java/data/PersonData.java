package data;

import models.Person;
import utils.patternMatching.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonData {

    private static PersonData instance = null;

    private List<Person> persons;

    private PersonData() {
        persons = new ArrayList<Person>();
    }

    public static PersonData getInstance() {
        if (instance == null)
            instance = new PersonData();

        return instance;
    }

    public void add(Person person) {
        if (persons.contains(person)) {
            System.out.println("\nPerson already exists." + person + "\n");
        } else {
            persons.add(person);
        }
    }

    public List<Person> getByCondition(Predicate<Person> condition) {
        return persons.stream().filter(condition).collect(Collectors.toList());
    }

    // Ejemplo
    public List<Person> getByEmailUsingBruteForce(String domain) {
        return getByCondition(person -> BruteForce.find(person.getEmail(), domain) != -1);
    }

    public List<Person> getByEmailUsingKMP(String domain) {
        return getByCondition(person -> KMP.find(person.getEmail(), domain) != -1);
    }

    public List<Person> getByEmailUsingBoyerMoore(String domain) {
        return getByCondition(person -> BoyerMoore.find(person.getEmail(), domain) != -1);
    }

    public List<Person> getByEmails(String[] domains, Function<String, List<Person>> method) {
        List<Person> data = new ArrayList<Person>();

        for (String domain : domains) {
            data.addAll(method.apply(domain));
        }

        return data;
    }

    public List<Person> getByEmailsUsingBruteForce(String[] domains) {
        return getByEmails(domains, domain -> getByEmailUsingBruteForce(domain));
    }

    public List<Person> getByEmailsUsingKMP(String[] domains) {
        return getByEmails(domains, domain -> getByEmailUsingKMP(domain));
    }

    public List<Person> getByEmailsUsingBoyerMoore(String[] domains) {
        return getByEmails(domains, domain -> getByEmailUsingBoyerMoore(domain));
    }
}
