package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next()); // INSERIR UMA NOVA DATA
		System.out.print("Check-out date (DD/MM/YYYY: ");
		Date checkOut = sdf.parse(sc.next()); // INSERIR UMA NOVA DATA
		
		if (!checkOut.after(checkIn)) { // MÉTODO USADO PARA TESTAR SE UMA DATA 'NÃO (!)' É POSTERIOR A OUTRA
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Resevation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next()); // INSERIR UMA NOVA DATA
			System.out.print("Check-out date (DD/MM/YYYY: ");
			checkOut = sdf.parse(sc.next()); // INSERIR UMA NOVA DATA
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) { // MÉTODO USADO PARA VER SE AS DATAS EM QUESTÃO SÃO ANTERIORES A DATA ATUAL.
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut); //MÉTODO PARA ATUALIZAR AS DATAS
				System.out.println("Resevation: " + reservation);
			}
			
		}	
		
		sc.close();
	}
}
