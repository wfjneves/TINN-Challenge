package neves.jesus.felipe.wesley.TINNChallenge.controller;

import java.io.IOException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import neves.jesus.felipe.wesley.TINNChallenge.model.VeiculoDto;

public class TestesUtil {
	
	public static VeiculoDto cadastrarVeiculo(VeiculoDto veiculo) throws ParseException, IOException {
		String json = new ObjectMapper().writeValueAsString(veiculo);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8181/veiculos");
		post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
		post.setHeader("Accept", "application/json");
		post.setHeader("Content-type", "application/json");
		CloseableHttpResponse response = client.execute(post);
		VeiculoDto cadastrado= TestesUtil.retrieveResourceFromResponse(response, VeiculoDto.class);
		response.close();
		client.close();
		return cadastrado;
	}

	public static <T> T retrieveResourceFromResponse(CloseableHttpResponse response, Class<T> clazz) throws IOException, ParseException {

		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(jsonFromResponse, clazz);
	}

}
