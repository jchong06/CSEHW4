import java.util.HashMap;
/**
 * @author Justin Chong
 * Email: justin.chong@stonybrook.edu
 * Student ID: 116143020
 * Recitation Number: CSE 214 R03
 * TA: Kevin Zheng
 */
/**
 * The KeyTable class represents a 5x5 table used in the Playfair cipher.
 * It provides methods to build the table from a keyphrase and locate characters.
 */
public class KeyTable {
    private char[][] key;

    /**
     * Constructs an empty KeyTable with a 5x5 grid.
     */
    public KeyTable() {
        key = new char[5][5];
    }

    /**
     * Builds a KeyTable from the given keyphrase, filling in remaining
     * letters of the alphabet excluding 'J'.
     *
     * @param keyPhrase the string used to build the key table
     * @return a new KeyTable object initialized with the provided keyphrase
     */
    public static KeyTable buildFromString(String keyPhrase) {
        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        keyPhrase = keyPhrase.toUpperCase();
        String phrase = "";
        int idx = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            letterCountMap.put(c, 0);
        }

        for (int i = 0; i < keyPhrase.length(); i++) {
            if (keyPhrase.charAt(i) != ' ') {
                if (!((keyPhrase.charAt(i) + "").toLowerCase().equals((keyPhrase.charAt(i) + "").toUpperCase()))) {
                    if (letterCountMap.get(keyPhrase.charAt(i)) == 0) {
                        letterCountMap.put(keyPhrase.charAt(i), 1);
                        phrase += keyPhrase.charAt(i);
                    }
                }
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (letterCountMap.get(c) == 0 && c != 'J') {
                phrase += c;
            }
        }

        KeyTable keyTable = new KeyTable();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keyTable.getKeyTable()[i][j] = phrase.charAt(idx);
                idx++;
            }
        }
        return keyTable;
    }

    /**
     * Returns the 5x5 key table.
     *
     * @return a 2D array representing the key table
     */
    public char[][] getKeyTable() {
        return key;
    }

    /**
     * Finds the row index of a given character in the key table.
     *
     * @param c the character to find in the key table
     * @return the row index of the character
     * @throws IllegalArgumentException if the character is not found
     */
    public int findRow(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == Character.toUpperCase(c)) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Character not found in the key array.");
    }

    /**
     * Finds the column index of a given character in the key table.
     *
     * @param c the character to find in the key table
     * @return the column index of the character
     * @throws IllegalArgumentException if the character is not found
     */
    public int findCol(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == Character.toUpperCase(c)) {
                    return j;
                }
            }
        }
        throw new IllegalArgumentException("Character not found in the key array.");
    }
}
