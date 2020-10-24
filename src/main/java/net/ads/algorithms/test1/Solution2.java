package net.ads.algorithms.test1;

import java.util.Scanner;

/*
 * Create the Encrypter class here.
 */
class Encrypter {

    public static String getEncryptedName(String name) {
        Validator validator = new Validator();
        if (!validator.validate(name)) {
            throw new IllegalArgumentException("Try again with valid name");
        }
        
        name = name.toLowerCase();
        
        char[] result = new char[name.length()];

        for (int i = name.length() - 1, j = 0; i >= 0; i--, j++) {

            result[j] = name.charAt(i);

        }

        return new String(result);
    }

}

class Validator {
    public boolean validate(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            if (ch != ' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))) {
                return false;
            }
        }

        return true;
    }
}

public class Solution2 {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        String name = "Kate Winslet";
        System.out.println(Encrypter.getEncryptedName(name));
    }
}