package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-In date (DD/MM/AAAA): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (DD/MM/AAAA): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-In date (DD/MM/AAAA): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (DD/MM/AAAA): ");
            checkOut = sdf.parse(sc.next());

            // solucao mais ou menos

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println(error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();

    }
}
