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
public class AbstractFactory {

    //
    //  FURNITURE APP - EXAMPLE
    //
    class PaivaFurniture {

        FurnitureFactory factory;

        void initializer(String type) {
            switch (type) {
                case "Modern":
                    this.factory = new ModernFactory();
                    break;
                case "Victorian":
                    this.factory = new VictorianFactory();
                    break;
                default:
                    throw new RuntimeException("ERROR - Unknown the type '" + type + "' !");
            }
        }

        void main() {
            this.initializer("Modern");
            Chair moderm = this.factory.createChair();
            System.out.println(moderm.hasLegs());
        }
    }

    interface Chair {

        boolean hasLegs();

        void sitOn();
    }

    interface Sofa {

        boolean hasLegs();

        void sitOn();
    }

    interface CoffeeTable {

    }

    class VictorianChair implements Chair {

        @Override
        public boolean hasLegs() {
            return true;
        }

        @Override
        public void sitOn() {
            // Do something
        }

    }

    class ModernChair implements Chair {

        @Override
        public boolean hasLegs() {
            return false;
        }

        @Override
        public void sitOn() {
            // Do something
        }
    }

    interface FurnitureFactory {

        Chair createChair();

        Sofa createSofa();

        CoffeeTable createCoffeeTable();
    }

    class VictorianFactory implements FurnitureFactory {

        @Override
        public Chair createChair() {
            return new VictorianChair();
        }

        @Override
        public Sofa createSofa() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CoffeeTable createCoffeeTable() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    class ModernFactory implements FurnitureFactory {

        @Override
        public Chair createChair() {
            return new ModernChair();
        }

        @Override
        public Sofa createSofa() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public CoffeeTable createCoffeeTable() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    //
    // NATIVE APP - EXAMPLE
    //
    class NativeApp {

        GUIFactory factory;
        Button button;
        CheckBox checkBox;

        NativeApp(GUIFactory factory) {
            this.factory = factory;
        }

        void createUI() {
            this.button = this.factory.createButton();
            this.checkBox = this.factory.createCheckBox();
        }

        void paint() {
            this.button.render();
            this.checkBox.render();
        }

    }

    class AppConfig {

        void main() {
            GUIFactory factory;
            String osName = System.getProperty("os.name");
            if (osName != null && osName.contains("Windows")) {
                factory =  new WinFactory();
            } else if (osName != null && osName.contains("Mac")) {
                factory = new MacFactory();
            } else {
                throw new RuntimeException("ERROR - Unknown operating system!");
            }
            
            NativeApp app = new NativeApp(factory);
            app.createUI();
            app.paint();
        }
    }

    interface Button {

        void render();

    }

    interface CheckBox {

        void render();
    }

    interface GUIFactory {

        Button createButton();

        CheckBox createCheckBox();

    }

    class WinButton implements Button {

        @Override
        public void render() {
            System.out.println("Windows Button");
        }

    }

    class WinCheckBox implements CheckBox {

        @Override
        public void render() {
            System.out.println("Windows CheckBox");
        }
    }

    class MacButton implements Button {

        @Override
        public void render() {
            System.out.println("Mac OS Button");
        }

    }

    class MacCheckBox implements CheckBox {

        @Override
        public void render() {
            System.out.println("Mac OS CheckBox");
        }
    }

    class WinFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new WinButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new WinCheckBox();
        }

    }

    class MacFactory implements GUIFactory {

        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public CheckBox createCheckBox() {
            return new MacCheckBox();
        }

    }

}
