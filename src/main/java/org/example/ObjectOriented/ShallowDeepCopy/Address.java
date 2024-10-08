package org.example.ObjectOriented.ShallowDeepCopy;

public class Address implements Cloneable{
    private String city;
    public String state;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    Address(String city, String state){
        this.city = city;
        this.state = state;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
