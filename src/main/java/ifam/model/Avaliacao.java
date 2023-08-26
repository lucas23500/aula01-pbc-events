package ifam.model;

import ifam.event.NotaLancadaEvent;
import ifam.listener.NotaLancadaListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Avaliacao {

    private String titulo;

    private String descricao;

    private Aluno aluno;

    private Double nota;

    public List<NotaLancadaListener> ouvintes = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addOuvinte(NotaLancadaListener ouvinte){
        if(!ouvintes.contains(ouvinte)) {
            ouvintes.add(ouvinte);
        }
    }

    public synchronized void removeOuvinte(NotaLancadaListener ouvinte){
        ouvintes.remove(ouvinte);
    }


//    public List<NotaLancadaListener> getOuvinte() {
//        return ouvinte;
//    }
//
//    public void setOuvinte(List<NotaLancadaListener> ouvinte) {
//        this.ouvinte = ouvinte;
//    }

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

        notifyNotaLancada();

    }

    private void notifyNotaLancada(){
        NotaLancadaEvent event = new NotaLancadaEvent(this);

        synchronized (ouvintes) {
            for (NotaLancadaListener ouvinte : ouvintes) {
                ouvinte.notaLancada(event);

            }
        }
    }
}
