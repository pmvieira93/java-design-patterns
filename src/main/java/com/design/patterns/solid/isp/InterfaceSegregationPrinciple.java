/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.isp;

import java.math.BigDecimal;

/**
 * Interface Segregation Principle
 *
 * @author pedro.vieira
 */
public class InterfaceSegregationPrinciple {

    interface Aves {

        public void setLocalizacao(String longitude, String latitude);

        public void renderizar();
    }

    interface AvesQueVoam extends Aves {

        public void setAltitude(BigDecimal altitude);
    }

    class Papagaio implements AvesQueVoam {

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

        public void renderizar() {
            //Faz alguma coisa
        }
    }

}
