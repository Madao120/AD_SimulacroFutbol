package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MercadoFichajesService {
    public static ArrayList<MercadoFichajes> leerTodo () {

        ArrayList<MercadoFichajes> lista = new ArrayList<>();
        String sql = "SELECT * FROM MercadoFichajes";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                MercadoFichajes m = new MercadoFichajes(
                        rs.getInt("id"),
                        rs.getInt("idXogador"),
                        rs.getDouble("PrezoBase"),
                        rs.getDouble("PrezoClausula"),
                        rs.getInt("PorcentaxeComision")
                );
                lista.add(m);
            };

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MercadoFichajes leerUno (int id) {

        ArrayList<MercadoFichajes> lista = new ArrayList<>();
        String sql = "SELECT * FROM MercadoFichajes WHERE id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MercadoFichajes m = new MercadoFichajes(
                            rs.getInt("id"),
                            rs.getInt("idXogador"),
                            rs.getDouble("PrezoBase"),
                            rs.getDouble("PrezoClausula"),
                            rs.getInt("PorcentaxeComision")
                    );
                    lista.add(m);
                }
            }

            return lista.get(0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertar(MercadoFichajes mercado) {

        String sql = "INSERT INTO MercadoFichajes (idXogador, PrezoBase, PrezoClausula, PorcentaxeComision) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, mercado.getIdXogador());
            ps.setDouble(2, mercado.getPrecioBase());
            ps.setDouble(3, mercado.getPrecioClausula());
            ps.setInt(4, mercado.getPorcentajeComision());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateComision(int comision, int id) {

        String sql = "UPDATE MercadoFichajes SET (PorcentaxeComision = PorcentaxeComision + ?, PrecioClausula = PrecioClausula * (1-?)) WHERE id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, comision);
            ps.setInt(2, comision);
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAll() {

        String sql = "DELETE FROM MercadoFichajes";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
