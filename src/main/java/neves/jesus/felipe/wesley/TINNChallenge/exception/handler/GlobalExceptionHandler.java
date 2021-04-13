package neves.jesus.felipe.wesley.TINNChallenge.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import neves.jesus.felipe.wesley.TINNChallenge.exception.MarcaException;
import neves.jesus.felipe.wesley.TINNChallenge.exception.RequiredFieldException;
import neves.jesus.felipe.wesley.TINNChallenge.exception.VeiculoNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource message;
	
	@ExceptionHandler(value= { MarcaException.class })
	public final ResponseEntity<Object> handleMarcaException(MarcaException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage("marca.invalida", null, LocaleContextHolder.getLocale()));
	}
	
	@ExceptionHandler(value= { RequiredFieldException.class })
	public final ResponseEntity<Object> handleRequiredFieldException(RequiredFieldException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.getMessage("validacao.obrigatoria", ex.getFieldNames(), LocaleContextHolder.getLocale()));
	}
	
	@ExceptionHandler(value= { VeiculoNotFoundException.class })
	public final ResponseEntity<Object> handleMarcaException(VeiculoNotFoundException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message.getMessage("veiculo.nao.encontrado", null, LocaleContextHolder.getLocale()));
	}

}
