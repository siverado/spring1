package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by andrew on 4/25/17.
 */
public class TicketDAO {

    private Set<Ticket> tickets;

    public TicketDAO () {
        tickets = new HashSet<>();
    }

    public void bookTickets(Set<Ticket> tickets) {
        this.tickets.addAll(tickets);
    }

    public Set<Ticket> getByEventAndDate(Event event, LocalDateTime dateTime) {
        return tickets.stream().filter(ticket -> ticket.getEvent().equals(event) && ticket.getDateTime().equals(dateTime)).collect(Collectors.toSet());
    }
}
