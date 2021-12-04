/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.creational;

import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author pedro.vieira
 */
public class Prototype {

    class Application {

        Collection<Shape> shapes;

        Application() {
            this.shapes = Collections.EMPTY_LIST;

            Circle circle = new Circle();
            circle.x = 10;
            circle.y = 10;
            circle.radius = 20;

            this.shapes.add(circle);

            Circle anotherCircle = (Circle) circle.clone();
            shapes.add(anotherCircle);

            Rectangle rectangle = new Rectangle();
            rectangle.width = 10;
            rectangle.height = 20;
            shapes.add(rectangle);

        }

        void businessLogic() {
            Collection<Shape> shapesCopy = Collections.EMPTY_LIST;
        
            for(Shape shape : shapes){
                shapesCopy.add(shape.clone());
            }
        }

    }

    abstract class Shape {

        int x;
        int y;
        String color;

        Shape() {
        }

        Shape(Shape source) {
            this();
            this.x = source.x;
            this.y = source.y;
            this.color = source.color;
        }

        protected abstract Shape clone();

    }

    class Rectangle extends Shape {

        int width;
        int height;

        Rectangle(Rectangle source) {
            super(source);
            this.width = source.width;
            this.height = source.height;
        }

        Rectangle() {
            super();
        }

        @Override
        protected Shape clone() {
            return new Rectangle(this);
        }

    }

    class Circle extends Shape {

        int radius;

        Circle(Circle source) {
            super(source);
            this.radius = source.radius;
        }

        Circle() {
            super();
        }

        @Override
        protected Shape clone() {
            return new Circle(this);
        }

    }
}
