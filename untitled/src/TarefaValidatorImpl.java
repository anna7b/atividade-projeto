package untitled.src;

public class TarefaValidatorImpl implements TarefaValidator {
    @Override
    public void validarDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ser vazia.");
        }
    }

    @Override
    public void validarIndice(int indice, int tamanhoLista) {
        if (indice < 0 || indice >= tamanhoLista) {
            throw new IndexOutOfBoundsException("Índice inválido.");
        }
    }
}
