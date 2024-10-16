public class Main {
    public static void main(String[] args) {
        String keyPhrase = "Playfarrrrsjadssacacd";
        KeyTable keyTable = KeyTable.buildFromString(keyPhrase);

        // Print the key table
        char[][] table = keyTable.getKeyTable();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}