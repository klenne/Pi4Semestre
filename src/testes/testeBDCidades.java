package testes;

import java.sql.SQLException;
import java.util.Scanner;

import model.bean.CidadeEstado;

import model.dao.CidadesEstadoDAO;

public class testeBDCidades {

	public static void main(String[] args) throws SQLException{
		Scanner s= new Scanner(System.in);
		CidadesEstadoDAO ce = new CidadesEstadoDAO();
		for (CidadeEstado c : ce.buscaUF()) {

			System.out.println(c.getUf());

		}
	
		System.out.println("Digite sua uf: ");
		String uf=s.next();
		uf=uf.toUpperCase();
		for (CidadeEstado c : ce.buscaCidade(uf)) {

			System.out.println(c.getCidade());

		}
	}
}
