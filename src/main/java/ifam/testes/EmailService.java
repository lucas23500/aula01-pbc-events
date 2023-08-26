package ifam.testes;

import ifam.event.NotaLancadaEvent;
import ifam.listener.NotaLancadaListener;
import ifam.model.Avaliacao;

public class EmailService implements NotaLancadaListener {

    @Override
    public void notaLancada(NotaLancadaEvent notaEvent) {
        Avaliacao avaliacao = (Avaliacao) notaEvent.getSource();

        System.out.println("*** Email Enviado com Sucesso ***");
        System.out.println("Aluno:" + avaliacao.getAluno());
        System.out.println("Matrícula:" + avaliacao.getAluno().getMatricula());
        System.out.println("Email:" + avaliacao.getAluno().getEmail());
        System.out.println("Nota:" + avaliacao.getNota());
    }
}
