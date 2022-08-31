package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.excepitions.DomainException;

public class Programa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Número do quarto: ");
			int nQuarto = sc.nextInt();
			sc.nextLine();

			System.out.println("Data CheckIn (dd/mm/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Data CheckOut (dd/mm/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Reserva reserva = new Reserva(nQuarto, checkin, checkout);
			System.out.println(reserva);

			System.out.println("Entre com a data de atualização da reserva:");
			System.out.println("Data CheckIn (dd/mm/yyyy): ");
			checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Data CheckOut (dd/mm/yyyy): ");
			checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			reserva.atualizarDatas(checkin, checkout);
			System.out.println(reserva);
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}

		sc.close();
	}
}
