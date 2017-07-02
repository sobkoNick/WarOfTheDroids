package com.epam.lab.war.view;

/**
 * Created by Mykola on 29.06.2017.
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
