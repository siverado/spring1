package ua.epam.spring.hometask.service.impl;

import com.google.common.collect.Sets;
import ua.epam.spring.hometask.dao.TicketDAO;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by andrew on 4/21/17.
 */
public class BookingServiceImpl implements BookingService {

    private static final double highRatedEventsRate = 1.2;
    private static final double vipSeatsRate = 2;
    TicketDAO ticketDAO;
    DiscountService discountService;

    public BookingServiceImpl (TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        double ticketsPrice = 0;
        double basePrice = event.getBasePrice();
        Set<Long> vipSeats = event.getAuditoriums().get(dateTime).getVipSeats();

        long vipSeatsCount = Sets.intersection(vipSeats, seats).size();

        ticketsPrice += (seats.size() - vipSeatsCount) * basePrice;
        ticketsPrice += vipSeatsCount * basePrice * vipSeatsRate;

        if (event.getRating() == EventRating.HIGH) {
            ticketsPrice = ticketsPrice * highRatedEventsRate;
        }

        ticketsPrice = ticketsPrice * (100 - discountService.getDiscount(user, event, dateTime, seats.size()))/100;

        return ticketsPrice;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        ticketDAO.bookTickets(tickets);
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return ticketDAO.getByEventAndDate(event,dateTime);
    }
}
