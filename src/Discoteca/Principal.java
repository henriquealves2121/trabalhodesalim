package Discoteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {

		//==============================
		//Exemplo de inserção de 1 Genero SGBD
		//==============================
		Genero r = new Genero ("Rock");
		if(Conexaobd.inserirGenero(r)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
                
                Genero s = new Genero ("Sertanejo");
		if(Conexaobd.inserirGenero(s)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
		
                Genero re = new Genero ("Reggae");
		if(Conexaobd.inserirGenero(re)!=0) {
			System.out.println("Genero inserido sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
                
		
		 Artista m = new Artista("Zeze de Camargo");
		if(Conexaobd.inserirArtista(m)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
                
                Artista n = new Artista("Henrique e Diego");
		if(Conexaobd.inserirArtista(n)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
                
                
                   Album j = new Album("Closse", 2015);
		if(Conexaobd.inserirAlbum(j)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
		
                Musica c = new Musica ("amor",12,12);
		if(Conexaobd.inserirMusica(c)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
                
                  Musica y = new Musica ("Sem rumo",3,5);
		if(Conexaobd.inserirMusica(y)!=0) {
			System.out.println("Artista  inserida com sucesso no banco!");
		} else {
			//System.out.println("Erro na inserção!");
		}
               
		
		//==============================
		//Exemplo de listagem 
		//==============================
		ResultSet res = Conexaobd.relatorio();
		if(res!=null) {
			try {
				while(res.next()) {
                                        System.out.println("*==========*");
					System.out.print("Artista: "+res.getString("Artista"));
					System.out.print(" / Genero: "+res.getString("Genero"));
					System.out.print(" / Album: "+res.getString("Album"));
                                        System.out.print(" / Ano: "+res.getInt("Ano"));
                                        System.out.println(" / Musica: "+res.getString("Musica"));
					System.out.println("==========");
				}
			} catch (SQLException e) {
				System.out.println("\nProblema para exibir registros!");
			}
		} else {
			System.out.println("A pesquisa não retornou nenhum registro!");
		}
		
		
	}

}

