package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by andrew on 4/21/17.
 */
public class DiscountServiceBirthdayImpl extends DiscountStrategy {
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = 0;
        if (user == null) {
            return discount;
        }
        LocalDateTime birthday = user.getBirthdate();

        if (birthday.isAfter(airDateTime.minusDays(5)) && birthday.isBefore(airDateTime.plusDays(5)) && event.airsOnDateTime(airDateTime)) {
            discount = 5;
        }
        return discount;
    }
}
