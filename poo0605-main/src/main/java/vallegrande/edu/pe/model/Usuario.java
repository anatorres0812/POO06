package vallegrande.edu.pe.model;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String asunto;

    // CONSTRUCTOR VACÍO
    public Usuario() {
    }

    // CONSTRUCTOR COMPLETO
    public Usuario(
            int id,
            String nombre,
            String correo,
            String telefono,
            String asunto
    ) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.asunto = asunto;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}