import java.util.HashMap;

public class KeyTable {
    private char[][] key;

    public KeyTable(){
        key = new char[5][5];
    }

    public static KeyTable buildFromString(String keyPhrase){
        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        keyPhrase = keyPhrase.toUpperCase();
        String phrase = "";
        int idx = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            letterCountMap.put(c, 0);
        }
        for (int i = 0; i < keyPhrase.length(); i++){
            if (letterCountMap.get(keyPhrase.charAt(i)) == 0){
                letterCountMap.put(keyPhrase.charAt(i), 1);
                phrase += keyPhrase.charAt(i);
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if ((letterCountMap.get(c) == 0) && (c != 'J'))  {
                phrase += c;
            }
        }

        KeyTable keyTable = new KeyTable();

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                keyTable.getKeyTable()[i][j] = phrase.charAt(idx); // Fill the key
                idx++;
            }
        }
        return keyTable;
    }

    public char[][] getKeyTable() {
        return key;
    }

    public int findRow(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == c) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("Character not found in the key array.");
    }

    public int findCol(char c) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j] == c) {
                    return j;
                }
            }
        }
        throw new IllegalArgumentException("Character not found in the key array.");
    }
}