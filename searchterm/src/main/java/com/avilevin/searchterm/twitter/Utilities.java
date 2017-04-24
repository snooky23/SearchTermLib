package com.avilevin.searchterm.twitter;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by avilevin on 21/04/2017.
 */

public class Utilities {

    static final char HASHTAG = '#';
    private static final String LOGTAG = "SEARCHTERM";

    public static String encodeStringUTF8(String stringToEncode) {
        String encodedString;
        try {
            encodedString = URLEncoder.encode(stringToEncode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            encodedString = "";
            e.printStackTrace();
        }
        return encodedString;
    }

    public static String decodeStringUTF8(String stringToDecode) {
        String decodedString;
        try {
            decodedString = URLDecoder.decode(stringToDecode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            decodedString = "";
            e.printStackTrace();
        }
        return decodedString;
    }

    public static String stringToHashTag(String string) {
        String stringWithHashTag;

        if(string!=null && !string.isEmpty()) {
            if(string.charAt(0) == HASHTAG) {
                stringWithHashTag = string;
            } else {
                stringWithHashTag = "#" + string;
            }
        } else {
            stringWithHashTag = null;
        }

        return stringWithHashTag;
    }

    public static void writeLog(String msg, LOG_LEVEL logLevel) {
        switch (logLevel) {
            case REGULAR:
                Log.d(LOGTAG,msg);
                break;

            case ERROR:
                Log.e(LOGTAG,msg);
                break;
        }
    }


    public enum LOG_LEVEL {
        REGULAR("Regular", 0),
        ERROR("Error", 1);

        private String stringValue;
        private int intValue;

        LOG_LEVEL(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

}
