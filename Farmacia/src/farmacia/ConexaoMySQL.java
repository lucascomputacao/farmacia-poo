/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author lucas
 */
//import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {

    private Connection conn;
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String ip = "localhost:3306";//onde o mysql será executado
    private String bd = "BD_FARMACIA"; //database
    private String user = "root";
    private String password = "";
    // String de rotina (se repete em todas as conexões) x  para conexão com o MySQL  
    private String MySQL = "jdbc:mysql://";
    private boolean connected = false;

    public ConexaoMySQL(String ip) {

        this.ip = ip;

    }

    public ConexaoMySQL() {
        try {
            // Estrutura o comando para estabelecer conexão com o MySQL  
            // jdbc:mysql://Ip_servidor/Banco_de_dados(=oravital)  
            String dbMySQL = MySQL + ip + "/" + bd;

            // Carrega a classe para estabelecimento de conexão com o  
            // MySQL  
            Class.forName(DRIVER);

            // Faz a conexão com o Banco MySQL 1  
            //conn = DriverManager.getConnection(dbMySQL, USER, PASSWD);
            conn = DriverManager.getConnection(dbMySQL, user, password);
            // Atualiza o Auto Commit para false  
            conn.setAutoCommit(false);
            // Atualiz o status da conexão para tru -> conectado  
            this.connected = true;

        } catch (ClassNotFoundException ex) { // Erro de classe nao  
            // encontrada  
            System.out.println("Driver JDBC Não encontrado");
        } catch (SQLException ex1) { // Erro de SQL  
            System.out.println("Erro de SQL");
        }
    }

    public void desconectar() {
        try {
            // Carrega a classe para estabelecimento de conexão com o  
            // MySQL  
            Class.forName(DRIVER);
            // Seta conexão para nula  
            conn = null;
            // Atualiza valor para nao conectado  
            this.connected = false;

        } catch (ClassNotFoundException ex) { // Erro de classe nao encontrada  
            System.out.println("Driver JDBC Não encontrado");
        } catch (Exception ex1) { // Erro geral  
            System.out.println("Falha ao desconectar no banco" + ex1);
        }
    }

//    Metodo para atualizar o banco de dados  
    public boolean atualizar(String SQL) {
        try {
            // Se a conexão for nula  
            if (conn != null) {
                // Obrigatório para inclusão e consulta  
                Statement stmt = conn.createStatement();

                // Buffer para SQL  
                StringBuilder sql = new StringBuilder("");

                // Envia requisição para o Banco  
                sql.append(SQL);
                // Executa a operação no banco  
                stmt.execute(sql.toString());
                // Comita a operação  
                conn.commit();
                // Retorna como realizado com sucesso  
                return true;
            } else { // Erro ao tentar conectar sem conexão estabelecida  
                System.out.println("Atualizacao - Tentou sem estar aberto : ");
                return false;
            }
        } catch (SQLException ex) { // Erro de SQL  
            System.out.println("Erro de SQL \n Conexao sendo fechada");
            conn = null;
            return false;
        }
    }

    // Metodo para executar uma procura no bando de dados, e retorna um  
    // ResultSet  
    public ResultSet Procurar(String consulta) {
        // ResultSet de retorno das consultas  
        ResultSet ConjuntoResultados = null;
        // Statement para conexão  
        Statement statement = null;
        try {
            // Se a conexão nao for nula  
            if (conn != null) {
                // Cria statement com a conexão  
                statement = conn.createStatement();
                // Executa busca no banco  
                ConjuntoResultados = statement.executeQuery(consulta);
            } else // erro caso tente conectar sem o banco estar aberto  
            {
                System.out.println(" Procura - Tentou sem estar aberto");
            }
        } catch (SQLException e) { // Erro de SQL  
            statement = null;
            conn = null;

        }
        return ConjuntoResultados;
    }

    // Metodo que retorna o status da conexão  
    public boolean conectado() {
        return this.connected;
    }
    
    public boolean inserir(String SQL) {
        try {
            // Se a conexão for nula  
            if (conn != null) {
                // Obrigatório para inclusão e consulta  
                Statement stmt = conn.createStatement();

                // Buffer para SQL  
                StringBuilder sql = new StringBuilder("");

                // Envia requisição para o Banco  
                sql.append(SQL);
                // Executa a operação no banco  
                stmt.execute(sql.toString());
                // Comita a operação  
                conn.commit();
                // Retorna como realizado com sucesso  
                return true;
            } else { // Erro ao tentar conectar sem conexão estabelecida  
                System.out.println("Atualizacao - Tentou sem estar aberto : ");
                return false;
            }
        } catch (SQLException ex) { // Erro de SQL  
            System.out.println("Erro de SQL \n Conexao sendo fechada");
            conn = null;
            return false;
        }
    }
    
   
}
