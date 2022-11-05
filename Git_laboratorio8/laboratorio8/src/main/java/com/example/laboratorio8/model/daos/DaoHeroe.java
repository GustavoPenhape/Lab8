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
        try (Connection connection = DriverManager.getConnection(url, "root", "123456");
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
}