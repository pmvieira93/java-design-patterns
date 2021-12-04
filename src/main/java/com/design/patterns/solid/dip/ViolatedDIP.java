/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.dip;

/**
 * Violated Dependency Inversion Principle
 *
 * @author pedro.vieira
 */
public class ViolatedDIP {

    class MySQLConnection {

    }

    class PasswordReminder {

        private MySQLConnection dbConnection;
        
        //  Alto Acoplamento 
        public PasswordReminder() {
            this.dbConnection = new MySQLConnection();
        }
        
        // Solução para reduzir o Acoplamento
        public PasswordReminder(MySQLConnection dbConnection){
            this.dbConnection = dbConnection;
        }

        // Faz alguma coisa
    }

}
