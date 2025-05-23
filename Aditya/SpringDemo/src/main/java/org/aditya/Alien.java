package org.aditya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {

    @Value("22") // assigns value to field ...afterwards spring dynamically manages it
    private int age;
    //private Laptop lap;

//    @Autowired // Field Injection autowiring here (not good to be used field injection)
//    @Qualifier("laptop") // Autowired Field ---> to dsitinguish between the Components of same Interface
    private Computer comp;

    public Alien(){ //constructor
        System.out.println("Alien Object Created...");
    }
//    @ConstructorProperties({"age","lap"}) // helps constructor injection (name attribute) to know the correct attribute type
//    public Alien(int age, Laptop lap) { //parameterised constructor
//        this.age = age;
//        this.lap = lap;
//    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
//        System.out.println("Setter called ");
        this.age = age;
    }

//    public Laptop getLap() {
//        return lap;
//    }
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }


    public Computer getComp() {
        return comp;
    }
    @Autowired // setter injection (it is always preferred)
    @Qualifier("comp1")
    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void code(){
        System.out.println("Coding by Alien");
        comp.compile();
    }
}
