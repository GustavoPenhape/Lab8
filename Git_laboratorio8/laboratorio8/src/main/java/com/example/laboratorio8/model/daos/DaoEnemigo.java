package com.example.laboratorio8.model.daos;

import com.example.laboratorio8.model.beans.Enemigo;

import java.sql.*;
import java.util.ArrayList;

public class DaoEnemigo {
    public ArrayList<Enemigo> lista() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        ArrayList<Enemigo> lista = new ArrayList<>();
        String sql = "SELECT *, \n" +
                "case when genero = \"M\" then \"masculino\"\n" +
                "when genero = \"F\" then \"femenino\" \n" +
                "when genero = \"O\" then \"otros\"\n" +
                "else \"-\"\n" +
                "end as genero_completo\n" +
                "FROM mydb.enemigos\n" +
                "INNER JOIN mydb.catalogo_objetos\n" +
                "ON enemigos.objeto_id = catalogo_objetos.idobjeto\n" +
                "INNER JOIN mydb.submenu_clases\n" +
                "ON enemigos.clase_id = submenu_clases.clase_idclase\n" +
                ";";
        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Enemigo enemigo = new Enemigo();
                enemigo.setEnemigoId(rs.getInt(1));
                enemigo.setNombreEnemigo(rs.getString(2));
                enemigo.setAtaque(rs.getInt(3));
                enemigo.setExperienciaEntregada(rs.getInt(4));
                enemigo.setProbabilidadTirarObjeto(rs.getInt(5));
                enemigo.setGenero(rs.getString("genero"));
                enemigo.setObjeto_entregado(rs.getString(7));
                enemigo.setClase(rs.getString(8));
                lista.add(enemigo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public Enemigo submenu(String idEnemigo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT *, \n" +
                "case when genero = \"M\" then \"masculino\"\n" +
                "when genero = \"F\" then \"femenino\" \n" +
                "when genero = \"O\" then \"otros\"\n" +
                "else \"-\"\n" +
                "end as genero_completo\n" +
                "FROM mydb.enemigos\n" +
                "INNER JOIN mydb.catalogo_objetos\n" +
                "ON enemigos.objeto_id = catalogo_objetos.idobjeto\n" +
                "INNER JOIN mydb.submenu_clases\n" +
                "ON enemigos.clase_id = submenu_clases.clase_idclase\n" +
                ";";
        Enemigo enemigo = null;
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idEnemigo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    enemigo = new Enemigo();

                    enemigo.setEnemigoId(rs.getInt(1));
                    enemigo.setNombreEnemigo(rs.getString(2));
                    enemigo.setAtaque(rs.getInt(3));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return enemigo;
    }
    public void borrar(String idEnemigo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "DELETE from mydb.enemigos WHERE idEnemigos= ?";

        try(Connection connection = DriverManager.getConnection(url,"root","root");
            PreparedStatement pstmt=connection.prepareStatement(sql))
        {

            pstmt.setString(1,idEnemigo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
