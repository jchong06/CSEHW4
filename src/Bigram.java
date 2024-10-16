public class Bigram {
    private char first;
    private char second;

    public Bigram(){
    }

    public char getFirst() {
        return first;
    }

    public void setFirst(char first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    public String toString() {
        return String.valueOf(first) + String.valueOf(second);
    }
}
