package org.example.ObjectOriented.Abstract;

public class Honda extends Car{
    static int population = 0;
    Honda(){
        super();
        this.population++;
    }
    @Override
    void start() {
        System.out.println("Honda Start...");
    }

    @Override
    void stop() {
        System.out.println("Honda Stop...");
    }
}
