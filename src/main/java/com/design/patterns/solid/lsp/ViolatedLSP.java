/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.lsp;

import java.math.BigDecimal;

/**
 *  Violated Liskov Substitution Principle
 * 
 * @author pedro.vieira
 */
public class ViolatedLSP {

    interface Remuneravel {

        public BigDecimal remuneracao();
    }

    class ContratoClt implements Remuneravel {

        @Override
        public BigDecimal remuneracao() {
            // Do something
            return null;
        }

    }

    // Sobrescrevendo um método que não faz nada...
    class Voluntario extends ContratoClt {

        @Override
        public BigDecimal remuneracao() {
            // não faz nada
            return null;
        }
    }

// Lançando uma exceção inesperada...
    class MusicPlay {

        public void play(Object file) {
            // toca a música   
        }
    }

    class Mp3MusicPlay extends MusicPlay {

        @Override
        public void play(Object file) {
            if (!((String) file).endsWith("mp3")) {
                throw new RuntimeException();
            }

            // toca a música
        }
    }

    // Retornando valores de tipos diferentes...
    class Auth {

        public boolean checkCredentials(String login, String password) {
            // faz alguma coisa

            return true;
        }
    }

    class AuthApi extends Auth {

        public boolean checkCredentials(String login, String password) {
            // faz alguma coisa

            return false;
        }
    }

}
