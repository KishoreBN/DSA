package org.example.ObjectOriented;

public class CopyConstructor {
    int test;
    static class Shape{
        String name;

        Shape(String name){
            this.name = name;
        }

        Shape(Shape obj){
            this.name = obj.name;
        }

        @Override
        public String toString(){
            return " [ name : " + this.name + " ] ";
        }
    }

    public static void main(String[] args) {
        CopyConstructor copyObject = new CopyConstructor();
        CopyConstructor.Shape square = new CopyConstructor.Shape("Square");
        CopyConstructor.Shape square2 = new CopyConstructor.Shape(square);
        System.out.println(square2);
    }
}
