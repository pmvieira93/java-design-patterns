/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.ocp;

import java.math.BigDecimal;

/**
 * Open-Close Principle
 * 
 * @author pedro.vieira
 */
public class OpenClosePrinciple {

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

    class Estagio implements Remuneravel {

        @Override
        public BigDecimal remuneracao() {
            // Do something
            return null;
        }

    }

    class FolhaPagamento {

        protected BigDecimal saldo;

        public void calcular(Remuneravel funcionario) {
            this.saldo = funcionario.remuneracao();
        }

    }
}
