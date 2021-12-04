/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.creational;

/**
 *
 * @author pedro.vieira
 */
public class Builder {

    class Car {

        int seats;
        double engine;
        boolean tripComputer;
        boolean gps;
    }

    class Manual {

        int seats;
        double engine;
        boolean tripComputer;
        boolean gps;
    }

    interface AutoBuilder {

        AutoBuilder reset();

        AutoBuilder setSeats(int seats);

        AutoBuilder setEngine(double engine);

        AutoBuilder setTripComputer(boolean tripComputer);

        AutoBuilder setGps(boolean gps);
    }

    class CarBuilder implements AutoBuilder {

        Car car;

        CarBuilder() {
            this.reset();
        }

        @Override
        public AutoBuilder reset() {
            this.car = new Car();
            return this;
        }

        @Override
        public AutoBuilder setSeats(int seats) {
            this.car.seats = seats;
            return this;
        }

        @Override
        public AutoBuilder setEngine(double engine) {
            this.car.engine = engine;
            return this;
        }

        @Override
        public AutoBuilder setTripComputer(boolean tripComputer) {
            this.car.tripComputer = tripComputer;
            return this;
        }

        @Override
        public AutoBuilder setGps(boolean gps) {
            this.car.gps = gps;
            return this;
        }

        Car build() {
            return this.car;
        }

    }
    
    class CarManualBuilder implements AutoBuilder{
        
        Manual manual;
        
        CarManualBuilder(){
            this.reset();
        }

        @Override
        public AutoBuilder reset() {
            return this;
        }

        @Override
        public AutoBuilder setSeats(int seats) {
            this.manual.seats=seats;
            return this;
        }

        @Override
        public AutoBuilder setEngine(double engine) {
            this.manual.engine=engine;
            return this;
        }

        @Override
        public AutoBuilder setTripComputer(boolean tripComputer) {
            this.manual.tripComputer=tripComputer;
            return this;
        }

        @Override
        public AutoBuilder setGps(boolean gps) {
            this.manual.gps=gps;
            return this;
        }
        
        Manual build(){
            return this.manual;
        }
    }
}
