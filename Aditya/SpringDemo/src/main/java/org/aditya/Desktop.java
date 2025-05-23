package org.aditya;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("comp2") // component Name --> comp2
@Primary // used to set component primary for the autowiring
@Scope("prototype") // scope annotation used as prototype to use the multiple Beans of the Desktop class
public class Desktop implements Computer{

    public Desktop(){
        System.out.println("Desktop Object Created...");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using Desktop");
    }
}