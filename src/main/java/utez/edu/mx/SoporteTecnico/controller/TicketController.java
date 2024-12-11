package utez.edu.mx.SoporteTecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.SoporteTecnico.Service.TicketService;
import utez.edu.mx.SoporteTecnico.model.Ticket;
import utez.edu.mx.SoporteTecnico.utils.Message;
import utez.edu.mx.SoporteTecnico.utils.TypesResponse;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/siguiente")
    public ResponseEntity<Message> siguienteTicket() {
        Ticket ticket = ticketService.siguienteTicket();
        if (ticket != null) {
            return ResponseEntity.ok(new Message("Siguiente ticket: " + ticket.toString(), TypesResponse.SUCCESS));
        } else {
            return ResponseEntity.status(404).body(new Message("No hay tickets en espera", TypesResponse.ERROR));
        }
    }

    @PostMapping("/generar")
    public ResponseEntity<Message> generarTicket() {
        ticketService.generarTicketAleatorio();
        return ResponseEntity.ok(new Message("Ticket generado exitosamente", TypesResponse.SUCCESS));
    }

    @PostMapping("/resolver")
    public ResponseEntity<Message> resolverTicket() {
        Ticket ticket = ticketService.resolverTicket();
        if (ticket != null) {
            return ResponseEntity.ok(new Message("Ticket resuelto: " + ticket.toString(), TypesResponse.SUCCESS));
        } else {
            return ResponseEntity.status(404).body(new Message("No hay tickets para resolver", TypesResponse.ERROR));
        }
    }



    @GetMapping("/historial")
    public ResponseEntity<Message> obtenerHistorial() {
        utez.edu.mx.SoporteTecnico.estructuras.LinkedList<Ticket> historial = ticketService.obtenerHistorialTickets();
        // Crear una lista de mapas o DTOs con la información del ticket
        ArrayList<Map<String, String>> historialFormateado = new ArrayList<>();
        for (int i = 0; i < historial.size(); i++) {
            Ticket ticket = historial.get(i);
            Map<String, String> ticketData = new HashMap<>();
            ticketData.put("id", String.valueOf(ticket.getId()));
            ticketData.put("fecha", ticket.getFecha());
            ticketData.put("problema", ticket.getProblema().toString());
            ticketData.put("tecnico", ticket.getTecnico().getNombre());
            historialFormateado.add(ticketData);
        }

        return ResponseEntity.ok(new Message(historialFormateado, "Historial de tickets resueltos", TypesResponse.SUCCESS));
    }







}
