package model.entities;

import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.excepitions.DomainException;

public class Reserva {
	private Integer numeroQuarto;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reserva() {}

	public Reserva(Integer numeroQuarto, LocalDate checkin, LocalDate checkout) throws DomainException {
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Erro na reserva: a data de checkout deve ser após a data de checkin");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public long duracao() {
		return Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay()).toDays();
	}
	
	public void atualizarDatas(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate agr = LocalDate.now();
		if (checkin.isBefore(agr) || checkout.isBefore(agr)) {
			throw new DomainException("Erro na reserva: as datas para atualização devem ser datas futuras");
		}
		if(checkout.isBefore(checkin)) {
			throw new DomainException("Erro na reserva: a data de checkout deve ser após a data de checkin");
		}
		
		this.checkin = checkIn;
		this.checkout = checkOut;
	}

	@Override
	public String toString() {
		return "\nQuarto: " + getNumeroQuarto() +
				", checkin:" + checkin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
				", checkout:" + checkout.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
				", Duração: "+duracao()+" noite(s).";
	}

}
