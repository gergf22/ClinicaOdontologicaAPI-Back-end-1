package model;

public class Odontologo {

    private int id;
    private String matricula;
    private String nombre;
    private String apellido;


    public Odontologo(int id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return " Matricula: " + getMatricula() +
                " Nombre: " + getNombre() +
                " Apellido: " + getApellido();
    }
}
