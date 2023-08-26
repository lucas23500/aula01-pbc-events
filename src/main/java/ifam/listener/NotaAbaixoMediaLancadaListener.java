package ifam.listener;

import ifam.event.NotaAbaixoMediaLancadaEvent;
import ifam.event.NotaLancadaEvent;

import java.util.EventListener;

public interface NotaAbaixoMediaLancadaListener extends EventListener {

    void notaAbaixoMediaLancada(NotaAbaixoMediaLancadaEvent notaEvent);

}
