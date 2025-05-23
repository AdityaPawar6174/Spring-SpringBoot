package org.aditya;


import org.aditya.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//------------------------------ JAVA BASED CONFIGURATION --------------------------------------------------
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop dt = context.getBean("desktop",Desktop.class);
//        dt.compile();
//        Desktop dt1 = context.getBean("desktop",Desktop.class);
//        dt.compile();

        Alien obj = context.getBean(Alien.class);
        System.out.println(obj.getAge());
        obj.code();
 















//--------------------------------------------- XML BASED CONFIGURATION -------------------------------------------------------------------------------------------------
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // This line creates container &&& by the use of spring.xml config the bean declarations in the xml file ... cause creation of objects (beans) too
//        // ApplicationContext is an interface implemented by various classes ....here ClassPathXmlApplicationContext is one of them
//        Alien obj = context.getBean("alien", Alien.class);
//        // (Alien) is datatype for object... getBean returns object but we gave String as argument...so typecasting is required here
//        obj.setAge(21);
//        System.out.println(obj.getAge());
//        obj.code();
//        System.out.println("\n");
//
//        Alien obj2 = (Alien) context.getBean("alien");
//        System.out.println(obj2.age);
//        obj2.code();  // only single object created but method called twice

//        Desktop desk = context.getBean("comp2", Desktop.class); // this will create object and lazy-init eliminated
//        Desktop desk = context.getBean(Desktop.class);
//
//        Computer comp = context.getBean(Computer.class);
    }
}

// spirng.xml is configuration file for the spring beans ... where all the beans communication will take place usin XML
// 1st Project of Spring is ready ---> HURRAYYYY
