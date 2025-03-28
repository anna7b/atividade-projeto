package untitled.src;

import java.util.List;
import java.util.stream.Collectors;

public class TarefaServiceImpl implements TarefaService {
    private final TarefaRepository repository;
    private final TarefaValidator validator;

    public TarefaServiceImpl(TarefaRepository repository, TarefaValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public void adicionarTarefa(String descricao) {
        validator.validarDescricao(descricao);
        repository.adicionar(new Tarefa(descricao));
    }

    @Override
    public void removerTarefa(int indice) {
        validator.validarIndice(indice, repository.listarTodas().size());
        repository.remover(indice);
    }

    @Override
    public void marcarTarefaComoConcluida(int indice) {
        validator.validarIndice(indice, repository.listarTodas().size());
        Tarefa tarefa = repository.obter(indice);
        tarefa.marcarComoConcluida();
    }

    @Override
    public List<String> listarTarefas() {
        return repository.listarTodas().stream()
                .map(Tarefa::toString)
                .collect(Collectors.toList());
    }
}
