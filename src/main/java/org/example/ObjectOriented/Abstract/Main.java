package org.example.ObjectOriented.Abstract;

public class Main {
    public static void main(String[] args) {
        Honda honda = new Honda();
        Tata tata = new Tata();
        System.out.println(Car.population);
        System.out.println(Honda.population);
        System.out.println(Tata.population);
    }
}
