package io.impl;

import io.Printable;

public class ConsolePrinter implements Printable {
    @Override
    public void print(String data) {
        System.out.println(data);
    }
}
