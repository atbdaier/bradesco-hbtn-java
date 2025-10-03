import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        return pessoas.stream().collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new HashMap<>(),
                Collectors.groupingBy( Pessoa::getIdade, () -> new TreeMap<>(), Collectors.counting()
                )
        ));
    }

    public static TreeMap<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream().collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new TreeMap<>(obterComparatorCargo()),
                Collectors.counting()
        ));
    }

    private static Comparator<String> obterComparatorCargo() {
        List<String> ordem = Arrays.asList("Product Owner", "Analista QA", "Desenvolvedor");

        return Comparator
                .comparingInt((String s) -> {
                    int idx = ordem.indexOf(s);
                    return idx == -1 ? Integer.MAX_VALUE : idx;
                })
                .thenComparing(Comparator.naturalOrder());
    }

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        return pessoas.stream().collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new TreeMap<String, TreeSet<Pessoa>>(Collections.reverseOrder()),
                Collectors.toCollection(TreeSet::new)
        ));
    }

    public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream().collect(Collectors.groupingBy(
                Pessoa::getCargo,
                () -> new HashMap<>(),
                Collectors.averagingDouble(Pessoa::getSalario)
        ));
    }

}