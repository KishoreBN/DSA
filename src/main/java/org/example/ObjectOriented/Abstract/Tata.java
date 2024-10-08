package org.example.ObjectOriented.Abstract;

public class Tata extends Car{
    static int population = 0;
    Tata(){
        super();
        this.population++;
    }
    @Override
    void start() {
        System.out.println("Tata Start...");
    }

    @Override
    void stop() {
        System.out.println("Honda Stop...");
    }
}
