package neves.jesus.felipe.wesley.TINNChallenge.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RequiredFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7078377299327835885L;

	@NonNull
	@Getter
	private Object[] fieldNames;

}
