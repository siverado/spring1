package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by andrew on 4/25/17.
 */
public class AuditoriumServiceImpl implements AuditoriumService {

    private Collection<Auditorium> auditoriums;

    public AuditoriumServiceImpl(Collection<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return (Set<Auditorium>) auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        Auditorium result = null;
        for (Auditorium auditorium: auditoriums) {
            if (auditorium.getName().equals(name)) {
                result =  auditorium;
            }
        }
        return result;
    }
}
