package model.bean;


public class Transacoes {
	private int codTransacao,codAnuncio,codUsuario;
	private String data, status;
	public int getCodTransacao() {
		return codTransacao;
	}
	public void setCodTransacao(int codTransacao) {
		this.codTransacao = codTransacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCodAnuncio() {
		return codAnuncio;
	}
	public void setCodAnuncio(int codAnuncio) {
		this.codAnuncio = codAnuncio;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


	

}
