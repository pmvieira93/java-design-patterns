/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Different models of the same real-world object.
 * 
 * @author pedro.vieira
 */
public class Abstraction {
    
    // Airplane
    class AirplaneSimulator {
        int speed;
        double altitude;
        double rollAngle;
        double pitchAngle;
        double yawAngle;
        
        void fly(){
            
        }
    }
    
    // Airplane
    class AirplaneBooking {
        
        static final int NUM_OF_SEATS=250;
        String[] seats;
        
        boolean reserveSeat(String detail, int position){
            return true;
        }
    }
}
