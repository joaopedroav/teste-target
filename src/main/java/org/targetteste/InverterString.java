package org.targetteste;

public class InverterString {

    public static void main(String[] args) {
        String palavra = invert("Palavra");
        System.out.println(palavra);
    }

    public static String invert(String word) {
        StringBuilder inverseWord = new StringBuilder();
        for(int i = word.length() - 1; i >= 0; i--){
            inverseWord.append(Character.toString(word.charAt(i)));
        }
        return inverseWord.toString();
    }
}
