package org.example;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class IndividualEligibility {

    static class IndividualEligibilityRec{
        long indvId;
        LocalDate startDate;
        LocalDate endDate;
        IndividualEligibilityRec(long indvId, LocalDate startDate, LocalDate endDate){
            this.indvId = indvId;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        @Override
        public String toString() {
            return indvId + " " + startDate + " " + endDate;
        }
    }

    public static void main(String[] args) {
        LocalDate minDate = LocalDate.of(2014, 01, 01);
        LocalDate maxDate = LocalDate.of(2017, 01, 01);
        generateEligibilityArr(minDate, maxDate, fetchRecords());
    }

    static List<IndividualEligibilityRec> fetchRecords(){
        IndividualEligibilityRec one = new IndividualEligibilityRec(1, LocalDate.of(2014, 01, 01), LocalDate.of(2014, 12, 31));
        IndividualEligibilityRec two = new IndividualEligibilityRec(1, LocalDate.of(2016, 01, 01), LocalDate.of(2016, 12, 31));
        IndividualEligibilityRec three = new IndividualEligibilityRec(1, LocalDate.of(2023, 8, 01), LocalDate.of(2023, 07, 20));
        return new ArrayList<>(List.of(one, two, three));
    }

    static void generateEligibilityArr(LocalDate startDate, LocalDate endDate, List<IndividualEligibilityRec> records){
        List<Integer> arr = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0, sum = 0;
        boolean isEligible = false;
        while(startDate.isBefore(endDate)){
            boolean isEligibleForMonth = false;
            for(int i=0; i<records.size(); i++){
                if((startDate.isAfter(records.get(i).startDate) || startDate.equals(records.get(i).startDate))
                        && (startDate.equals(records.get(i).endDate) || startDate.isBefore(records.get(i).endDate))){
                    isEligibleForMonth = true;
                    break;
                }
            }
            if(ptr2 <= 36){
                ptr2++;
                if(isEligibleForMonth) {
                    arr.add(1);
                    sum++;
                } else {
                    arr.add(0);
                }
            } else {
                if(isEligibleForMonth){
                    arr.add(1);
                } else {
                    arr.add(0);
                }
                sum = sum - arr.get(ptr1) + arr.get(ptr2);
                ptr1++;
                ptr2++;
            }
            startDate = startDate.plusMonths(1);
            if(sum >= 24){
                isEligible= true;
            }
        }
        System.out.println(arr);
        System.out.println(isEligible);
    }

//    static void generateEligibilityArr2(LocalDate startDate, LocalDate endDate, List<IndividualEligibilityRec> records){
//        List<Integer> arr = new ArrayList<>();
//        int ptr1 = 0, ptr2 = 0, sum = 0;
//        boolean isEligible = false;
//        while(startDate.isBefore(endDate)){
//            boolean isEligibleForMonth = false;
//            for(int i=0; i<records.size(); i++){
//                if(
//                        (startDate.isAfter(records.get(i).startDate) || startDate.equals(records.get(i).startDate) || (startDate.getMonth() == records.get(i).))
//                        && (startDate.equals(records.get(i).endDate) || startDate.isBefore(records.get(i).endDate))
//                ){
//                    isEligibleForMonth = true;
//                    break;
//                }
//            }
//            if(ptr2 <= 36){
//                ptr2++;
//                if(isEligibleForMonth) {
//                    arr.add(1);
//                    sum++;
//                } else {
//                    arr.add(0);
//                }
//            } else {
//                if(isEligibleForMonth){
//                    arr.add(1);
//                } else {
//                    arr.add(0);
//                }
//                sum = sum - arr.get(ptr1) + arr.get(ptr2);
//                ptr1++;
//                ptr2++;
//            }
//            startDate = startDate.plusMonths(1);
//            if(sum >= 24){
//                isEligible= true;
//            }
//        }
//        System.out.println(arr);
//        System.out.println(isEligible);
//    }
}
