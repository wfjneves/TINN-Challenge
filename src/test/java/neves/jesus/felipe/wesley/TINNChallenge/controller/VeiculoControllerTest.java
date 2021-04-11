package neves.jesus.felipe.wesley.TINNChallenge.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import neves.jesus.felipe.wesley.TINNChallenge.model.StatusVendaCarroDto;
import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;

public class VeiculoControllerTest {

	private VeiculoDto cadastrado;
	
	@Before
	public void before() throws IOException, ParseException {
		cadastrado= TestesUtil.cadastrarVeiculo(new VeiculoDto("Fit LX", "Honda", 2011, "Veiculo de procedência", false));
	}
	
	@Test
	public void buscarVeiculoQueNaoExiste_E_Receber404() throws IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8181/veiculos/100");
		
		HttpResponse response  = HttpClientBuilder.create().build().execute(request);
		
		assertThat(response.getCode(), equalTo(HttpStatus.SC_NOT_FOUND) );
	}
	

	@Test
	public void cadastrarVeiculo() throws IOException, ParseException {
		VeiculoDto veiculo= TestesUtil.cadastrarVeiculo(new VeiculoDto("Fit LX", "Honda", 2011, "Veiculo de procedência", false));
		assertNotNull(veiculo.getId());
	}
	
	
	@Test
	public void atualizarVeiculo() throws IOException {
		
		VeiculoDto veiculo = new VeiculoDto("Fit LX", "Honda", 2011, "Suspensão tipo eixo de torção", false);
		String json = new ObjectMapper().writeValueAsString(veiculo);
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut put = new HttpPut("http://localhost:8181/veiculos/"+cadastrado.getId());
		put.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
		
		put.setHeader("Accept", "application/json");
		put.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = client.execute(put);
		
		assertThat(response.getCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test
	public void venderVeiculo() throws IOException {
		
		StatusVendaCarroDto status = new StatusVendaCarroDto(2L, true);
		String json = new ObjectMapper().writeValueAsString(status);
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPatch patch = new HttpPatch("http://localhost:8181/veiculos/"+cadastrado.getId());
		patch.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
		
		patch.setHeader("Accept", "application/json");
		patch.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = client.execute(patch);
		
		assertThat(response.getCode(), equalTo(HttpStatus.SC_NO_CONTENT));
	}
	
	@Test
	public void deletarVeiculo() throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete delete = new HttpDelete("http://localhost:8181/veiculos/"+cadastrado.getId());
		CloseableHttpResponse response = client.execute(delete);
		assertThat(response.getCode(), equalTo(HttpStatus.SC_NO_CONTENT));
	}
	
	


}
