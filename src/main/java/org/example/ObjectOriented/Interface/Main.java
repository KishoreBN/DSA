package org.example.ObjectOriented.Interface;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Honda honda = new Honda(new PetrolEngine(), new JBL());
        honda.engine.start();
        honda.engine.accelerate();
        honda.media.start();
        honda.media.nextSong();
        honda.media.stop();
        honda.engine.stop();
    }
}
