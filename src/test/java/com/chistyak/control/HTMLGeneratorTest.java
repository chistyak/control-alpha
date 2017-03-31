package com.chistyak.control;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Krav-Ig on 27.03.2017.
 */
public class HTMLGeneratorTest {
    @Test
    public void testInsertion() throws Exception {
        assertEquals(HTMLGenerator.insertion(
                    "init1<div id=\"page_wall_posts\">init2",
                    "inserted"),
                "init1<div id=\"page_wall_posts\">insertedinit2");
    }

    @Test
    public void insertionToHTML() throws Exception {

    }

}