/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.creational;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author pedro.vieira
 */
@Test(timeOut = 1000L)
public class SingletonNGTest {

    public void testInstanceIsEqual() {
        System.out.println("instance_isEqual");
        Singleton expResult = Singleton.instance();
        Singleton result = Singleton.instance();

        assertThat(result).isEqualTo(expResult);
    }

    public void testInstanceFieldIsEqual() {
        System.out.println("instance_fieldIsEqual");
        Singleton expResult = Singleton.instance();
        Singleton result = Singleton.instance();

        assertThat(result.getInstanceTime()).isEqualTo(expResult.getInstanceTime());
    }
    
}
