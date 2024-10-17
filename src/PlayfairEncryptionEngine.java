import java.util.Scanner;

public class PlayfairEncryptionEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter key phrase: ");
        String k = input.nextLine();
        KeyTable key = KeyTable.buildFromString(k);
        System.out.println("Generation success!");
        String menu = "\nMenu:\n" +
                "(CK) - Change key\n" +
                "(PK) - Print key\n" +
                "(EN) - Encrypt\n" +
                "(DE) - Decrypt\n" +
                "(Q) - Quit\n";
        System.out.println(menu);
        System.out.print("Please select an option: ");
        String option = input.nextLine().toUpperCase();
        while (!option.equals("Q")) {
            if (option.equals("PK")){
                System.out.println("");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(key.getKeyTable()[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            if (option.equals("CK")){
                System.out.print("Enter key phrase: ");
                k = input.nextLine();
                key = KeyTable.buildFromString(k);
                System.out.println("Generation success!");
            }
            if (option.equals("EN")){
                System.out.print("Please enter a phrase to encrypt: ");
                String phrase = input.nextLine();
                Phrase p = Phrase.buildPhraseFromStringforEnc(phrase);
                Phrase encrypt = p.encrypt(key);
                String result = "";
                for (Bigram bi : encrypt){
                    result += bi;
                }
                System.out.println("Encrypted text is : " + result);
            }
            if (option.equals("DE")){
                System.out.print("Please enter a phrase to decrypt: ");
                String phrase = input.nextLine();
                Phrase p = Phrase.buildPhraseFromStringforEnc(phrase);
                Phrase decrypt = p.decrypt(key);
                String result = "";
                for (Bigram bi : decrypt){
                    result += bi;
                }
                System.out.println("Encrypted text is : " + result);
            }
            System.out.println(menu);
            System.out.print("Please select an option: ");
            option = input.nextLine().toUpperCase();
        }
    }
}
