package com.example.laboratorio8.model.daos;

import com.example.laboratorio8.model.beans.Heroe;

import java.sql.*;
import java.util.ArrayList;

public class DaoHeroe {
    public ArrayList<Heroe> lista() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        ArrayList<Heroe> lista = new ArrayList<>();
        String sql = "select * from heroes";
        try (Connection connection = DriverManager.getConnection(url, "root", "salchipapa");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Heroe heroe = new Heroe();
                heroe.setHeroeId(rs.getInt(1));
                heroe.setNombre(rs.getString(2));
                heroe.setEdad(rs.getInt(3));
                heroe.setGenero(rs.getString(4));
                heroe.setClase(rs.getString(5));
                heroe.setPuntos_experiencia(rs.getInt(6));
                heroe.setAtaque(rs.getInt(7));
                heroe.setNivel_inicial(rs.getInt(8));
                heroe.setPareja_id(rs.getInt(9));
                lista.add(heroe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Heroe buscarPorId(String idHeroe) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT * FROM mydb.heroes WHERE idheroes = ?";
        Heroe heroes = null;
        try (Connection conn = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idHeroe);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    heroes = new Heroe();

                    heroes.setHeroeId(rs.getInt(1));
                    heroes.setNombre(rs.getString(2));
                    heroes.setEdad(rs.getInt(3));
                    heroes.setGenero(rs.getString(4));
                    heroes.setClase(rs.getString(5));
                    heroes.setPuntos_experiencia(rs.getInt(6));
                    heroes.setAtaque(rs.getInt(7));
                    heroes.setNivel_inicial(rs.getInt(8));
                    heroes.setPareja_id(rs.getInt(9));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return heroes;
    }
    public void guardarHeroes(Heroe heroes){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "INSERT INTO mydb.heroes (nombre ,edad, genero, clase, puntos_de_experiencia_iniciales,ataque, `nivel inicial`, pareja_id) VALUES (?,?,?,?,?,?,?,?)" ;

        try(Connection connection = DriverManager.getConnection(url,"root","123456");
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1,heroes.getNombre());
            pstmt.setString(2,Integer.toString(heroes.getEdad()));
            pstmt.setString(3,heroes.getGenero());
            pstmt.setString(4,heroes.getClase());
            pstmt.setString(5,Integer.toString(heroes.getPuntos_experiencia()));
            pstmt.setString(6,Integer.toString(heroes.getAtaque()));
            pstmt.setString(7,Integer.toString(heroes.getNivel_inicial()));
            pstmt.setString(8,Integer.toString(heroes.getPareja_id()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void actualizarHeroes(String IdHeroes, String nombre1,String edad1,String genero1,String nivel1,String clase1,String ataque1,String pareja1,String puntos_exp1) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "UPDATE mydb.heroes SET nombre = ?, edad = ?, genero = ?, clase = ?, puntos_de_experiencia_iniciales = ?,ataque = ?, `nivel inicial` = ?, pareja_id = ? WHERE idHeroes = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(9, IdHeroes);
            pstmt.setString(1, nombre1);
            pstmt.setString(2, edad1);
            pstmt.setString(3, genero1);
            pstmt.setString(4, clase1);
            pstmt.setString(5, puntos_exp1);
            pstmt.setString(6, ataque1);
            pstmt.setString(7, nivel1);
            pstmt.setString(8, pareja1);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrar(String idHeroe){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "DELETE from mydb.heroes WHERE idHeroes = ?";

        try(Connection connection = DriverManager.getConnection(url,"root","123456");
            PreparedStatement pstmt=connection.prepareStatement(sql))
        {

            pstmt.setString(1,idHeroe);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void actualizarParcial(String IdHeroes, String nombre2, String edad2, String genero2, String clase2) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "UPDATE mydb.heroe SET  nombre = ?, edad = ?, genero = ?, clase = ?  WHERE idheroes = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(5, IdHeroes);
            pstmt.setString(1, nombre2);
            pstmt.setString(2, edad2);
            pstmt.setString(3, genero2);
            pstmt.setString(4, clase2);
            pstmt.executeUpdate();
        //    pstmt.setString(1, jobTitle);
        //    pstmt.setInt(2, minSalary);
            //    pstmt.setString(3, jobId);
        //    pstmt.executeUpdate();
        }
    }


}
