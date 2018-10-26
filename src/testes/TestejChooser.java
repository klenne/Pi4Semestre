package testes;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.bean.Usuario;
import model.dao.UsuarioDAO;
import utilitarios.ImageEncoder;

public class TestejChooser {

	public static void main(String args[]) throws HeadlessException, IOException {

		Usuario u = new Usuario();
	

		ImageEncoder ie = new ImageEncoder();
		u.setFoto(ie.lerImagem());
		JOptionPane.showMessageDialog(null, ie.ConverterImagem(u));

	}
}
