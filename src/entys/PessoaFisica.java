package entys;

/*
 * Autor: André Martins 
 * contato: andremartins@outlook.com.br
 * tecnologias sendo utilizadas: jpa, hibernate, java e postgresql 9
*/

import javax.persistence.Entity;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name = "pessoaFisica", schema = "dremcom_drem")
public class PessoaFisica extends Pessoa{

	private String cpf;
	private String matricula;
	private String rg;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	

}
