package neves.jesus.felipe.wesley.TINNChallenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MarcaEnum {

	Audi("Audi"),
	BMW("BMW"),
	Chevrolet("Chevrolet"),
	Chrysler("Chrysler"),
	Citroen("Citroën"),
	Dodge("Dodge"),
	Ferrari("Ferrari"),
	Fiat("Fiat"),
	Ford("Ford"),
	Honda("Honda"),
	Hyundai("Hyundai"),
	JAC("JAC"),
	Jaguar("Jaguar"),
	Jeep("Jeep"),
	Kia("Kia"),
	Lamborghini("Lamborghini"),
	LandRover("Land Rover"),
	Lexus("Lexus"),
	Lifan("Lifan"),
	Maserati("Maserati"),
	McLaren("McLaren"),
	MercedesBenz("Mercedes-Benz"),
	Mini("Mini"),
	Mitsubishi("Mitsubishi"),
	Nissan("Nissan"),
	Peugeot("Peugeot"),
	Porsche("Porsche"),
	RAM("RAM"),
	Renault("Renault"),
	RollsRoyce("Rolls-Royce"),
	SsangYong("SsangYong"),
	Subaru("Subaru"),
	Suzuki("Suzuki"),
	Toyota("Toyota"),
	Volkswagen("Volkswagen"),
	Volvo("Volvo");
	
	private String descricao;
	
	public static MarcaEnum getEnumPelaDescricao(String descricao) {
		MarcaEnum retorno = null;
		for (MarcaEnum marca : MarcaEnum.values()) {
			if (marca.getDescricao().equalsIgnoreCase(descricao)) {
				retorno = marca;
				break;
			}
		}
		return retorno;
	}

}
