package com.chistyak.control;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Krav-Ig on 11.03.2017.
 */
public class JSONParserTest {
    @Test
    public void testParseText() throws Exception {
        String string = JSONParser.parseText("{\"response\":[279,{\"id\":7555,\"from_id\":143024772,\"to_id\":143024772,\"date\":1488179667,\"post_type\":\"copy\",\"text\":\"testText\",\"copy_post_date\":1488096187,\"copy_post_type\":\"post\",\"copy_owner_id\":-66178227,\"copy_post_id\":15055,\"can_delete\":1,\"can_pin\":1,\"post_source\":{\"type\":\"vk\"},\"comments\":{\"count\":3,\"can_post\":1},\"likes\":{\"count\":0,\"user_likes\":0,\"can_like\":1,\"can_publish\":0},\"reposts\":{\"count\":0,\"user_reposted\":0},\"online\":1,\"reply_count\":3}]}");
        assertEquals(string,"testText");
    }
}