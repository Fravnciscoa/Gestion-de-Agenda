//Bibliotecas
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private String nombreAgenda;
    private HashMap<LocalDate, ArrayList<Evento>> eventos;

    //Constructores
    public Agenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        this.eventos = new HashMap<>();
    }

    public HashMap<LocalDate, ArrayList<Evento>> getEventos() {
        return eventos;
    }

    public void setEventos(HashMap<LocalDate, ArrayList<Evento>> eventos) {
        this.eventos = eventos;
    }

    //Método para agregar evento a un arrayList dentro de un HashMap.
    public void agregarEvento(String fecha, Evento evento) {
        LocalDate dia = LocalDate.parse(fecha);  //'Casting'
        //
        if (!eventos.containsKey(dia)) {
            eventos.put(dia, new ArrayList<>());
        }
        eventos.get(dia).add(evento);
    }

    public void mostrarEventos(String fecha) {
        LocalDate dia = LocalDate.parse(fecha);
        ArrayList<Evento> eventos1 = eventos.getOrDefault(dia, new ArrayList<>());
        if (eventos1.isEmpty()) {
            System.out.println("No hay eventos en esta fecha: " + fecha);
        } else {
            System.out.println("Eventos en " + fecha + ":");
            for (Evento evento : eventos1) {
                System.out.println(evento);
            }
        }
    }
    //Mostrar evento por fecha y etiqueta (Sobrecarga de metodo)
    public void mostrarEventos(String fecha, String etiqueta){
        LocalDate dia = LocalDate.parse(fecha);
        ArrayList<Evento> eventos2 = eventos.getOrDefault(dia, new ArrayList<>());

        if (eventos.isEmpty()) {
            System.out.println("No hay eventos en esta fecha: " + fecha);
        } else {
            System.out.println("Eventos en " + fecha + " de tipo " + etiqueta + ":");
            for (Evento evento : eventos2) {
                if (evento.getEtiqueta().equals(etiqueta))
                    System.out.println(evento);
            }
        }
    }

    public void mostrarTodosLosEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos en la agenda.");
            return;
        }
        for (Map.Entry<LocalDate, ArrayList<Evento>> eventos : eventos.entrySet()) {
            LocalDate dia = eventos.getKey();
            ArrayList<Evento> eventosEnDia = eventos.getValue();
            System.out.println("Eventos en " + dia + ":");
            for (Evento evento : eventosEnDia) {
                System.out.println(evento);
            }
        }
    }

    public void mostrarTodosLosEventosEtiqueta(String etiqueta) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos en la agenda.");
            return;
        }
        for (Map.Entry<LocalDate, ArrayList<Evento>> eventos : eventos.entrySet()) {
            LocalDate dia = eventos.getKey();
            ArrayList<Evento> eventosEnDia = eventos.getValue();

            if(eventosEnDia.contains(etiqueta)){}
                System.out.println("Eventos en " + dia + ":");
            for (Evento evento : eventosEnDia) {
                if (evento.getEtiqueta().equals(etiqueta))
                    System.out.println(evento);
            }
        }
    }

    public void eliminarEvento(String fecha, int id) {

        LocalDate dia = LocalDate.parse(fecha);
        if (!eventos.containsKey(dia)) {
            System.out.println("No hay eventos en esta fecha: " + fecha);
        } else{
            this.eventos.get(dia).remove(id-1);
            System.out.println("Evento con id " + id + " eliminado.");

        }
    }
}
