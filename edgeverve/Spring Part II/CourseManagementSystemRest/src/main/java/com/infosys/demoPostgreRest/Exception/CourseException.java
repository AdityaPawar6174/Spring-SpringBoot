package com.infosys.demoPostgreRest.Exception;

public class CourseException extends RuntimeException{
    public  CourseException(){}

    public CourseException(int id){
        super("Cannot find course with this Id");
    }
}
