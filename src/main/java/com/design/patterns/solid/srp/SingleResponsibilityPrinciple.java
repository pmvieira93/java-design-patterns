/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.srp;

import java.math.BigDecimal;

/**
 * Single Responsibility Principle
 * 
 * @author pedro.vieira
 */
public class SingleResponsibilityPrinciple {

    class Order {

        //  DOMAIN (ORDER)
        public BigDecimal calculateTotalSum() {/*...*/
            return null;
        }

        public Object[] getItems() {/*...*/
            return null;
        }

        public Integer getItemCount() {/*...*/
            return null;
        }

        public void addItem(Object item) {/*...*/
        }

        public void deleteItem(Object item) {/*...*/
        }

    }

    class OrderRepository {

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

    class OrderViewer {

        //  VIEWER
        public void printOrder(Object order) {/*...*/
        }

        public void showOrder(Object order) {/*...*/
        }

    }
}
