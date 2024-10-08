package org.example.ObjectOriented.Interface;

public class JBL implements Media{
    @Override
    public void start() {
        System.out.println("JBL starts...");
    }

    @Override
    public void stop() {
        System.out.println("JBL stops...");
    }

    @Override
    public void nextSong() {
        System.out.println("JBL nextsong...");
    }
}
