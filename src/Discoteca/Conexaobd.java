package Discoteca;

import java.sql.*;

public class Conexaobd {
	
	//Método para Conectar ao Banco de Dados Local chamado 'cadastro', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecamusical", "root", "");
			return(c);
		} catch (ClassNotFoundException e) {
			System.out.println("Problema na configuração do Driver do MySQL!");
		} catch (SQLException e) {
			System.out.println("Problema na conexão com o banco de dados!");
		}
		return(null);
	}
	
	//Retorna o relatório contendo todas as Pessoa do Banco
	public static ResultSet relatorio() {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery("SELECT artista.nome as Artista,genero.nome as genero,album.nome as Album,album.ano,musica.nome as Musica from artista,genero,album,musica where genero.id=artista.genero_id && artista.id=album.artista_id && album.id=musica.album_id group by album.id;"));
		} catch (SQLException e) {
			//System.out.println("Problema na consulta à tabela genero!");
		}
		return(null);
	}
	
        
	//Método para inserir no banco uma Pessoa passada como parâmetro
	public static int inserirGenero(Genero g) {
		String insercao = "INSERT INTO `genero` (`nome`) VALUES ('"+g.getNome()+"');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			//System.out.println("Problema na inserção da genero!, ou ja existe");
		}
		return(0);
	}
        
	public static int inserirArtista(Artista a) {
		String insercao = "INSERT INTO `artista` (`nome`,genero_id ) VALUES ('"+a.getNome()+"',1);";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			//System.out.println("Problema na inserção da artista!, ou ja existe");
		}
		return(0);
	}
        
        
        
        public static int inserirAlbum(Album j) {
		String insercao = "INSERT INTO `album` (`nome`, ano, artista_id ) VALUES ('"+j.getNome()+"', '12 ','2');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			//System.out.println("Problema na inserção da artista!");
		}
		return(0);
	}
	
        
         
        public static int inserirMusica(Musica l) {
		String insercao = "INSERT INTO `musica` (`nome`, nota, duracao, album_id ) VALUES ('"+l.getNome()+"','5','3','1');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			//System.out.println("Problema na inserção da Musica!, ou ja existe");
		}
		return(0);
	}
        
    
	//Método para Atualizar os campos no banco uma Pessoa passada como parâmetro, buscando-a pelo nome atual!!!
	public static int atualizar(Genero g, String n) {
		String atualizacao = "UPDATE `genero` SET `nome` = '"+g.getNome()+"' WHERE `nome` = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			//System.out.println("Problema na atualização da genero!");
		}
		return(0);
	}

    
	
}

