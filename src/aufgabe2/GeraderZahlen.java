/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe2;

import firsthomeworkfschaur18.ErastothenesPrimeSieve;
import java.util.ArrayList;
import java.util.Scanner;

public class GeraderZahlen {

    private ArrayList<Integer> primeList = new ArrayList<Integer>();
    private ErastothenesPrimeSieve eps;
    private ArrayList<Integer> natList = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println("Geben Sie eine Obergrenze ein");
        Scanner scanner = new Scanner(System.in);
        int obergrenze = 0;
        while (obergrenze < 1) {
            try {
                obergrenze = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Geben Sie eine Zahl ein.");
            }
            if (obergrenze < 1) {
                System.out.println("Geben Sie eine positive Zahl ein.");
            }
        }
       GeraderZahlen az = new GeraderZahlen(obergrenze);

        az.printAlgorithmus();
    }

    public GeraderZahlen(int ober) {
        eps = new ErastothenesPrimeSieve(ober);
        primeList.addAll(eps.getListOfPrimes());
        for (int i = 4; i <= ober; i++) {
            natList.add(i);
            i++;
        }
    }

    private void printAlgorithmus() {
        for (int i = 0; i < natList.size(); i++) {
            System.out.println(calcAlgorithmus(natList.get(i)));
        }
    }

    private String calcAlgorithmus(int natZahl) {
        int r = 0;
        for (int i = primeList.size(); i > 0; i--) {
            if (primeList.get(i - 1) < natZahl) {
                r = primeList.get(i - 1);
                if (primeList.contains(natZahl - r)) {
                    return (natZahl + " summe: " + natZahl + " = " + r + " + " + (natZahl - r));
                }
            }
        }
        return ("");
    }

}
