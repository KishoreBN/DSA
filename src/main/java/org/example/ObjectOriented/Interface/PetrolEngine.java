package org.example.ObjectOriented.Interface;

public class PetrolEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Petrol engine start...");
    }

    @Override
    public void stop() {
        System.out.println("Petrol engine stop...");
    }

    @Override
    public void accelerate() {
        System.out.println("Petrol engine accelerate...");
    }
}
