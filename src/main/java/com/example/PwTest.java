package com.example;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PwTest {

    public static void main(String[] args) throws IOException {
        while (true) {
            String hashedPW = getHashedPW();
            String input = getInput();
            String digest = hashInput(input);
            System.out.println(digest);
            System.out.println(digest.equals(hashedPW));
        }
    }

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String hashInput(String input) {
        input = input + "asdfjklö";
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }

    public static String getHashedPW() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("../HashedPW.txt"));
        String hashedPW = br.readLine();
        br.close();
        return hashedPW;
    }
}
