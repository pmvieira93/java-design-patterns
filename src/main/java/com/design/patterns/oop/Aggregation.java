/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Aggregation: object A contains objects B; B can live without A
 *
 * Aggregation is a specialized type of association that represents
 * “one-to-many”, “many-to-many” or “whole-part” relations between multiple
 * objects. Usually, under aggregation, an object “has” a set of other objects
 * and serves as a container or collection.
 *
 * @author pedro.vieira
 */
public class Aggregation {

    class Professor {

    }

    class Department {

        // Aggregation: one to many
        Professor[] professors;
    }

    //  OR
    
    class Wheel {

        Car car;
    }

    class Car {

        Wheel[] wheels;
    }
}
