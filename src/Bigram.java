/**
 * @author Justin Chong
 * Email: justin.chong@stonybrook.edu
 * Student ID: 116143020
 * Recitation Number: CSE 214 R03
 * TA: Kevin Zheng
 */
/**
 * The Bigram class represents a pair of characters, often used in encryption schemes like the Playfair cipher.
 */
public class Bigram {
    private char first;
    private char second;

    /**
     * Constructs an empty Bigram object.
     */
    public Bigram() {
    }

    /**
     * Returns the first character of the Bigram.
     *
     * @return the first character
     */
    public char getFirst() {
        return first;
    }

    /**
     * Sets the first character of the Bigram.
     *
     * @param first the character to set as the first character
     */
    public void setFirst(char first) {
        this.first = first;
    }

    /**
     * Returns the second character of the Bigram.
     *
     * @return the second character
     */
    public char getSecond() {
        return second;
    }

    /**
     * Sets the second character of the Bigram.
     *
     * @param second the character to set as the second character
     */
    public void setSecond(char second) {
        this.second = second;
    }

    /**
     * Returns a string representation of the Bigram, combining the first and second characters.
     *
     * @return a string containing the first and second characters
     */
    public String toString() {
        return String.valueOf(first) + String.valueOf(second);
    }
}
