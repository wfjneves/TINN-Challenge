package neves.jesus.felipe.wesley.TINNChallenge.model.repository.veiculo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import neves.jesus.felipe.wesley.TINNChallenge.model.FiltroVeiculoDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.entity.Veiculo;

public class VeiculoRepositoryImpl implements VeiculoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<VeiculoDto> findVeiculos(FiltroVeiculoDto filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<VeiculoDto> criteria = builder.createQuery(VeiculoDto.class);
		Root<Veiculo> root = criteria.from(Veiculo.class);
		criteria.select(builder.construct(VeiculoDto.class, root.get("id"),
				root.get("veiculo"), root.get("marca"), root.get("ano"),
				root.get("descricao"), root.get("vendido"),
				root.get("created"), root.get("updated")));

		Predicate[] restricoes = criarRestricoes(filtro, root, builder);
		criteria.where(restricoes);

		TypedQuery<VeiculoDto> typedQuery = manager.createQuery(criteria);
		adicionarPaginacao(pageable, typedQuery);

		return new PageImpl<VeiculoDto>(typedQuery.getResultList(), pageable, total(filtro));
	}
	
	private void adicionarPaginacao(Pageable pageAble, TypedQuery<?> query) {
		int paginaAtual = pageAble.getPageNumber();
		int quantidadeDeRegistrosPorPagina = pageAble.getPageSize();
		int primeiroRegistroASerExibido = paginaAtual * quantidadeDeRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroASerExibido);
		query.setMaxResults(quantidadeDeRegistrosPorPagina);

	}

	private Long total(FiltroVeiculoDto filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Veiculo> root = criteria.from(Veiculo.class);
		Predicate[] restricoes = criarRestricoes(filtro, root, builder);
		criteria.where(restricoes);

		criteria.select(builder.count(root));

		return manager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] criarRestricoes(FiltroVeiculoDto veiculo, Root<Veiculo> root, CriteriaBuilder builder) {
		List<Predicate> lista = new ArrayList<Predicate>();
		
		lista.add(builder.equal(root.get("vendido"),veiculo.isVendido()));

		if (!StringUtils.isBlank(veiculo.getMarca())) {
			lista.add(builder.like(builder.trim(builder.lower(root.get("marca"))),
					"%" + veiculo.getMarca().toLowerCase().trim() + "%"));
		}
		
		if (!StringUtils.isBlank(veiculo.getDescricao())) {
			lista.add(builder.like(builder.trim(builder.lower(root.get("descricao"))),
					"%" + veiculo.getDescricao().toLowerCase().trim() + "%"));
		}
		
		if (!StringUtils.isBlank(veiculo.getVeiculo())) {
			lista.add(builder.like(builder.trim(builder.lower(root.get("veiculo"))),
					"%" + veiculo.getVeiculo().toLowerCase().trim() + "%"));
		}
		
		if (veiculo.getAno()!=null) {
			lista.add(builder.equal(root.get("ano"),veiculo.getAno()));
		}

		if (veiculo.getDataInicioCriacao() != null) {
			lista.add(builder.greaterThanOrEqualTo(root.get("created"), veiculo.getDataInicioCriacao()));
		}

		if (veiculo.getDataFinalCriacao() != null) {
			lista.add(builder.lessThanOrEqualTo(root.get("created"), veiculo.getDataFinalCriacao()));
		}

		return lista.toArray(new Predicate[lista.size()]);
	}


}
