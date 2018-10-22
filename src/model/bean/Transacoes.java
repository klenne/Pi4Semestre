package model.bean;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transacoes {
	private int codTransacao,codProduto;
	private String data;
	private String status, usuarioInteressado;
	public int getCodTransacao() {
		return codTransacao;
	}
	public void setCodTransacao(int codTransacao) {
		this.codTransacao = codTransacao;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String  getData() {
		return data;
	}
	public void setData() {
	     LocalDate date;
	      date = LocalDate.now();
	      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	      String dataFormatada = date.format(formatter);
	      data=dataFormatada;
	
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsuarioInteressado() {
		return usuarioInteressado;
	}
	public void setUsuarioInteressado(String usuarioInteressado) {
		this.usuarioInteressado = usuarioInteressado;
	}
	
	

}
