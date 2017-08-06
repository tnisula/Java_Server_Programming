package ski50b.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ski50b.Event;

@Named
@Singleton
public class EventsBean {
    @PersistenceContext
    EntityManager em;
    private List<Event> events;
    
    @PostConstruct
    private void init() {
        events = em.createNamedQuery("Event.findAll", Event.class)
                .getResultList();
    }
    
    public List<Event> getEvents() {
        return events;
    }

    public Event getEvent(String year) {
        try {
            return em.find(Event.class, Integer.parseInt(year));
        } catch (Exception ex) {
            return null;
        }
    }
}
