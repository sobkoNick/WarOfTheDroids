package com.epam.lab.war.view;

/**
 * Console view. imp View.
 */
public class ConsoleView implements View {
    @Override
    public void println(String str) {
        System.out.println(str);
    }

    @Override
    public void print(String str) {
        System.out.print(str);
    }
}
