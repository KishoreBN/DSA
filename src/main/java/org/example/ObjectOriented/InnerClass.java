package org.example.ObjectOriented;

public class InnerClass {

    /**
     * Non-Static Innerclass. We have to refer to the parent object while creating the object of innerclass.
     */
    class Car{
        String model;

        Car(String model){
            this.model = model;
        }

        @Override
        public String toString(){
            return " [ model : " + this.model + " ] ";
        }
    }

    /**
     * For static inner class, we can directly create the object using parent class name.
     */
    static class Motorbike{
        String model;
        Motorbike(String model){
            this.model = model;
        }
        @Override
        public String toString(){
            return " [ model : " + this.model + " ] ";
        }
    }

    public static void main(String[] args) {
        InnerClass inner = new InnerClass();
        InnerClass.Car car = inner.new Car("Ford");
        System.out.println(car);
        InnerClass.Motorbike motorbike = new InnerClass.Motorbike("Yamaha");
        System.out.println(motorbike);
    }
}
