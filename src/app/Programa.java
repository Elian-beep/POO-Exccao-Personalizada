package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Número do quarto: ");
		int nQuarto = sc.nextInt();
		sc.nextLine();

		System.out.println("Data CheckIn (dd/mm/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Data CheckOut (dd/mm/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		if (checkout.isBefore(checkin)) {
			System.out.println("Erro na reserva: a data de check-out deve ser após a data de check-in");
		} else {
			Reserva reserva = new Reserva(nQuarto, checkin, checkout);
			System.out.println(reserva);

			System.out.println("Entre com a data de atualização da reserva:");
			System.out.println("Data CheckIn (dd/mm/yyyy): ");
			checkin = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.println("Data CheckOut (dd/mm/yyyy): ");
			checkout = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			String erro = reserva.atualizarDatas(checkin, checkout);
			if (erro != null) {
				System.out.println(erro);
			}else {
				System.out.println(reserva);
			}
		}

		sc.close();
	}
}
