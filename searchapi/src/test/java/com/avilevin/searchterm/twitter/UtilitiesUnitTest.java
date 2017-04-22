package com.avilevin.searchterm.twitter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UtilitiesUnitTest {

    @Test
    public void encodeDecodeStringUTF8_test() throws Exception {
        String test = "Hello, this is a test";

        String encodedString = Utilities.encodeStringUTF8(test);
        String decodedString = Utilities.decodeStringUTF8(encodedString);

        assertEquals(test,decodedString);
    }

    @Test
    public void stringToHashTag_test() throws Exception {
        String test[] = {"Hello","#NBA","",null};

        for (String aTest : test) {
            String stringWithHashTag = Utilities.stringToHashTag(aTest);
            if (stringWithHashTag!=null && !stringWithHashTag.isEmpty()) {
                Assert.assertEquals(stringWithHashTag.charAt(0), Utilities.HASHTAG);
            } else {
                Assert.assertEquals(stringWithHashTag, null);
            }
        }
    }

}