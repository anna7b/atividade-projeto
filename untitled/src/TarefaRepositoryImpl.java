package untitled.src;

import java.util.List;
import java.util.ArrayList;

public class TarefaRepositoryImpl implements TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    @Override
    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public void remover(int indice) {
        tarefas.remove(indice);
    }

    @Override
    public Tarefa obter(int indice) {
        return tarefas.get(indice);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }
}
