package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by andrew on 4/21/17.
 */
public class DiscountServiceTenthImpl extends DiscountStrategy{

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        long ticketsWithDiscount;
        if (user != null) {
            long allTickets =  (user.getTickets().size() + numberOfTickets);
            ticketsWithDiscount = allTickets/10 - user.getTickets().size()/10;

        } else {
            ticketsWithDiscount = numberOfTickets/10;
        }

        double percent = (ticketsWithDiscount * 0.5) * 100 / numberOfTickets;

        return (byte) percent ;
    }
}