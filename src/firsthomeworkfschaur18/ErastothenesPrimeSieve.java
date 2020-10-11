
package firsthomeworkfschaur18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ErastothenesPrimeSieve implements PrimeSieve {

    private ArrayList<Integer> listZahlen = new ArrayList<Integer>();
    private TreeSet<Integer> listOfMultiples = new TreeSet<Integer>();
    

    public static void main(String[] args) {
        System.out.println("Geben Sie eine Obergrenze ein.");
        Scanner scanner = new Scanner(System.in);
        int ober = 0;
        while (ober < 1) {
            try {
                ober = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Geben Sie eine Zahl ein.");
            }
            if (ober < 1) {
                System.out.println("Geben Sie eine positive Zahl ein.");
            }
        }

        ErastothenesPrimeSieve es = new ErastothenesPrimeSieve(ober);
        es.printPrimes();
    }

    public ErastothenesPrimeSieve(int obergrenze) {
        
        for (int i = 2; i <= obergrenze; i++) {
            listZahlen.add(i);
        }

    }

    @Override
    public boolean isPrime(int p) {
        if (p <= 2) {
            return (p == 2);
        }
        for (int i = 2; i * i <= p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printPrimes() {
        calcPrime();
        System.out.println("Primzahlen: ");
        System.out.println("");
        for (int i = 0; i < listZahlen.size(); i++) {
            System.out.print(listZahlen.get(i) + " ");
        }

    }

    private void calcPrime() {
        Iterator<Integer> it = listZahlen.iterator();
        int temp = 0;
        while (it.hasNext()) {
            temp = it.next();

            if (isPrime(temp)) {
                createListOfMultiples(temp);
            } else {
                createListOfMultiples(temp);
                it.remove();
            }

        }
        listZahlen.remove(listOfMultiples);
    }

    private void createListOfMultiples(int number) {
        for (int i = 2; i * number <= listZahlen.size(); i++) {
            listOfMultiples.add(number * i);
        }

    }

    public ArrayList<Integer> getListOfPrimes() {
        calcPrime();
        return listZahlen;
    }

}
