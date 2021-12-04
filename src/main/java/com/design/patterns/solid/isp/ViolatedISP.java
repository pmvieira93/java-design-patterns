/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.isp;

import java.math.BigDecimal;

/**
 *  Violated Interface Segregation Principle
 * 
 * @author pedro.vieira
 */
public class ViolatedISP {

    interface Aves {

        public void setLocalizacao(String longitude, String latitude);

        public void setAltitude(BigDecimal altitude);

        public void renderizar();
    }

    class Papagaio implements Aves {

        public void setLocalizacao(String longitude, String latitude) {
            //Faz alguma coisa
        }

        public void setAltitude(BigDecimal altitude) {
            //Faz alguma coisa   
        }

        public void renderizar() {
            //Faz alguma coisa
        }
    }

    class Pinguim implements Aves {

        public void setLocalizacao(String longitude, String latitude) {
            //Faz alguma coisa
        }

        // A Interface Aves está forçando a Classe Pinguim a implementar esse método.
        // Isso viola o príncipio ISP
        public void setAltitude(BigDecimal altitude) {
            //Não faz nada...  Pinguins são aves que não voam!
        }

        public void renderizar() {
            //Faz alguma coisa
        }
    }

}
