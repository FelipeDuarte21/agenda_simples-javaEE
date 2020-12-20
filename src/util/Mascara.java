package util;

public class Mascara {
	
	public static String mascaraCelular(String celular) {
		
		String celularMascarado = "";
		String[] partesMascara = {"(",")"," ","-"};
		
		for(int i=0; i < celular.length(); i++) {
			
			if((i==0) || (i==2)) {
				celularMascarado += partesMascara[i];
			}
			
			celularMascarado += celular.charAt(i);
			
			if(i == 1) celularMascarado += partesMascara[1];
			if(i == 6) celularMascarado += partesMascara[3];
		}
		
		return celularMascarado;
	}
	
	public static String mascaraTelefone(String telefone) {
		
		String telefoneMascarado = "";
		String[] partesMascara = {"(",")"," ","-"};
		
		for(int i=0; i < telefone.length(); i++) {
			
			if((i==0) || (i==2)) {
				telefoneMascarado += partesMascara[i];
			}
			
			telefoneMascarado += telefone.charAt(i);
			
			if(i == 1) telefoneMascarado += partesMascara[1];
			if(i == 5) telefoneMascarado += partesMascara[3];
		}
		
		return telefoneMascarado;
	}
	
	public static String retiraMascaraCelularETelefone(String numero) {
		
		numero = numero.replaceAll("\\(","");
		numero = numero.replaceAll("\\)","");
		numero = numero.replaceAll("\s","");
		numero = numero.replaceAll("-","");
	
		return numero;
	}
	
}
