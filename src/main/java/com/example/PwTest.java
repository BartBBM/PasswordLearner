package com.example;

import com.example.filemngmt.Filemngmt;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class PwTest {
    Filemngmt filemngmt;

    public PwTest(Filemngmt filemngmt) {
        this.filemngmt = filemngmt;
    }

    public static void main(String[] args) throws IOException {
        Filemngmt filemngmt = new Filemngmt();
        PwTest pwTest = new PwTest(filemngmt);


        while (true) {
            System.out.println("Write a number to learn a Password or 'add' to add a new Password!");
            filemngmt.terminalOutput();
            String input = getInput();
            if (input.equals("add")) {
                pwTest.addPw();
            } else if (input.equals("exit")) {
                System.exit(0);
            } else {
                try {
                    pwTest.learnPw(Integer.parseInt(input));
                } catch (Exception e) {
                    continue;
                }
            }
            System.out.println("");
        }
    }

    public void addPw() throws IOException {
        int number;
        String hint;
        String hash;
        System.out.println("Enter Number!");
        number = Integer.parseInt(getInput());
        System.out.println("Enter Hint!");
        hint = getInput();
        System.out.println("Enter Password!");
        hash = getPasswordInput();
        hash = hashInput(hash);
        filemngmt.addPw(number, hint, hash);

        filemngmt.writeFiles();
    }

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getPasswordInput() {
        Console console = System.console();
        char[] password = console.readPassword();
        String pw = String.valueOf(password);
        // System.out.println(pw);
        // Scanner sc = new Scanner(System.in);
        return pw;
    }

    public void learnPw(int number) {
        System.out.println("Password:");
        String input = getPasswordInput();
        String hashedInput = hashInput(input);
        System.out.println(hashedInput);
        System.out.println(hashedInput.equals(filemngmt.getHash(number)));
    }

    public static String hashInput(String input) {
        input = input + "asdfjklö";
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(input.getBytes());
        return Hex.toHexString(digest);
    }
}
