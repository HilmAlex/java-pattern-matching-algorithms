package data;

import org.junit.jupiter.api.Test;

import model.Person;
import services.PersonService;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonsDataTest {
    PersonService service = PersonService.getInstance();

    @Test
    void filterByEmail() {
        String src = new File(".").getAbsolutePath() + "/src/main/resources/LeakedData.txt";
        service.read(src);

        String[] emails = {"gmail.com", "yahoo.com"};
        // List<Person> dataByEmail = PersonData.getInstance().getByEmail("gmail.com");
        // List<Person> dataByEmails = PersonData.getInstance().getByEmails(emails);

        assertTrue("" != null);
    }

    @Test
    void filterByCondition() {
        String src = new File(".").getAbsolutePath() + "/src/main/resources/LeakedData.txt";
        service.read(src);

        String[] emails = {"gmail.com", "yahoo.com"};
        
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
    void performance(Runnable runnable) {
        Long start = System.currentTimeMillis();

        

        Long end = System.currentTimeMillis();
        Long executionTime = end-start;

        System.out.println("Execution time: " + executionTime);
    }
}