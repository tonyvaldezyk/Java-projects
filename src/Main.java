//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_NUMBER = 12;
        final int PERCENT = 100;

        System.out.println("Bienvenue dans votre calculateur d'emprunt");
        Scanner scanner = new Scanner(System.in);

//////////////// MONTANT DU PRÊT ////////////////////////////////////

        System.out.print("Montant du prêt: ");
        int AMOUNT = scanner.nextInt();

       do {
           if (AMOUNT < 1000 ) {
               System.out.println("Veuillez entrer un montant supérieur ou égal à  1000€");
               AMOUNT = scanner.nextInt();
           }
           if (AMOUNT > 1000000) {
               System.out.println("Veuillez entrer un montant inférieur ou égal à  1.000.000€");
               AMOUNT = scanner.nextInt();
           }
       } while (AMOUNT < 1000 || AMOUNT > 1000000);

/////////////////// TAUX_ANNUEL /////////////////////////////////////

        System.out.print("Entrez le taux annuel: ");

        float TAUX_ANNUEL = scanner.nextFloat() ;

        if (TAUX_ANNUEL < 1 || TAUX_ANNUEL > 30) {
            System.out.println("Veuillez entrer un taux compris entre 1% et 30%");
            TAUX_ANNUEL = scanner.nextFloat();
        }

        float TAUX_MENSUEL = TAUX_ANNUEL /PERCENT/MONTH_NUMBER; // Calcul du taux mensuel

        /////////////////// DUREE DU PRÊT /////////////////////////////////////

        System.out.print("Durée du prêt en années: ");
        byte ANNEE =  scanner.nextByte() ;
        int  NOMBRE_MOIS = ANNEE * MONTH_NUMBER;

        if (ANNEE < 1 || ANNEE > 30) {
            System.out.println("Veuillez entrer un nombre d'année compris entre 1 et 30");
            ANNEE = scanner.nextByte();
        }

        Double RESULT =  AMOUNT * ( TAUX_MENSUEL * Math.pow( TAUX_MENSUEL +1 , NOMBRE_MOIS) /
                ( Math.pow(TAUX_MENSUEL+1, NOMBRE_MOIS) - 1));

        String FINAL_RESULT = NumberFormat.getCurrencyInstance().format( RESULT );
        System.out.print("Votre remboursement mensuel s'élève à " + FINAL_RESULT);
    }
}