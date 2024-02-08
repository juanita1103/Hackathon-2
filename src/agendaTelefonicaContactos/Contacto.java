package agendaTelefonicaContactos;
public class Contacto {
    // Definir atributos del contacto
    private String nombre;
    private int celular;

// Creacion de constructores
    public Contacto(String nombre, int celular) {
        this.nombre = nombre;
        this.celular = celular;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.celular= 0;
    }
// Creacion getter y setter
    public String getNombre() {
        return nombre;
    }

    public int getCelular() {
        return celular;
    }

    //Eliminamos espacios y consideramos mayusculas y minusculas
    public boolean equals(Contacto contact){
        return nombre.trim().equalsIgnoreCase(contact.getNombre().trim());
    }
    @Override
    public String toString(){
        return "Nombre : " + nombre + "Celular : " + celular;
    }
}
