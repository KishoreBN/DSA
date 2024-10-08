package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static int x = 10;
    public static void main( String[] args )
    {

    }

    static void sample(Integer i){
        i = i + 1;
    }

    public static int sum(int num1, int num2){
        return num1 + num2;
    }

    public static void showdow(){
        System.out.println(x);
    }

    public static void varargs(int num,int v){
        System.out.println("1");
        System.out.println(v);
    }

    static class IndividualEligibility{
        long indvId;
        Date startDate;
        Date endDate;
        IndividualEligibility(long indvId, Date startDate, Date endDate){
            this.indvId = indvId;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    public static void varargs(int num, int ...v){
        int[] arr = {1,2,3};
        System.out.println(Arrays.asList(arr));
    }
}
