/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.dip;

/**
 * Dependency Inversion Principle
 *
 * @author pedro.vieira
 */
public class DependencyInversionPrinciple {

    interface DBConnectionInterface {

        public void connect();
    }

    class MySQLConnection implements DBConnectionInterface {

        @Override
        public void connect() {
            // Do something
        }

    }
    
    class OracleSQLConnection implements DBConnectionInterface {

        @Override
        public void connect() {
            // Do something
        }
        
    }

    class PasswordReminder {

        private DBConnectionInterface dbConnection;

        public PasswordReminder(DBConnectionInterface dbConnection) {
            this.dbConnection = dbConnection;
        }

        // Faz alguma coisa
    }

}
