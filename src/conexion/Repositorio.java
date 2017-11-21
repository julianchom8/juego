/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import DBManager.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Repositorio {
	
    private static DBManager database = new DBManager();

    public static void crear (Persona persona) {
        try {
            String query = "INSERT INTO personas (documento, nombre, telefono, email, foto) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, persona.getDocumento());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getTelefono());
            sentenciaP.setString(4, persona.getEmail());
            sentenciaP.setString(5, persona.getFoto());
            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void editar (Persona persona) {
        try {
            String query = "UPDATE personas SET documento = ?, nombre = ?, telefono = ?, email = ?, foto = ? WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, persona.getDocumento());
            sentenciaP.setString(2, persona.getNombre());
            sentenciaP.setString(3, persona.getTelefono());
            sentenciaP.setString(4, persona.getEmail());
            sentenciaP.setString(5, persona.getFoto());
            sentenciaP.setString(6, Integer.toString(persona.getId()));

            sentenciaP.executeUpdate();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminar (Persona persona) {
        try {
            String query = "DELETE FROM personas WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(persona.getId()));

            sentenciaP.execute();
            sentenciaP.close();
            database.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Persona obtener(int id) {
        try {
            String query = "SELECT * FROM personas WHERE id = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, Integer.toString(id));

            ResultSet resultado = sentenciaP.executeQuery();

            sentenciaP.close();
            database.close();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getString("documento"), resultado.getString("nombre"), resultado.getString("telefono"), resultado.getString("email"), resultado.getString("foto"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    
    public static Persona buscar(String documento) {
        try {
            String query = "SELECT * FROM personas WHERE documento = ?;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            sentenciaP.setString(1, documento);

            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                return Persona.crear(resultado.getInt("id"), resultado.getString("documento"), resultado.getString("nombre"), resultado.getString("telefono"), resultado.getString("email"), resultado.getString("foto"));
            }
            
            sentenciaP.close();
            database.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static ArrayList<Persona> obtenerTodos() {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        try {
            String query = "SELECT * FROM personas;";
            PreparedStatement sentenciaP = database.open().prepareStatement(query);
            ResultSet resultado = sentenciaP.executeQuery();

            while (resultado.next()) {
                personas.add(Persona.crear(resultado.getInt("id"), resultado.getString("documento"), resultado.getString("nombre"), resultado.getString("telefono"), resultado.getString("email"), resultado.getString("foto")));
            }

            sentenciaP.close();
            database.close();

            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return personas;
    }
}

