package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-In date (DD/MM/AAAA): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (DD/MM/AAAA): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-In date (DD/MM/AAAA): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (DD/MM/AAAA): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error : " + e.getMessage());
        }
        catch (DomainException e){
            System.out.println("Error : " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
