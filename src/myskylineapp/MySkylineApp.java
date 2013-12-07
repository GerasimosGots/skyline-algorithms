package myskylineapp;

import java.io.BufferedReader;
import java.util.Date;
import java.io.File.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import java.io.File.*;
import java.io.IOException;

/**
 *
 * @author kostas livieratos
 */
public class MySkylineApp {

    /**
     * @param args the command line arguments
     */
    public static int Min = 0, Max = 10;

    public static void main(String[] args) {
        int N = 10; //we do not need to care about the value of N,by the time we read the points from a file (*.txt)
        Scanner input = new Scanner(System.in);
        //for (N = 10; N <= 100; N = N * 10) {
        ListDoublePoints P = new ListDoublePoints();
        ListDoublePoints P2 = new ListDoublePoints();
        long algtm2, algtm1;
        String path, line = null;
        try {
            System.out.printf("Give the name of txt file :");
            path = input.next();
            FileReader reader = new FileReader(path+".txt");
            BufferedReader br = new BufferedReader(reader);
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                float diastasi1 = (float)Float.parseFloat(parts[1]);
                float diastasi2 = (float)Float.parseFloat(parts[2]);
                P.insertFirst(diastasi1, diastasi2);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //copylist P to list P2, for SkylineAlg2
        DoublePoint p = P.first;     //p node gets the first node of list P
        DoublePoint q = P2.first;
        //the deep copy code is a generous contribution from a stackoverflow.com user
        DoublePoint gcurrent, pcurrent;
        P2.first = new DoublePoint(P.first.x, P.first.y);
        gcurrent = P2.first;
        pcurrent = P.first;
        while (pcurrent.next != null) {
            gcurrent.next = new DoublePoint(pcurrent.next.x, pcurrent.next.y);
            gcurrent = gcurrent.next;
            pcurrent = pcurrent.next;
        }
        gcurrent.next = null;
        //end of deep copy
        
        
        Date d1alg1 = new Date();
        SkylineAlg1 alg1 = new SkylineAlg1();
        alg1.dominating(P);
        Date d2alg1 = new Date();
        P.displayList();
        algtm1 = d2alg1.getTime() - d1alg1.getTime();
        System.out.printf("First skyline algorithm time: %s%s\n", algtm1, " milliseconds");
        System.out.printf("\n");
        Date d1alg2 = new Date();
        SkylineAlg2 alg2 = new SkylineAlg2();
        P2.append(P2.mergeSort(P2.extractFirst()));
        alg2.sorting(P2);
        Date d2alg2 = new Date();
        P2.displayList();
        algtm2 = d2alg2.getTime() - d1alg2.getTime();
        System.out.printf("Second skyline algorithm time: %s%s\n", algtm2, " milliseconds");
        System.out.println("------------------");

    }
    //}

}
