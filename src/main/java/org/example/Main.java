package org.example;

public class Main {
    public static void main(String[] args) {
        String encoded1 = "t2st3ng";
        String encoded2 = "vetviph";

        System.out.println("Decoded from 't2st3ng': " + Decoder.decode(encoded1));
        System.out.println("Decoded from 'vetviph': " + Decoder.decode(encoded2));
    }
}
