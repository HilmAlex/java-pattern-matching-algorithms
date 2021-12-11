package model;

import lombok.Data;

@Data 
public class Person {
    private String id;
    private String name;
    private String lastName;
    private String email;

    public Person(String[] data){
        this.setId(data[0]);
        this.setName(data[1]);
        this.setLastName(data[2]);
        this.setEmail(data[3]);
    }
}
