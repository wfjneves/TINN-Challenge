package neves.jesus.felipe.wesley.TINNChallenge.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import neves.jesus.felipe.wesley.TINNChallenge.exception.MarcaException;
import neves.jesus.felipe.wesley.TINNChallenge.exception.VeiculoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private Environment env;
	
	@ExceptionHandler(value= { MarcaException.class })
	public final ResponseEntity<Object> handleMarcaException(MarcaException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(env.getProperty("marca.invalida"));
	}
	
	@ExceptionHandler(value= { VeiculoNotFoundException.class })
	public final ResponseEntity<Object> handleMarcaException(VeiculoNotFoundException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(env.getProperty("veiculo.nao.encontrado"));
	}

}
