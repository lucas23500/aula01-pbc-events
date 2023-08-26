package ifam.testes;

import ifam.model.Aluno;
import ifam.model.Avaliacao;

public class TesteEnviaAvaliacaoPorEmail {

    public static void main(String[] args) {

        EmailService service = new EmailService();

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAluno(new Aluno("Lucas", "123456", "lucas@gmail.com" ));

        avaliacao.setOuvinte(service);

        avaliacao.setNota(9.0);
    }
}
