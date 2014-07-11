package br.com.drem.dao;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */

public interface DaoPadrao {
	/** Metodos padrões */
	
	/** Para salvar o objeto da entidade */
	public String salvar(Object object);
	
	/** Para excluir o objeto da entidade */
	public String excluir(Object object);
	
	/** Para alterar o objeto da entidade */
	public String alterar(Object object);
	
	/** Para buscar o objeto da entidade */
	public String buscar(Object object);
	

}
