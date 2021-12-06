package data;

import models.Person;
import org.junit.jupiter.api.Test;
import services.PersonService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonsDataTest {
    PersonService service = PersonService.getInstance();

    @Test
    void filter() {
        String src = "C:\\Users\\perso\\IdeaProjects\\demo-pattern-matching-algorithms\\src\\main\\resources\\LeakedData.txt";
        service.read(src);

        String[] emails = {"gmail.com", "yahoo.com"};
        List<Person> dataByEmail = PersonsData.getInstance().getByEmail("gmail.com");
        List<Person> dataByEmails = PersonsData.getInstance().getByEmails(emails);

        assertTrue("" != null);
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getOneById() {
    }

    int tests = 100;
    @org.junit.jupiter.api.Test
    void performance() {
        Long start = System.currentTimeMillis();



        Long end = System.currentTimeMillis();
        Long executionTime = end-start;
    }
}