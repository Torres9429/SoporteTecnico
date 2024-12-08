package utez.edu.mx.SoporteTecnico.Service;

import org.springframework.stereotype.Service;
import utez.edu.mx.SoporteTecnico.model.Problema;
import utez.edu.mx.SoporteTecnico.model.Tecnico;
import utez.edu.mx.SoporteTecnico.model.Ticket;
import utez.edu.mx.SoporteTecnico.estructuras.Queue;
import utez.edu.mx.SoporteTecnico.estructuras.ArrayList;
import utez.edu.mx.SoporteTecnico.utils.TypesResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class TicketService {

    private Queue<Ticket> colaTickets = new Queue<>();
    private ArrayList<Ticket> ticketsResueltos = new ArrayList<>();
    private int contadorIdTickets = 1;
    private Random random = new Random(); // Generador de números aleatorios

    // Generar ticket aleatorio
    public void generarTicketAleatorio() {
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Problema[] problemas = Problema.values();
        Problema problemaAleatorio = problemas[random.nextInt(problemas.length)];

        String[] tecnicos = {"Uxue", "Juan", "Alexa", "Zohet", "Rocio"}; //Tecnicos jiji
        Tecnico tecnicoAleatorio = new Tecnico(tecnicos[random.nextInt(tecnicos.length)]);

        // Crear el ticket
        Ticket ticket = new Ticket(contadorIdTickets++, fechaActual, problemaAleatorio, tecnicoAleatorio);

        // Agregar a la cola
        colaTickets.offer(ticket);
    }

    public Ticket resolverTicket() {
        Ticket ticket = colaTickets.poll();
        if (ticket != null) {
            ticketsResueltos.add(ticket); //Se agrega al historial
        }
        return ticket;
    }

    public ArrayList<Ticket> obtenerHistorialTickets() {
        return ticketsResueltos;
    }

    public Ticket siguienteTicket() {
        return colaTickets.peek();
    }
}
