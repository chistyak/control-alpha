package com.chistyak.control;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Krav-Ig on 11.03.2017.
 */
public class OwnerTest {

    @Test
    public void testIsPresent() throws Exception {
        Owner owner = new Owner("143024772");
        assertTrue(owner.isPresent());
    }

}