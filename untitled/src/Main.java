package untitled.src;

public class Main {
    public static void main(String[] args) {
        TarefaRepository repository = new TarefaRepositoryImpl();
        TarefaValidator validator = new TarefaValidatorImpl();
        TarefaService service = new TarefaServiceImpl(repository, validator);

        GerenciadorTarefasUI ui = new GerenciadorTarefasUI(service);
        ui.iniciar();
    }
}
