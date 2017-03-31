package com.chistyak.control;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Krav-Ig on 11.03.2017.
 */
public class OwnerTest {
    private static Owner owner;

    @Before
    public void setUp(){
        owner = new Owner("1");
    }

    @Test
    public void testInitialize() throws Exception {
        assertTrue(owner.initialize());
    }

    @Test
    public void testGetLastPost() throws Exception {
        assertFalse(owner.getLastPost().isEmpty());
    }

    @Test
    public void testSavePost() throws Exception {
        assertTrue(owner.savePost("{\"response\":[231,{\"id\":1626060,\"from_id\":1,\"to_id\":1,\"date\":1490221174,\"post_type\":\"post\",\"text\":\"\",\"attachment\":{\"type\":\"link\",\"link\":{\"url\":\"https:\\/\\/youtube.com\\/durov\",\"title\":\"Pavel Durov\",\"description\":\"\",\"target\":\"external\",\"image_src\":\"https:\\/\\/pp.userapi.com\\/c837529\\/v837529001\\/26b4d\\/u1oQibJzPyw.jpg\"}},\"attachments\":[{\"type\":\"link\",\"link\":{\"url\":\"https:\\/\\/youtube.com\\/durov\",\"title\":\"Pavel Durov\",\"description\":\"\",\"target\":\"external\",\"image_src\":\"https:\\/\\/pp.userapi.com\\/c837529\\/v837529001\\/26b4d\\/u1oQibJzPyw.jpg\"}}],\"comments\":{\"count\":11475},\"likes\":{\"count\":10599},\"reposts\":{\"count\":166}}]}"));
    }

    @Test
    public void testIsPresent() throws Exception {
        assertTrue(owner.isPresent());
    }

}