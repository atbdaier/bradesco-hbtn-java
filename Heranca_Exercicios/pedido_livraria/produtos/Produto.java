package produtos;

public abstract class Produto {
    private String titulo;
    private double precoBruto;
    private int ano;
    private String pais;

    Produto(String titulo, int ano, String pais, double precoBruto) {
        this.titulo = titulo;
        this.precoBruto = precoBruto;
        this.ano = ano;
        this.pais = pais;
    }

    public abstract double obterPrecoLiquido();

    public String getTitulo() {
        return titulo;
    }

    public double getPrecoBruto() {
        return precoBruto;
    }

    public int getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }
}
