/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

public class Persona {

    static Persona crear(int i, String text, String text0, String text1, String text2, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    private int id = 0;
    private String  documento, 
                    nombre, 
                    telefono, 
                    email,
                    apellido,
                    foto;

    public Persona(int id, String documento, String nombre, String telefono, String email,String apellido, String foto) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.apellido = apellido;
        this.foto = foto;
        
    }

    public static Persona crear(int id, String documento, String nombre, String telefono, String email,String apellido, String foto) {
        return new Persona(id, documento, nombre, telefono, email,apellido, foto);
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento(){
        return this.documento;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }
    public String getApellido() {
        return this.apellido;
    }

    public String getFoto() {
        return this.foto;
    }

    public int getId() {
        return this.id;
    }
}

