/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.srp;

/**
 *  SOLID - SRP (Single Responsibility Principle)
 *  Violated this principle of SOLID. This class have three groups of responsibilities.
 *  It should had one Responsibility;
 * 
 * @author pedro.vieira
 */
public class ViolatedSRP {

    class OrderViolated {

        //  DOMAIN (ORDER)
        public void calculateTotalSum() {/*...*/
        }

        public void getItems() {/*...*/
        }

        public void getItemCount() {/*...*/
        }

        public void addItem(Object item) {/*...*/
        }

        public void deleteItem(Object item) {/*...*/
        }

        //  VIEWER
        public void printOrder() {/*...*/
        }

        public void showOrder() {/*...*/
        }

        //  REPOSITORY
        public void load() {/*...*/
        }

        public void save() {/*...*/
        }

        public void update() {/*...*/
        }

        public void delete() {/*...*/
        }

    }

}
