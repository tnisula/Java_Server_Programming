package ski50b.beans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import ski50b.Event;

@Named
@RequestScoped
public class EventBean {
    @Inject
    private HttpServletRequest request;
    @EJB
    EventsBean events;
    
    public String getYear() {
        return request.getParameter("ev");
    }
    
    public Event getEvent() {
        return events.getEvent(getYear());
    }
}
