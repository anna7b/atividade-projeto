import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Gerenciador de Tarefas ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Listar Tarefas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        listaDeTarefas.adicionarTarefa(descricao);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;
                    case 2:
                        System.out.print("Digite o índice da tarefa a ser removida: ");
                        int indiceRemover = scanner.nextInt();
                        listaDeTarefas.removerTarefa(indiceRemover - 1);
                        System.out.println("Tarefa removida com sucesso!");
                        break;
                    case 3:
                        System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                        int indiceConcluir = scanner.nextInt();
                        listaDeTarefas.marcarTarefaComoConcluida(indiceConcluir - 1);
                        System.out.println("Tarefa marcada como concluída!");
                        break;
                    case 4:
                        listaDeTarefas.listarTarefas();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}