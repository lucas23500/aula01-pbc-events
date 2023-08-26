package ifam.testes;

import ifam.event.NotaLancadaEvent;
import ifam.listener.NotaLancadaListener;
import ifam.model.Avaliacao;

public class SMSService implements NotaLancadaListener {

    @Override
    public void notaLancada(NotaLancadaEvent notaEvent) {
        Avaliacao avaliacao = (Avaliacao) notaEvent.getSource();

        System.out.println("*** SMS Enviado com Sucesso ***");
        System.out.println("Aluno:" + avaliacao.getAluno());
        System.out.println("Matrícula:" + avaliacao.getAluno().getMatricula());
        System.out.println("Telefone:" + avaliacao.getAluno().getTelefone());
        System.out.println("Nota:" + avaliacao.getNota());
    }
}
