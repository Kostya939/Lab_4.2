package org.example;

public class Decoder {

    public static String decode(String message) {
        String[] words = message.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            if (word.matches(".*[12345].*")) {
                decodedMessage.append(decodeVowels(word)).append(" ");
            } else if (word.matches(".*[bcdfghjklmnpqrstvwxyz].*")) {
                decodedMessage.append(decodeConsonants(word)).append(" ");
            } else {
                decodedMessage.append(word).append(" ");
            }
        }

        return decodedMessage.toString().trim();
    }

    private static String decodeVowels(String word) {
        return word.replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "o")
                .replaceAll("5", "u");
    }

    private static String decodeConsonants(String word) {
        StringBuilder decoded = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (isConsonant(ch)) {
                decoded.append(shiftConsonant(ch));
            } else {
                decoded.append(ch);
            }
        }
        return decoded.toString();
    }

    private static boolean isConsonant(char ch) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(Character.toLowerCase(ch)) != -1;
    }

    private static char shiftConsonant(char ch) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        int index = consonants.indexOf(Character.toLowerCase(ch));
        char next;

        if (index != -1) {
            if(ch == 'g') {
                next = 'h';
            } else if (ch == 'h') {
                next = 'j';
            } else {
                next = consonants.charAt((index + 1) % consonants.length());
            }
        } else {
            next = ch;
        }

        return Character.isUpperCase(ch) ? Character.toUpperCase(next) : next;
    }
}
