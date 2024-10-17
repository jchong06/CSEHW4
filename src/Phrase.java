import java.awt.*;
import java.util.LinkedList;
import java.util.ArrayList;

public class Phrase extends LinkedList<Bigram> {

    public Phrase() {
    }

    public static Phrase buildPhraseFromStringforEnc(String s) {
        Phrase phrase = new Phrase();
        ArrayList<String> pairs = new ArrayList<>();
        String bigram = "";
        s = s.toUpperCase();
        s = s.toUpperCase().replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            if (!((s.charAt(i) + "").toLowerCase().equals((s.charAt(i) + "").toUpperCase()))){
                if (String.valueOf(s.charAt(i)).equals(bigram)) {
                    bigram += "X";
                    pairs.add(bigram);
                    bigram = String.valueOf(s.charAt(i));
                    i++;
                }
                bigram += String.valueOf(s.charAt(i));
                if (bigram.length() == 2) {
                    pairs.add(bigram);
                    bigram = "";
                }
            }
        }
        if (!(bigram.equals(""))){
            bigram += "X";
            pairs.add(bigram);
        }

        for (String c : pairs){
            Bigram bi = new Bigram();
            bi.setFirst(c.charAt(0));
            bi.setSecond(c.charAt(1));
            phrase.offer(bi);
        }

        return phrase;
    }

    public Phrase encrypt(KeyTable key){
        Phrase encrypted = new Phrase();
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;
        for (Bigram bi : this){
            x1 = key.findCol(bi.getFirst());
            x2 = key.findCol(bi.getSecond());
            y1 = key.findRow(bi.getFirst());
            y2 = key.findRow(bi.getSecond());
            if (y1 == y2){
                ArrayList<Integer> coord = sameRow(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                encrypted.offer(bi);
            }
            else if (x1 == x2){
                ArrayList<Integer> coord = sameCol(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                encrypted.offer(bi);
            }
            else {
                ArrayList<Integer> coord = rectangle(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                encrypted.offer(bi);
            }
        }
        return encrypted;
    }

    public Phrase decrypt(KeyTable key){
        Phrase decrypted = new Phrase();
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;
        for (Bigram bi : this){
            System.out.println(bi);
            x1 = key.findCol(bi.getFirst());
            x2 = key.findCol(bi.getSecond());
            y1 = key.findRow(bi.getFirst());
            y2 = key.findRow(bi.getSecond());
            if (y1 == y2){
                ArrayList<Integer> coord = sameRowDecrypt(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                decrypted.offer(bi);
            }
            else if (x1 == x2){
                ArrayList<Integer> coord = sameColDecrypt(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                decrypted.offer(bi);
            }
            else {
                ArrayList<Integer> coord = rectangle(x1, x2, y1, y2);
                bi.setFirst(key.getKeyTable()[coord.get(1)][coord.get(0)]);
                bi.setSecond(key.getKeyTable()[coord.get(3)][coord.get(2)]);
                decrypted.offer(bi);
            }
        }
        return decrypted;
    }

    public ArrayList<Integer> sameRow(int x1, int x2, int y1, int y2){
        if (x1 == 4){
            x1 = 0;
        }
        else{
            x1++;
        }
        if (x2 == 4){
            x2 = 0;
        }
        else{
            x2++;
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(x1);
        coordinates.add(y1);
        coordinates.add(x2);
        coordinates.add(y2);
        return coordinates;
    }

    public ArrayList<Integer> sameCol(int x1, int x2, int y1, int y2){
        if (y1 == 4){
            y1 = 0;
        }
        else{
            y1++;
        }
        if (y2 == 4){
            y2 = 0;
        }
        else{
            y2++;
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(x1);
        coordinates.add(y1);
        coordinates.add(x2);
        coordinates.add(y2);
        return coordinates;
    }

    public ArrayList<Integer> rectangle(int x1, int x2, int y1, int y2){
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(x2);
        coordinates.add(y1);
        coordinates.add(x1);
        coordinates.add(y2);
        return coordinates;
    }

    public ArrayList<Integer> sameRowDecrypt(int x1, int x2, int y1, int y2){
        if (x1 == 0){
            x1 = 4;
        }
        else{
            x1--;
        }
        if (x2 == 0){
            x2 = 4;
        }
        else{
            x2--;
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(x1);
        coordinates.add(y1);
        coordinates.add(x2);
        coordinates.add(y2);
        return coordinates;
    }

    public ArrayList<Integer> sameColDecrypt(int x1, int x2, int y1, int y2){
        if (y1 == 0){
            y1 = 4;
        }
        else{
            y1--;
        }
        if (y2 == 0){
            y2 = 4;
        }
        else{
            y2--;
        }
        ArrayList<Integer> coordinates = new ArrayList<>();
        coordinates.add(x1);
        coordinates.add(y1);
        coordinates.add(x2);
        coordinates.add(y2);
        return coordinates;
    }
}