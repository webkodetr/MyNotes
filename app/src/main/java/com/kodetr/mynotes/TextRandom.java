package com.kodetr.mynotes;

import java.nio.charset.Charset;
import java.util.Random;

public class TextRandom {
    public static String generateTextRandom(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}

