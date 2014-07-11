package br.com.drem.managebean;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import javax.faces.bean.ManagedBean;

@ManagedBean(name="mbPagina")
public class MbPagina {
	public static final String URL = "pgpfisica";
	public static final String PG_LISTA_DE_CIDADE = "pglistadecidade";
	public static final String PG_LISTA_DE_ESTADO = "pgestado";
	public String pgPessoaFisica(){
	    return URL + "?faces-redirect=true";

	}
	public String pgListadeCidade(){
		return PG_LISTA_DE_CIDADE + "?faces-redirect=true";
	}
	public String pgListadeEstado(){
		return PG_LISTA_DE_ESTADO + "?faces-redirect=true";
	}
}
