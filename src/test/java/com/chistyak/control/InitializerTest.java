package com.chistyak.control;

import org.junit.Test;

import static org.junit.Assert.*;

public class InitializerTest {

    @Test
    public void testInitialize() throws Exception {
        assertFalse(Initializer.initialize().isEmpty());
    }
}