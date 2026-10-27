package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JugadorService {

    // Leer
    public static ArrayList<Jugador> leerTodo () {

        ArrayList<Jugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM Xogador";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()){
                Jugador j = new Jugador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("posicion"),
                        rs.getInt("anonacemento"),
                        rs.getString("descricion")
                );
                jugadores.add(j);
            };

            return jugadores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Jugador leerUno (int id) {

        ArrayList<Jugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM Xogador WHERE id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Jugador j = new Jugador(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("posicion"),
                            rs.getInt("anonacemento"),
                            rs.getString("descricion")
                    );
                    jugadores.add(j);
                }
            }

            return jugadores.get(0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertar(Jugador jugador) {

        String sql = "INSERT INTO Xogador (Nome, Posicion, AnoNacemento, Descricion) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getPosicion());
            ps.setInt(3, jugador.getAño());
            ps.setString(4, jugador.getDescricion());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(int año, int id) {

        String sql = "UPDATE Xogador SET AnoNacemento =? WHERE id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, año);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAll() {

        String sql = "DELETE FROM Xogador";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql))
        {

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
