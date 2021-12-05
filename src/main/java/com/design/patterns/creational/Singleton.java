/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.creational;

import java.util.Calendar;
import java.util.Objects;

/**
 * Singleton is a creational design pattern that lets you ensure that a class
 * has only one instance, while providing a global access point to this
 * instance.
 *
 * Problem The Singleton pattern solves two problems at the same time, violating
 * the Single Responsibility Principle. - Ensure that a class has just a single
 * instance. - Provide a global access point to that instance
 *
 * Real-World Analogy The government is an excellent example of the Singleton
 * pattern. A country can have only one official government.
 *
 * Applicability Use the Singleton pattern when a class in your program should
 * have just a single instance available to all clients; for example, a single
 * database object shared by different parts of the program. Use the Singleton
 * pattern when you need stricter control over global variables.
 *
 * How to Implement - Add a private static field to the class for storing the
 * singleton instance. - Declare a public static creation method for getting the
 * singleton instance. - Implement “lazy initialization” inside the static
 * method. It should create a new object on its first call and put it into the
 * static field. The method should always return that instance on all subsequent
 * calls. - Make the constructor of the class private. The static method of the
 * class will still be able to call the constructor, but not the other objects.
 * - Go over the client code and replace all direct calls to the singleton’s
 * constructor with calls to its static creation method.
 *
 * @author pedro.vieira
 * @see https://refactoring.guru/design-patterns/singleton
 */
public class Singleton {

    private static Singleton instance = null;

    private final Calendar instanceTime;

    private Singleton() {
        this.instanceTime = Calendar.getInstance();
    }

    public static Singleton instance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public Calendar getInstanceTime() {
        return instanceTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.instanceTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Singleton other = (Singleton) obj;
        if (!Objects.equals(this.instanceTime, other.instanceTime)) {
            return false;
        }
        return true;
    }

    /*
    class President {
        
        private static President instance;
        
        private President(){}
        
        public static President getInstance(){
            if(instance == null){
                instance = new President();
            }
            return instance;
        }
        
        public String talk(){
            return "Hello World!";
        }
    }
     */
}
