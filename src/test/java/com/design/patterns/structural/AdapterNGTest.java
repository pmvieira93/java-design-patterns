/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.design.patterns.structural;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author pedro.vieira
 */
@Test(timeOut = 1000L)
public class AdapterNGTest {

    public void testAdapterFitsTrue() {
        System.out.println("adapterFits_true");

//        Adapter.RoundHole input1 = new Adapter.RoundHole(5D);
//        Adapter.SquarePeg input2 = new Adapter.SquarePeg(5D);
//        Adapter.SquarePegAdapter input3 = new Adapter.SquarePegAdapter(input2);
//        boolean result = input1.fits(input3);
//        boolean expResult = true;
//
//        assertThat(result).isEqualTo(expResult);
    }

    public void testAdapterFitsFalse() {
        System.out.println("adapterFits_false");

//        Adapter.RoundHole input1 = new Adapter.RoundHole(5D);
//        Adapter.SquarePeg input2 = new Adapter.SquarePeg(10D);
//        Adapter.SquarePegAdapter input3 = new Adapter.SquarePegAdapter(input2);
//        boolean result = input1.fits(input3);
//        boolean expResult = false;
//
//        assertThat(result).isEqualTo(expResult);
    }
}
