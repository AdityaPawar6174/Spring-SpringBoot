package org.aditya.config;

import org.aditya.Alien;
import org.aditya.Computer;
import org.aditya.Desktop;
import org.aditya.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration // Class level Annotation --> indicates configuration class has Bean Definitions
@ComponentScan("org.aditya")
public class AppConfig {

//    @Bean
//    public Alien alien(@Autowired @Qualifier("desktop") Computer comp){ // Autowired annotation is optional it can be skipped
//        Alien obj = new Alien();
//        obj.setAge(25);
//        obj.setComp(comp);
//        return obj;
//    }
//
////    @Bean(name = {"comp2", "desktop1", "Beast"}) // --> custom name for the Bean
//    @Bean // Method Level Annotation --> for declaring Bean
////    @Scope("prototype") // scope annotation for using multiple objects of single Bean by declaring scope as prototype
//    public Desktop desktop() {  // Desktop --> return type (Bean type like POJO) &&  desktop --> Bean Name (by Default) which is method
//        return new Desktop();// returns instance/object of Desktop class
//    }
//
//    @Bean
////    @Primary  // primary annotation declares Bean for autowiring
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
