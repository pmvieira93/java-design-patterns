/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.ocp;

import java.math.BigDecimal;

/**
 *  Violated Open-Close Principle
 * 
 * @author pedro.vieira
 */
public class ViolatedOCP {

    class Estagio {

        public BigDecimal bolsaAuxilio() {
            //...
            return null;
        }
    }

    class ContratoClt {

        public BigDecimal salario() {
            //...
            return null;
        }
    }

    class FolhaPagamento {

        protected BigDecimal saldo;

        public void calcular(Object funcionario) {
            if (funcionario instanceof ContratoClt) {
                this.saldo = ((ContratoClt) funcionario).salario();
            } else if (funcionario instanceof Estagio) {
                this.saldo = ((Estagio) funcionario).bolsaAuxilio();
            }
        }

    }

}
