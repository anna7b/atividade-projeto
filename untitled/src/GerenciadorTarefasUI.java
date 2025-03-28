package untitled.src;
import untitled.src.TarefaService;

import java.util.Scanner;

import java.util.List;

public class GerenciadorTarefasUI {
    private final TarefaService service;
    private final Scanner scanner;

    public GerenciadorTarefasUI(TarefaService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n--- Gerenciador de Tarefas ---");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Remover Tarefa");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Listar Tarefas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine(); // Consumir a nova linha
        }
    }

    private void processarOpcao(int opcao) {
        try {
            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> removerTarefa();
                case 3 -> marcarTarefaComoConcluida();
                case 4 -> listarTarefas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        service.adicionarTarefa(descricao);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void removerTarefa() {
        System.out.print("Digite o índice da tarefa a ser removida: ");
        int indice = scanner.nextInt() - 1;
        service.removerTarefa(indice);
        System.out.println("Tarefa removida com sucesso!");
    }

    private void marcarTarefaComoConcluida() {
        System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
        int indice = scanner.nextInt() - 1;
        service.marcarTarefaComoConcluida(indice);
        System.out.println("Tarefa marcada como concluída!");
    }

    private void listarTarefas() {
        List<String> tarefas = service.listarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }
}