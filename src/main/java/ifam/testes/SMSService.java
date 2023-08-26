package ifam.testes;

import ifam.event.NotaLancadaEvent;
import ifam.listener.NotaAbaixoMediaLancadaListener;
import ifam.listener.NotaLancadaListener;
import ifam.model.Avaliacao;

public class SMSService implements NotaAbaixoMediaLancadaListener {

    @Override
    public void notaAbaixoMediaLancada(NotaAbaixoMediaLancadaListener notaEvent) {
        Avaliacao avaliacao = (Avaliacao) notaEvent.getSource();

        System.out.println("*** SMS Enviado com Sucesso (Nota baixa) ***");
        System.out.println("Aluno:" + avaliacao.getAluno());
        System.out.println("Matrícula:" + avaliacao.getAluno().getMatricula());
        System.out.println("Telefone:" + avaliacao.getAluno().getTelefone());
        System.out.println("Nota:" + avaliacao.getNota());
    }
}
