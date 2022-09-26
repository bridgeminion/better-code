package google_high_frequency;

import java.util.*;

public class RLEIterator {
//    int index;
//    int [] A;
//    public RLEIterator(int[] A) {
//        this.A = A;
//        index = 0;
//    }
//
//    public int next(int n) {
//        while(index < A.length && n > A[index]){
//            n = n - A[index];
//            index += 2;
//        }
//
//        if(index >= A.length){
//            return -1;
//        }
//
//        A[index] = A[index] - n;
//        System.out.println("A[index]=" + A[index]);
//        return A[index + 1];
//    }
     int[] encoding;
     int pos;

     public RLEIterator(int[] encoding) {
         this.encoding = encoding;
         pos = 0;
     }

     public int next(int n) {
         while (pos < encoding.length-1 && encoding[pos] < n) {
             n -= encoding[pos];
             pos += 2;
         }
         if (pos > encoding.length - 1) {
             return -1;
         }
         encoding[pos] -= n;
         return encoding[pos+1];
     }

    public static void main(String[] args) {
        int[] encoding = {811,903,310,730,899,684,472,100,434,611};
        RLEIterator app = new RLEIterator(encoding);
        System.out.println(app.next(358));
        System.out.println(app.next(345));
        System.out.println(app.next(154));
        System.out.println(app.next(265));
        System.out.println(app.next(73));
        System.out.println(app.next(220));
        System.out.println(app.next(138));
        System.out.println(app.next(4));
        System.out.println(app.next(170));
        System.out.println(app.next(88));
//        int[] encoding = {923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82};
//        RLEIterator app = new RLEIterator(encoding);
//        System.out.println(app.next(612783106));
//        System.out.println(app.next(486444202));
//        System.out.println(app.next(630147341));
//        System.out.println(app.next(845077576));
//        System.out.println(app.next(243035623));
    }

}
