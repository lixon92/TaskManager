package ru.atkachev.tm;

import ru.atkachev.tm.bootstrap.Bootstrap;

public class Application {
    public static void main(String[] args) {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }
}
