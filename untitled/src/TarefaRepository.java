package untitled.src;

import java.util.List;

public interface TarefaRepository {
    void adicionar(Tarefa tarefa);
    void remover(int indice);
    Tarefa obter(int indice);
    List<Tarefa> listarTodas();
}
