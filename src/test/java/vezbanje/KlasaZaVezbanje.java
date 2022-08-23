package vezbanje;

import java.util.Scanner;

public class KlasaZaVezbanje {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner skener =new Scanner(System.in);
        System.out.println("Unesite broj elementa niza : ");
        int brojElem = skener.nextInt();
        int[] nizBrojeva = new int[brojElem];
        int zbir= 0;

        for(int i=0; i<brojElem; i++) {
            System.out.println((i+1) + ".broj:" );
            nizBrojeva[i] = skener.nextInt();
            zbir += nizBrojeva[i];
        }
        System.out.println("Zbir brojeva je :" + zbir);

        try{
            double aritmetickaSredina = (double) zbir/brojElem ;
            System.out.println("Aritmeticka sredina je :" + aritmetickaSredina );
        }
        catch (ArithmeticException ex) {

            System.out.println(" Deljenje nulom ");

        }

        skener.close();
    }

}
