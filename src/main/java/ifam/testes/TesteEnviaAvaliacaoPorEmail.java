package ifam.testes;

import ifam.model.Aluno;
import ifam.model.Avaliacao;

public class TesteEnviaAvaliacaoPorEmail {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setAluno(new Aluno("Lucas", "123456", "lucas@gmail.com", "91234-5678"));

        avaliacao.addOuvinte(emailService);
        avaliacao.addOuvinte(smsService);

        avaliacao.setNota(9.0);
    }
}
