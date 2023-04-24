public class Persona implements Comparable<Persona> {
    private int id;
    private String nombreCompleto;
    private int edad;
    private int prioridad;
    private int amigos;

    public Persona(int id, String nombreCompleto, int edad, int prioridad, int amigos) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }

    @Override
    public int compareTo(Persona o) {
        if (prioridad > o.prioridad) {
            return 1;
        } else if (prioridad < o.prioridad) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
