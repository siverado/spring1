package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by andrew on 4/21/17.
 */
public class DiscountServiceImpl implements DiscountService {

    Collection<DiscountStrategy> discountStrategies;

    public DiscountServiceImpl(Collection<DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        Set<Byte> discounts = discountStrategies.stream().map(discountStrategy -> discountStrategy.getDiscount(user, event, airDateTime, numberOfTickets)).collect(Collectors.toSet());
        return Collections.max(discounts);
    }
}
