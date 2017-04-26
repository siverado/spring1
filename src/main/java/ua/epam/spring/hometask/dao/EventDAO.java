package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrew on 4/21/17.
 */
public class EventDAO {
    private Set<Event> all;

    public EventDAO() {
        all = new HashSet<>();
    }

    public Event getByName(String name) {
        Event result = null;
        for (Event event : all) {
            if (event.getName().equals(name)) {
                result = event;
            }
        }
        return result;
    }

    public void save(Event object) {
        all.add(object);
    }

    public void remove(Event object) {
        all.remove(object);
    }

    public Event getById(Long id) {
        return null;
    }

    public Collection<Event> getAll() {
        return all;
    }
}
