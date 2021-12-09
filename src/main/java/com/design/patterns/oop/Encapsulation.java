/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Implementation: Class А defines methods declared in interface B. Objects A 
 * can be treated as B. Class A depends on B.
 * 
 * Encapsulation is the ability of an object to hide parts of its 
 * state and behaviors from other objects, exposing only a limited 
 * interface to the rest of the program
 * 
 * @author pedro.vieira
 */
public class Encapsulation {
    
    interface FlyingTransport {
        void fly(String origin, String destination, String[] passengers);
    }
    
    class Airport {
        
        // Airport class USE FlyingTransport class
        void accept(FlyingTransport vehicle){
            vehicle.fly("OPO", "PDL", null);
        }
    }
    
    
    class Helicopter implements FlyingTransport {
        
        int numOfSeats;

        public Helicopter(int numOfSeats) {
            this.numOfSeats = numOfSeats;
        }

        @Override
        public void fly(String origin, String destination, String[] passengers) {
            // Do something
        }
        
    }
    
    class Airplane implements FlyingTransport {

        int numOfSeats;
        
        @Override
        public void fly(String origin, String destination, String[] passengers) {
            
        }
        
    }
    
    class DomesticatedGryphon implements FlyingTransport {

        @Override
        public void fly(String origin, String destination, String[] passengers) {
            
        }
        
    }
    
    
}
