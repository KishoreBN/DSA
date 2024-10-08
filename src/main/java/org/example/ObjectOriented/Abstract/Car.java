package org.example.ObjectOriented.Abstract;

abstract public class Car {
    static int population = 0;

    Car(){
        this.population++;
    }
    abstract void start();

    abstract void stop();

}
