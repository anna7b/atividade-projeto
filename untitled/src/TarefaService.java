package untitled.src;

import java.util.List;

public interface TarefaService extends TarefaLeitura, TarefaEscrita {
    void adicionarTarefa(String descricao);
    void removerTarefa(int indice);
    void marcarTarefaComoConcluida(int indice);
    List<String> listarTarefas();
}
