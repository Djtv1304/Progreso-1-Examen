import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedSocial extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panelPrincipal;
    private JTextField textFieldID;
    private JTextField textFieldNombre;
    private JTextField textFieldEdad;
    private JTextField textFieldAmigos;
    private JTextField textFieldPrioridad;
    private JButton agregarParticipanteButton;
    private JTextArea textAreaBuscarParticipante;
    private JButton buscarPorIDButton;
    private JButton MayorPrioridadButton;
    private JComboBox comboBox;
    private JButton insertarParticipantesPredeterminados6Button;
    private JButton activarSiguienteParticipanteEnButton;
    private JButton activarTodosLosParticipantesButton;
    private JButton eliminarParticipanteActivoDeButton;
    private JButton eliminarATodosLosButton;
    private JButton restaurarUltimoParticipanteEliminadoButton;
    private JButton restaurarATodosLosButton;
    private JTextArea textAreaParticipantesActivos;
    private JButton mostrarParticipantesActivosButton;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public RedSocial() {

    SocialNetwork SocialNet = new SocialNetwork();

    insertarParticipantesPredeterminados6Button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Persona nueva1 = new Persona(1,"Persona1",25,1,20);
            Persona nueva2 = new Persona(2,"Persona2",15,2,15);
            Persona nueva3 = new Persona(3,"Persona3",20,3,10);
            Persona nueva4 = new Persona(4,"Persona4",22,4,5);
            Persona nueva5 = new Persona(5,"Persona5",30,5,3);
            Persona nueva6 = new Persona(6,"Persona6",29,6,1);
            
            SocialNet.AgregarUnaPersonaEspera(nueva1);
            SocialNet.AgregarUnaPersonaEspera(nueva2);
            SocialNet.AgregarUnaPersonaEspera(nueva3);
            SocialNet.AgregarUnaPersonaEspera(nueva4);
            SocialNet.AgregarUnaPersonaEspera(nueva5);
            SocialNet.AgregarUnaPersonaEspera(nueva6);
        }
    });

        agregarParticipanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(textFieldID.getText());
                int Edad = Integer.parseInt(textFieldEdad.getText());
                int Prioridad = Integer.parseInt(textFieldPrioridad.getText());
                int Amigos = Integer.parseInt(textFieldAmigos.getText());

                Persona nueva = new Persona(ID,textFieldNombre.getText(),Edad,Prioridad,Amigos);

                SocialNet.AgregarUnaPersonaEspera(nueva);
            }
        });

        buscarPorIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingresarID = JOptionPane.showInputDialog("Ingrese el ID de la persona a buscar");
                int idBusqueda = Integer.parseInt(ingresarID);

                int opcion = comboBox.getSelectedIndex();

                if (opcion == 0) {
                    Persona buscado = SocialNet.buscarPersonaEspera(idBusqueda);
                    textAreaBuscarParticipante.setText("La persona en espera encontrada contiene la siguiente informacion:\n" +
                            "Nombre: " + buscado.getNombreCompleto() +"\n"+
                            "ID: "+ buscado.getId() +"\n"+
                            "Edad: " + buscado.getEdad() +"\n"+
                            "Amigos: "+ buscado.getAmigos() +"\n"+
                            "Prioridad: "+ buscado.getPrioridad());
                }else {
                    Persona buscado = SocialNet.buscarPersonaActiva(idBusqueda);
                    textAreaBuscarParticipante.setText("La persona activa encontrada contiene la siguiente informacion:\n" +
                            "Nombre: " + buscado.getNombreCompleto() +"\n"+
                            "ID: "+ buscado.getId() +"\n"+
                            "Edad: " + buscado.getEdad() +"\n"+
                            "Amigos: "+ buscado.getAmigos() +"\n"+
                            "Prioridad: "+ buscado.getPrioridad());
                }

            }
        });

        MayorPrioridadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Los activos que tienen mayor prioridad son:\n");
                for (Persona x: SocialNet.getPersonaActivo()){
                    if (x.getPrioridad() > 50) {
                        sb.append(x.getNombreCompleto()+" tiene una prioridad de: "+x.getPrioridad());
                    }
                }
                textAreaBuscarParticipante.setText(sb.toString());
            }
        });

        mostrarParticipantesActivosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Los participantes activos son:\n");
                for (Persona x: SocialNet.getPersonaActivo()){
                    sb.append(
                            "Nombre: " + x.getNombreCompleto() +"\n"+
                            "ID: "+ x.getId() +"\n"+
                            "Edad: " + x.getEdad() +"\n"+
                            "Amigos: "+ x.getAmigos() +"\n"+
                            "Prioridad: "+ x.getPrioridad() +"\n");
                }
                textAreaParticipantesActivos.setText(sb.toString());

            }
        });

        activarSiguienteParticipanteEnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.AgregarUnaPersonaActiva();
            }
        });

        activarTodosLosParticipantesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.AgregarTodosActivos();
            }
        });

        eliminarParticipanteActivoDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.AgregarUnaPersonaEliminada();
            }
        });

        eliminarATodosLosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.EliminarTodosActivos();
            }
        });

        restaurarUltimoParticipanteEliminadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.restaurarUltimoEliminado();
            }
        });

        restaurarATodosLosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocialNet.restaurarEliminados();
            }
        });
    }
}
