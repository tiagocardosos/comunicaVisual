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
@Table(name = "pessoaJuridica", schema ="dremcom_drem")
public class PessoaJuridica extends Pessoa{
	
	private String cnpj;
	private String razaoSocial;
	private String inscricaoEstadual;
	private String matricula;
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	

}
