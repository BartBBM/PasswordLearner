package com.example.filemngmt;

public record Row(int number, String hint, String hash) {
    public String toString() {
        return String.valueOf(number) + ":" + hint + ":" + hash;
    }
    public String prettyPrint() {
        return String.valueOf(number) + " : " + hint + " : " + hash;
    }
}
