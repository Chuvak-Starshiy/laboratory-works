package egor.omgtu.lw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String text;

    private static boolean isConsonant(String word) {
        char c = word.charAt(0);
        if (c < 0x0410 || c > 0x044F)
            return false;
        if (c > 0x042F)
            c = (char) (c - 0x0020);
        return c != 'Е' && c != 'У' && c != 'Ы' && c != 'А' && c != 'О' && c != 'Э' && c != 'Я' && c != 'И' && c != 'Ю';
    }

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            text = reader.readLine();
        } catch (IOException ex) {
            ex.getStackTrace();
        }

        StringBuilder builder = new StringBuilder(64);

        for (String word : text.split(" ")) {
            // if (word.length() < 10)
            if (!isConsonant(word))
                builder.append(word).append(" ");
        }
        System.out.println(builder);

    }
}
