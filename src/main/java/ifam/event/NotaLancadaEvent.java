package ifam.event;

import java.util.EventObject;

public class NotaLancadaEvent extends EventObject {


    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public NotaLancadaEvent(Object source) {
        super(source);
    }
}
