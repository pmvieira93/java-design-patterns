/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Dependency: Class А can be affected by changes in class B.
 * 
 * Dependency is the most basic and the weakest type of relations 
 * between classes. There is a dependency between two classes
 * if some changes to the definition of one class might result
 * in modifications to another class. Dependency typically occurs
 * when you use concrete class names in your code.
 * 
 * @author pedro.vieira
 */
public class Dependency {

    class Professor {

        // Dependency
        void teach(Course c) {
            // Do something
        }
    }

    class Course {

        String name;
    }

}
