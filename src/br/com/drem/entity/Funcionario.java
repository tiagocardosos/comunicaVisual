package br.com.drem.entity;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario extends Pessoa{

	private String tempoDeCasa;
	private String numeroDaCarteira;
	public Funcionario(String tempoDeCasa, String numeroDaCarteira) {
		super();
		this.tempoDeCasa = tempoDeCasa;
		this.numeroDaCarteira = numeroDaCarteira;
	}
	public Funcionario() {}
	public String getTempoDeCasa() {
		return tempoDeCasa;
	}
	public void setTempoDeCasa(String tempoDeCasa) {
		this.tempoDeCasa = tempoDeCasa;
	}
	public String getNumeroDaCarteira() {
		return numeroDaCarteira;
	}
	public void setNumeroDaCarteira(String numeroDaCarteira) {
		this.numeroDaCarteira = numeroDaCarteira;
	}
	
	
	

}
