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

        System.out.print("Montant du prêt: ");
        int AMOUNT = scanner.nextInt();

        System.out.print("Entrez le taux annuel: ");
        float TAUX_ANNUEL = scanner.nextFloat() ;
        float TAUX_MENSUEL = TAUX_ANNUEL /PERCENT/MONTH_NUMBER;

        System.out.print("Durée du prêt en années: ");
        byte ANNEE =  scanner.nextByte() ;
        int  NOMBRE_MOIS = ANNEE * MONTH_NUMBER;

        Double RESULT =  AMOUNT * ( TAUX_MENSUEL * Math.pow( TAUX_MENSUEL +1 , NOMBRE_MOIS) /
                ( Math.pow(TAUX_MENSUEL+1, NOMBRE_MOIS) - 1));

        String FINAL_RESULT = NumberFormat.getCurrencyInstance().format( RESULT );
        System.out.print("Votre remboursement mensuel s'élève à " + FINAL_RESULT);
    }
}