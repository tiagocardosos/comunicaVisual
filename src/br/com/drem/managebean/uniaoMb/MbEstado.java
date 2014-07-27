package br.com.drem.managebean.uniaoMb;
/**
 * @author AndreMart
 * @contacts: andremartins@outlook.com.br;andre.drem@gmail.com
 * @tel: 63 8412 1921
 * @site: drem.com.br
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.drem.entity.Cidade;
import br.com.drem.entity.Estado;
import br.com.drem.entity.Pessoa;

@ManagedBean(name="mbEstado")
public class MbEstado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Estado est;
	private Cidade cid;
	private Pessoa pessoa;
	
	public MbEstado(){
		this.cid = new Cidade();
		this.est = new Estado();
		this.pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cidade getCid() {
		return cid;
	}

	public void setCid(Cidade cid) {
		this.cid = cid;
	}
	
	public Estado getEst() {
		return est;
	}

	public void setEst(Estado est) {
		this.est = est;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((est == null) ? 0 : est.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MbEstado other = (MbEstado) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (est == null) {
			if (other.est != null)
				return false;
		} else if (!est.equals(other.est))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

	

	
	
}
