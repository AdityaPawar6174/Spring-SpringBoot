package org.aditya;

import org.springframework.stereotype.Component;

@Component("comp1") // providing component a Name to avoid confusion due to Computer interface implementation
public class Laptop implements Computer{

    public Laptop(){
        System.out.println("Laptop Object Created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using Laptop");
    }
}