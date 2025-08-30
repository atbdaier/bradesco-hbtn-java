package produtos;

public class Dvd extends Produto{
    private String diretor;
    private int duracao;
    private String genero;

    public Dvd(String titulo, int ano, String pais, double precoBruto, String diretor, String genero, int duracao){
        super(titulo, ano, pais, precoBruto);
    }

    @Override
    public double obterPrecoLiquido() {
        return super.getPrecoBruto() * 1.20;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }
}
