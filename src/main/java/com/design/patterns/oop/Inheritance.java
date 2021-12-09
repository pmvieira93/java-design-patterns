/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Class А inherits interface and implementation of class B but can extend it. 
 * Objects A can be treated as B. Class A depends on B.
 * 
 * Inheritance is the ability to build new classes on top of existing ones.
 * 
 * @author pedro.vieira
 */
public class Inheritance {
    
    class Animal {
        
        String name;
    }
    
    class Cat extends Animal implements FourLegged, OxygenBreather {

        @Override
        public void run(String destination) {
            
        }

        @Override
        public void breathe() {
            
        }
        
    }
    
    class Bird extends Animal implements OxygenBreather {

        @Override
        public void breathe() {
            
        }
        
    }
    
    interface FourLegged {
        void run(String destination);
    }
    
    interface OxygenBreather {
        void breathe();
    }
    
}
