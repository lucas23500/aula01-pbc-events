package ifam.model;

import ifam.event.NotaAbaixoMediaLancadaEvent;
import ifam.event.NotaLancadaEvent;
import ifam.listener.NotaAbaixoMediaLancadaListener;
import ifam.listener.NotaLancadaListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avaliacao {

    private String titulo;

    private String descricao;

    private Aluno aluno;

    private Double nota;

    public List<NotaLancadaListener> ouvintesGeral = Collections.synchronizedList(new ArrayList<>());
    public List<NotaAbaixoMediaLancadaListener> ouvinteNotaBaixa = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addOuvinte(NotaLancadaListener ouvinte){
        if(!ouvintesGeral.contains(ouvinte)) {
            ouvintesGeral.add(ouvinte);
        }
    }

    public synchronized void removeOuvinte(NotaLancadaListener ouvinte){
        ouvintesGeral.remove(ouvinte);
    }


    public synchronized void addOuvinteNotaBaixa(NotaAbaixoMediaLancadaListener ouvinte){
        if(!ouvinteNotaBaixa.contains(ouvinte)) {
            ouvinteNotaBaixa.add(ouvinte);
        }
    }

    public synchronized void removeOuvinteNotaBaixa(NotaAbaixoMediaLancadaListener ouvinte){
        ouvinteNotaBaixa.remove(ouvinte);
    }






    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;

        if(nota<= 6){
            notifyNotaAbaixoMediaLancada();
        }

        notifyNotaLancada();

    }

    private void notifyNotaLancada() {
        NotaLancadaEvent event = new NotaLancadaEvent(this);


        synchronized (ouvintesGeral) {
            for (NotaLancadaListener ouvinte : ouvintesGeral) {
                ouvinte.notaLancada(event);

            }
        }
    }

        private void notifyNotaAbaixoMediaLancada(){
            NotaAbaixoMediaLancadaEvent event = new NotaAbaixoMediaLancadaEvent(this);



            synchronized (ouvinteNotaBaixa) {
                for (NotaAbaixoMediaLancadaListener ouvinte : ouvinteNotaBaixa) {
                    ouvinte.notaAbaixoMediaLancada(event);

                }
            }
    }
}
