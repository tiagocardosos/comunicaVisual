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
	public static final String PG_LISTA_DE_CIDADE = "pgcidade";
	public static final String PG_LISTA_DE_ESTADO = "pgestado";
	public static final String PG_PESSOA_JURIDICA = "pgpjuridica";
	public static final String HOME = "index";
	public static final String PG_PRODUTO = "pgproduto";
	public static final String PG_TB_PRODUTO = "pgtbproduto";
	public static final String PG_TB_PJ = "pgtbpfisica";
	public static final String PG_TB_PF = "pgtbpjuridica";
	
	public String pgPessoaFisica(){
	    return URL + "?faces-redirect=true";
	}
	public String pgListadeCidade(){
		return PG_LISTA_DE_CIDADE + "?faces-redirect=true";
	}
	public String pgListadeEstado(){
		return PG_LISTA_DE_ESTADO + "?faces-redirect=true";
	}
	public String pgPessoaJuridica(){
		return PG_PESSOA_JURIDICA + "?faces-redirect=true";
	}
	public String home(){
		return HOME + "?faces-redirect=true";
	}
	public String pgProduto(){
		return PG_PRODUTO + "?faces-redirect=true";
	}
	public String pgTbProduto(){
		return PG_TB_PRODUTO + "?faces-redirect=true";
	}
	public String pgTbPFisica(){
		return PG_TB_PJ + "?faces-redirect=true";
	}
	public String pgTbPJuridica(){
		return PG_TB_PF + "?faces-redirect=true";
	}
}
