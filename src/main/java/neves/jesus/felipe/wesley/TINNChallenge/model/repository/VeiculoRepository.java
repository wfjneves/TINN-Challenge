package neves.jesus.felipe.wesley.TINNChallenge.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import neves.jesus.felipe.wesley.TINNChallenge.model.entity.Veiculo;
import neves.jesus.felipe.wesley.TINNChallenge.model.repository.veiculo.VeiculoRepositoryQuery;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, VeiculoRepositoryQuery{

}
