package com.designPatterns.AbstractFactoryPattern;

// Represents an abstract product (both AWS and Google implement Instance)
public interface Instance {
    enum Capacity{micro, small, large}

    void start();

    void attachStorage(Storage storage);

    void stop();
}
