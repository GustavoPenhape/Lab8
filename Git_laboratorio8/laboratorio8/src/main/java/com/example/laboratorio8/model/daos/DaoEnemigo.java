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
        String sql = "select * from enemigos";
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
                enemigo.setObjeto_entregado(rs.getString(6));
                enemigo.setGenero(rs.getString(8));
                enemigo.setClase(rs.getString(9));
                lista.add(enemigo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
