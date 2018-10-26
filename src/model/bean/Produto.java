package model.bean;

public class Produto {
private String tipo,titulo,console,valor,status,foto,email;

private int codProduto;

public int getCodProduto() {
	return codProduto;
}

public void setCodProduto(int codProduto) {
	this.codProduto = codProduto;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getConsole() {
	return console;
}

public void setConsole(String console) {
	this.console = console;
}

public String getValor() {
	return valor;
}

public void setValor(String valor) {
	this.valor = valor;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
