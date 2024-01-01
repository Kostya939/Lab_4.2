package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DecoderTest {

    @Test
    public void testDecodeVowels() {
        assertEquals("testing", Decoder.decode("t2st3ng"));
    }

    @Test
    public void testDecodeConsonants() {
        assertEquals("testing", Decoder.decode("vetviph"));
    }
}
