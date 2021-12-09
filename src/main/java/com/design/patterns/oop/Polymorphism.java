/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Polymorphism is the ability of a program to detect the real
 * class of an object and call its implementation even when its
 * real type is unknown in the current context.
 * 
 * @author pedro.vieira
 */
public class Polymorphism {
    
    
    abstract class Animal {
        abstract void makeSound();
    }
    
    class Cat extends Animal {

        @Override
        void makeSound() {
            System.out.println("Meow!");
        }
        
    }
    
    class Dog extends Animal {

        @Override
        void makeSound() {
            System.out.println("Bark!");
        }
        
    }
}
