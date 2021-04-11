package neves.jesus.felipe.wesley.TINNChallenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import neves.jesus.felipe.wesley.TINNChallenge.model.Veiculo;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoRepository;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner inicializarBancoDeDados(VeiculoRepository veiculoRepository) {
		return args -> {
			veiculoRepository.save(new Veiculo("Fit", "Honda", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("WR-V", "Honda", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("HR-V", "Honda", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Nivus", "Volkswagem", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("T-Cross", "Volkswagem", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Polo", "Volkswagem", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Kicks", "Nissan", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("F Type", "Juaguar", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Fusion", "Ford", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Ranger", "Ford", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Creta", "Hyunda", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("CRV", "Honda", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Sportage", "Kia", 2021, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Golf", "Volkswagem", 2020, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Toro", "Fiat", 2020, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Renegade", "Jeep", 2020, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Compass", "Jeep", 2020, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Captur", "Renault", 2020, "Veiculo de procedência", false));
			veiculoRepository.save(new Veiculo("Duster", "Renault", 2020, "Veiculo de procedência", false));
		};
	}

}
