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
public class FactoryMethod {

    //
    // LOGISTIC APP - EXAMPLE
    //
    enum ServiceType {
        SEA,
        AIR,
        LAND
    }

    class PaivaLogistic {

        Logistic logistic;

        void initilizer(ServiceType serviceType) {
            switch (serviceType.name()) {
                case "SEA":
                    this.logistic = new ShipLogistic();
                    break;
                case "LAND":
                    this.logistic = new RoadLogistic();
                    break;
                case "AIR":
                    throw new UnsupportedOperationException();
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void main() {
            this.initilizer(ServiceType.SEA);
            this.logistic.planDelivery();
        }
    }

    interface Transport {

        void deliver();
    }

    abstract class Logistic {

        Transport transport;

        void planDelivery() {
            this.transport = createTransport();
            this.transport.deliver();
        }

        abstract Transport createTransport();
    }

    class RoadLogistic extends Logistic {

        @Override
        Transport createTransport() {
            return new Truck();
        }

    }

    class ShipLogistic extends Logistic {

        @Override
        Transport createTransport() {
            return new Ship();
        }

    }

    class Truck implements Transport {

        @Override
        public void deliver() {
            // Do something
            System.out.println("Delivery by Truck!");
        }

    }

    class Ship implements Transport {

        @Override
        public void deliver() {
            // Do something
            System.out.println("Delivery By Ship!");
        }

    }

    //
    // NATIVE APP - EXAMPLE
    //
    class NativeApp {

        Dialog dialog;

        void initializer() {
            String osName = System.getProperty("os.name");
            if (osName != null && osName.contains("Windows")) {
                this.dialog = new WindowsDialog();
            } else if (osName != null && osName.contains("Web")) {
                this.dialog = new WebDialog();
            } else {
                throw new RuntimeException("ERROR - Unknown operating system!");
            }
        }

        void main() {
            this.initializer();
            this.dialog.render();
        }
    }

    interface Button {

        void render();

        void onClick(Dialog d);
    }

    class WindowsButton implements Button {

        @Override
        public void render() {
            // Do something
        }

        @Override
        public void onClick(Dialog d) {
            // Do something
        }

    }

    class HTMLButton implements Button {

        @Override
        public void render() {
            // Do something
        }

        @Override
        public void onClick(Dialog d) {
            // Do something
        }

    }

    abstract class Dialog {

        Button button;

        void render() {
            this.button = createButton();
            this.button.onClick(this);
            this.button.render();
        }

        abstract Button createButton();
    }

    class WindowsDialog extends Dialog {

        @Override
        Button createButton() {
            return new WindowsButton();
        }

    }

    class WebDialog extends Dialog {

        @Override
        Button createButton() {
            return new HTMLButton();
        }

    }

}
