import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //Creación de agenda.
        Agenda nuevaAgenda = new Agenda("Agebda geu");

        //Creacion de eventos
        Evento evento1 = new Evento("CHARLA","Una charla muy importante","Reunion", "12:20");
        Evento evento2 = new Evento("NO CHARLA","Una No charla NO importante","Actividad","14:30");
        Evento evento3 = new Evento("Sexo","gracias profe","Actividad","14:30");
        Evento evento4 = new Evento("No sexio","te amo melissa","Reunion","22:30");
        Evento evento5 = new Evento("Bautizo","La wawa no es ni mia","Actividad","19:45");


        //Agregar eventos a nuevaAgenda utilizando método agregarEvento();
        nuevaAgenda.agregarEvento("2024-01-01", evento1);
        nuevaAgenda.agregarEvento("2024-01-01", evento2);
        nuevaAgenda.agregarEvento("2024-03-11", evento3);
        nuevaAgenda.agregarEvento("2024-08-29", evento4);
        nuevaAgenda.agregarEvento("2024-09-21", evento5);

        System.out.println("Todos los eventos agendados");

        //Menú
        Menu menu = new Menu(nuevaAgenda);
        menu.iniciarMenu();
    }
}
