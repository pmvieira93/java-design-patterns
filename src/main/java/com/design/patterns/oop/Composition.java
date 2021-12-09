/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.oop;

/**
 * Composition: object A consists of objects B; A manages life cycle of B; B
 * can’t live without A
 *
 * Composition is a specific kind of aggregation, where one object is composed
 * of one or more instances of the other. The distinction between this relation
 * and others is that the component can only exist as a part of the container.
 *
 * @author pedro.vieira
 */
public class Composition {

    class Building {

        // Composition: ROOM can't live without BUILDING
        Room[] rooms;

    }

    class Room {
    }
}
