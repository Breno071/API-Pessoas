package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends Exception{
	public PessoaNaoEncontradaException(long id) {
		super("Não foi encontrada nenhuma pessoa com o id " + id);
	}
}
