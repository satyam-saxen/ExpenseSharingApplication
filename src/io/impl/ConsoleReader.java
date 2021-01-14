package io.impl;

import io.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
