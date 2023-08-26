package ifam.listener;

import ifam.event.NotaLancadaEvent;

import java.util.EventListener;

public interface NotaLancadaListener extends EventListener {

    void notaLancada(NotaLancadaEvent notaEvent);

}
