package pessoadto;

public class PessoaDTO {
	private String nomeDto;
	private int idadeDto;
	
	public String getNomeDto() {
		return this.nomeDto;
	}
	
	public int getIdadeDto() {
		return this.idadeDto;
	}
	
	public PessoaDTO(String nome, int idade) {
		this.nomeDto = nome;
		this.idadeDto = idade;
	}
	

}
