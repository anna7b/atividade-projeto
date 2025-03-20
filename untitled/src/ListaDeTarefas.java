import java.util.ArrayList;

public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public ListaDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ser vazia.");
        }
        tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        tarefas.remove(indice);
    }

    public void marcarTarefaComoConcluida(int indice) {
        if (indice < 0 || indice >= tarefas.size()) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
        tarefas.get(indice).marcarComoConcluida();
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }
}