package org.example.Recursion;

public class TrianglePattern {
    public static void main(String[] args) {
        printRow(8);
    }
    static void printRow(int row){
        int column = 0;
        if(row < 0)
            return;
        while(column < row){
            System.out.print("*");
            column++;
        }
        System.out.println();
        printRow(--row);
    }
}
