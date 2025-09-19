import java.util.List;

@FunctionalInterface
public interface CriterioFiltro {
    public boolean testar(Produto produto);
}
