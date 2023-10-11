package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------");
        System.out.println("Processo Seletivo");
        System.out.println("--------------");

        String[] candidatos = { "Carla", "João", "Lucas", "Vitória", "Rafaela", "Junior" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    // Case 4
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("Contato Realizado com Sucesso!");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa!");
        } else {
            System.out.println("Não conseguimos contato com o candidato!");
        }
    }

    // Método auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    // Case 3
    static void imprimirSelecionado() {
        String[] candidatos = { "Carla", "João", "Lucas", "Vitória", "Rafaela", "Junior" };

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento: ");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(i + "º - " + candidatos[i]);
        }
    }

    // Case 2
    static void selecaoCandidatos() {
        String[] candidatos = { "Carla", "João", "Lucas", "Vitória", "Rafaela", "Junior" };

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                candidatosSelecionados++;
            } else {
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga!");
            }
            candidatoAtual++;
        }
    }

    // Metódo auxiliaa
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }

    // Case 1
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o canditado!");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta!");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos!");
        }
    }
}
