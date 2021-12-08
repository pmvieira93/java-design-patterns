/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.structural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author pedro.vieira
 */
public class Composite {

    //
    //  Graphic Example
    //
    interface Graphic {

        void move(double x, double y);

        void draw();

    }

    class Dot implements Graphic {

        double x;
        double y;

        Dot(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void move(double x, double y) {
            this.x += x;
            this.y += y;
        }

        @Override
        public void draw() {
            // DRAW a Dot at x and y positions
            System.out.println("DRAW a Dot at x and y positions!");
        }

    }

    class Circle extends Dot {

        double radius;

        Circle(double x, double y, double radius) {
            super(x, y);
            this.radius = radius;
        }

        @Override
        public void draw() {
            // DRAW a Circle at x and y positions with radius
            System.out.println("DRAW a Circle at x and y positions with radius");
        }
    }

    class CompoundGraphic implements Graphic {

        Collection<Graphic> children;

        CompoundGraphic() {
            this.children = Collections.EMPTY_LIST;
        }

        void add(Graphic child) {
            this.children.add(child);
        }

        void remove(Graphic child) {
            this.children.remove(child);
        }

        @Override
        public void move(double x, double y) {
            for (Graphic child : this.children) {
                child.move(x, y);
            }
        }

        @Override
        public void draw() {
            for (Graphic child : this.children) {
                child.draw();
            }
        }

    }

    class ImageEditor {

        CompoundGraphic all;

        void load() {
            this.all = new CompoundGraphic();
            this.all.add(new Dot(1, 2));
            this.all.add(new Circle(5, 3, 10));

            // Add More
        }

        void groupSelected(Collection<Graphic> components) {
            CompoundGraphic group = new CompoundGraphic();
            for (Graphic component : components) {
                group.add(component);
                this.all.remove(component);
            }
            this.all.add(group);
            this.all.draw();
        }
    }

    //
    //  Logistic Example
    //
    interface Order {

        double totalPrice();

        int totalItems();
    }

    class Product implements Order {

        String identifier;
        double price;

        public Product(String identifier, double price) {
            this.identifier = identifier;
            this.price = price;
        }

        @Override
        public double totalPrice() {
            return this.price;
        }

        @Override
        public int totalItems() {
            return 1;
        }
    }

    class Box implements Order {
        
        String description;
        Collection<Order> children;

        public Box() {
            this.children = new ArrayList<>();
        }

        public Box(String description) {
            this.description = description;
            this.children = new ArrayList<>();;
        }

        void add(Order order) {
            this.children.add(order);
        }
        
        void add(Order...order){
            for(Order o : order){
                this.add(o);
            }
        }

        void remove(Order order) {
            this.children.remove(order);
        }

        @Override
        public double totalPrice() {
            double total = 0.00D;
            for (Order order : this.children) {
                total += order.totalPrice();
            }
            return total;
        }

        @Override
        public int totalItems() {
            int total = 0;
            for (Order order : this.children) {
                total += order.totalItems();
            }
            return total;
        }

    }
    
    class Fedex {
        
        void fullfilment(){
            Box pcdiga = new Box("Smartphones PCDIGA");
            Box i = new Box("Iphone 12");
            i.add(new Product("Phone",450.00D));
            Box s = new Box("Samsung Galaxy S20");
            s.add(new Product("Phone",750.00D),new Product("Charger",65.00D));
            Box o = new Box("OnePlus 12");
            o.add(new Product("Phone",750.00D),new Product("Charger",65.00D), new Product("HeadPhones",100.00D));
            
            pcdiga.add(i,s,o);
            System.out.println(pcdiga.totalPrice());
            System.out.println(pcdiga.totalItems());
        }
    }
    
    public void runLogistic(){
        Fedex fedex = new Fedex();
        fedex.fullfilment();
    }
    
    public void runGraphic(){
        //
    }

}
