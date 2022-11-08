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
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Enemigo enemigo = new Enemigo();

                enemigo.setEnemigoId(rs.getInt(1));
                enemigo.setNombreEnemigo(rs.getString(2));
                enemigo.setAtaque(rs.getInt(3));
                enemigo.setExperienciaEntregada(rs.getInt(4));
                enemigo.setProbabilidadTirarObjeto(rs.getInt(5));
                enemigo.setGenero(rs.getString("genero_completo"));
                enemigo.setObjetoEntregado(rs.getString("nombre_objeto"));
                enemigo.setClase(rs.getInt(7));
                lista.add(enemigo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Enemigo buscarPorId(String idEnemigo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT * FROM mydb.enemigos WHERE idenemigos = ?";
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
                    enemigo.setExperienciaEntregada(rs.getInt(4));
                    enemigo.setProbabilidadTirarObjeto(rs.getInt(5));
                    enemigo.setGenero(rs.getString("genero_completo"));
                    enemigo.setObjetoEntregado(rs.getString("nombre_objeto"));
                    enemigo.setClase(rs.getInt(7));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return enemigo;
    }

    public void guardarEnemigos(Enemigo enemigo) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "INSERT INTO mydb.heroes (nombre ,edad, genero, clase, puntos_de_experiencia_iniciales,ataque, `nivel inicial`, pareja_id) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, enemigo.getNombreEnemigo());
            pstmt.setInt(2, enemigo.getAtaque());
            pstmt.setInt(3, enemigo.getExperienciaEntregada());
            pstmt.setInt(4, enemigo.getProbabilidadTirarObjeto());
            pstmt.setString(5, enemigo.getGenero());
            pstmt.setString(6, enemigo.getObjetoEntregado());
            pstmt.setInt(7, enemigo.getClase());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public void borrar(String idEnemigo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "DELETE from mydb.enemigos WHERE idEnemigos= ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, idEnemigo);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizarEnemigos(int IdEnemigo1, String nombre, int ataque, int experiencia, int probabilidad, String genero, String objeto, int clase) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE mydb.heroes SET nombre = ?, edad = ?, genero = ?, clase = ?, puntos_de_experiencia_iniciales = ?,ataque = ?, `nivel inicial` = ?, pareja_id = ? WHERE idHeroes = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(8, IdEnemigo1);
            pstmt.setString(1, nombre);
            pstmt.setInt(2, ataque);
            pstmt.setInt(3, experiencia);
            pstmt.setInt(4, probabilidad);
            pstmt.setString(5, genero);
            pstmt.setString(6, objeto);
            pstmt.setInt(7, clase);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarParcial(int IdEnemigo1, String nombre, int ataque, int experiencia, int probabilidad, String genero, String objeto, int clase) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE mydb.heroes SET  nombre = ?, edad = ?, genero = ?, clase = ?  WHERE idheroes = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(8, IdEnemigo1);
            pstmt.setString(1, nombre);
            pstmt.setInt(2, ataque);
            pstmt.setInt(3, experiencia);
            pstmt.setInt(4, probabilidad);
            pstmt.setString(5, genero);
            pstmt.setString(6, objeto);
            pstmt.setInt(7, clase);
            pstmt.executeUpdate();
            //    pstmt.setString(1, jobTitle);
            //    pstmt.setInt(2, minSalary);
            //    pstmt.setString(3, jobId);
            //    pstmt.executeUpdate();

        }

    }
}
