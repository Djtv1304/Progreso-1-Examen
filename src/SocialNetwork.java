import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SocialNetwork {
    //almacenar participantes en espera de ser activados.
    Queue<Persona> Persona;
    //almacenar participantes basándose en su prioridad y ordenarlos según su nivel de actividad
    Queue<Persona> PersonaActivo;
    //para almacenar participantes eliminados recientemente.
    Stack<Persona> StackPersona;

    public SocialNetwork() {
        Persona = new LinkedList<>();
        PersonaActivo = new PriorityQueue<>();
        StackPersona = new Stack<>();
    }

    public Queue<Persona> getPersona() {
        return Persona;
    }

    public void setPersona(Queue<Persona> persona) {
        Persona = persona;
    }

    public Queue<Persona> getPersonaActivo() {
        return PersonaActivo;
    }

    public void setPersonaActivo(Queue<Persona> personaActivo) {
        PersonaActivo = personaActivo;
    }

    public Stack<Persona> getStackPersona() {
        return StackPersona;
    }

    public void setStackPersona(Stack<Persona> stackPersona) {
        StackPersona = stackPersona;
    }

    public void AgregarUnaPersonaEspera(Persona pNueva) {
        Persona.add(pNueva);
    }
    public void AgregarUnaPersonaActiva() {
        PersonaActivo.add(Persona.remove()); //saco de espera
    }
    public void AgregarTodosActivos() {
        for (Persona x: Persona) {
            PersonaActivo.add(x); //Agrego todos los de espera en activos
        }
        Persona.clear();
    }
    public void AgregarUnaPersonaEliminada() {
        StackPersona.add(PersonaActivo.remove()); //saco de activa
    }
    public void EliminarTodosActivos() {
        for (Persona x: PersonaActivo) {
            StackPersona.add(x); //Agrego todos los activos en el stack de eliniados
        }
        PersonaActivo.clear();
    }
    public void restaurarUltimoEliminado() {
        PersonaActivo.add(StackPersona.pop()); //saco eliminado y le hago activo
    }
    public void restaurarEliminados() {
        for (Persona x: StackPersona) {
            PersonaActivo.add(x);
        }
        StackPersona.clear();
    }

    public Persona buscarPersonaEspera(int idBuscar){
        for (Persona x : Persona) {
            if (idBuscar == x.getId()) {
                return x;
            }
        }
        return null;
    }

    public Persona buscarPersonaActiva(int idBuscar){
        for (Persona x : PersonaActivo) {
            if (idBuscar == x.getId()) {
                return x;
            }
        }
        return null;
    }
}
