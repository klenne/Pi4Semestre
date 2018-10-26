package testes;

import utilitarios.TextFormatter;

public class TesteTextFormatter {
	public static void main(String[] args) {
		TextFormatter tf=new TextFormatter();
		System.out.println(tf.verificaEspacosEmbranco(""));
		System.out.println(tf.verificaEspacosEmbranco("teste"));
	}

}
