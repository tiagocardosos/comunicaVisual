package br.com.drem.managebean.produtoMb.rn;

import br.com.drem.dao.ProdutoDao;
import br.com.drem.entity.Produto;

/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
public class RegraNegocioProduto {

	private static Produto produto;

	public RegraNegocioProduto() {
		produto = new Produto();
	}
	/**Método para salvar um produto*/
	public static void salvar(Produto produto) {
		if (produto.getIdProduto() == null || produto.getIdProduto() == 0) {
			ProdutoDao.salvar(produto);
		} else {
			ProdutoDao.alterar(produto);
		}
	}
	/**Metodo para exlcusão*/
	public static void excluir(Produto produto){
		ProdutoDao.excluir(produto);
	}

	/** Metodo para gerar um novo objeto produto */
	public static void limpProduto() {
		produto = new Produto();
	}

	/** get and set de produto */
	public static Produto getProduto() {
		return produto;
	}

	public static void setProduto(Produto produto) {
		RegraNegocioProduto.produto = produto;
	}

}
