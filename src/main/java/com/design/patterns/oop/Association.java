/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Association: Object А knows about object B. Class A depends on B.
 * 
 * Association is a relationship in which one object uses or interacts with another.
 * 
 * @author pedro.vieira
 */
public class Association {

    class Professor {
        
        // Association
        Student student;
        
        // Dependency
        void teach(Course c) {
            // Do something
        }
    }

    class Course {

        String name;
    }

    class Student {

        String name;
    }

}
