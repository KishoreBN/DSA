package org.example.ObjectOriented;

class Car{
    String model;

    Car(String model){
        this.model = model;
    }

    public void start(){
        System.out.println("Car starts....");
    }

    public static int getMaxSpeed(){
        return 100;
    }
}

/**
 * Dynamic polymorphism (Method overriding)
 */
class Honda extends Car{
    int seats = 4;
    Honda(String model){
        super(model);
    }

    /**
     * Below is example of static polymorphism because the type of constructor to be called is decided at the compile time itself.
     * @param model
     * @param seats
     */
    Honda(String model, int seats){
        super(model);
        this.seats = seats;
    }

    @Override
    public void start(){
        System.out.println("Seatbelt check...");
        super.start();
    }

    public static int getMaxSpeed(){
        return 150;
    }
}

class Polymorphism {
    public static void main(String[] args) {
        Honda civic = new Honda("Civic");
        civic.start();
        System.out.println(civic.getMaxSpeed());
    }
}
