
package br.com.brunoduarte.livro.dao;

import br.com.brunoduarte.livro.bd.LivroBD;
import br.com.brunoduarte.livro.entidade.Livro;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LivroDAO {
    
    
    private static final String INSERIR_SQL = "INSERT INTO livros "
                                        + "(Titulo,Editora,ISBN) "
                                        + "VALUES ('%s','%s','%s')";
    
    private static final String ALTERAR_SQL = "UPDATE livros " 
                                       +"SET Titulo = '%s' , Editora = '%s', ISBN = '%s' "
                                         + "WHERE Id = %d";

    private static final String REMOVER_SQL = "DELETE FROM livros where id = %d";
    
    private static final String SELECIONAR_SQL ="SELECT * from livros ";
    
    
    
    public static void inserir(Livro livro){
        String sql = String.format(INSERIR_SQL,
            livro.getTitulo(),
            livro.getEditora(),
            livro.getIsbn());
        LivroBD.execute(sql, true);
    
    }
    
    public static void alterar (Livro livro){
        String sql = String.format(ALTERAR_SQL, 
                 livro.getTitulo(),
            livro.getEditora(),
            livro.getIsbn(),
        livro.getId());
    LivroBD.execute(sql, true);
     
    }
    
    
    public static void remover (Livro livro){
        String sql = String.format(REMOVER_SQL, 
                livro.getId());
        LivroBD.execute(sql, true);
    }
    
    public static List<Livro> selecionarTodos(){
    List<Livro> lista = new ArrayList<>();
    Connection con = LivroBD.conectar();
    
    try{
        ResultSet rs = con.createStatement()
                .executeQuery(SELECIONAR_SQL);
        while (rs.next()){
            Livro obj = new Livro();
        obj.setId(rs.getInt("Id"));
        obj.setTitulo( rs.getString("Titulo"));
        obj.setEditora(rs.getString("Editora"));
        obj.setIsbn(rs.getString("ISBN"));
        lista.add(obj);
        
        }
        LivroBD.desconectar(con);
    
    
    } catch (SQLException e){
        System.out.println(e.getLocalizedMessage());
        System.exit(1);
    
    }
    
    return lista;
   
    
    
}
    
}