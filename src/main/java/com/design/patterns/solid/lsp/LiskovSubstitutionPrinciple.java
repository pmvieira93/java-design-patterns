/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.solid.lsp;

/**
 * Liskov Substitution Principle
 * 
 * @author pedro.vieira
 */
public class LiskovSubstitutionPrinciple {

    public static void imprimirNome(Parent objecto) {
        System.out.println(objecto.getNome());
    }

    public class Parent {

        String getNome() {
            return "Eu sou o Pai!";
        }

    }

    public class ChildA extends Parent {

        String getNome() {
            return "Eu sou o Filho A!";
        }
    }

}
