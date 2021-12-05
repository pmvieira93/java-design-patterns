/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.structural;

/**
 *
 * @author pedro.vieira
 */
public class Adapter {
    
    class Application {
        
        void main(){
            RoundHole hole = new RoundHole(5D);
            RoundPeg rpeg = new RoundPeg(5D);
            System.out.println(hole.fits(rpeg));
            
            SquarePeg small = new SquarePeg(5D);
            SquarePeg large = new SquarePeg(10D);
//            System.out.println(hole.fits(small)); // Not compile

            SquarePegAdapter smallAdapter = new SquarePegAdapter(small);
            SquarePegAdapter largerAdapter = new SquarePegAdapter(large);
            System.out.println(hole.fits(smallAdapter));
            System.out.println(hole.fits(largerAdapter));
            
        }
    }

    class RoundHole {

        double radius;

        public RoundHole(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return this.radius;
        }

        public boolean fits(RoundPeg peg) {
            return this.getRadius() >= peg.getRadius();
        }
    }

    class RoundPeg {

        double radius;

        public RoundPeg() {
        }

        public RoundPeg(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return this.radius;
        }
    }

    class SquarePeg {

        double width;

        SquarePeg(double width) {
            this.width = width;
        }

        public double getWidth() {
            return this.width;
        }
    }

    class SquarePegAdapter extends RoundPeg {

        private SquarePeg peg;

        public SquarePegAdapter(SquarePeg peg) {
            this.peg = peg;
        }

        public SquarePeg getPeg() {
            return this.peg;
        }

        @Override
        public double getRadius() {
            return this.peg.getWidth() * Math.sqrt(2) / 2;
        }
    }

}
