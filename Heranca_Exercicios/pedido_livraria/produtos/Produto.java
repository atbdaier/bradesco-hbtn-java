package produtos;

public abstract class Produto {
    private String titulo;
    private double precoBruto;
    private int ano;
    private String pais;

    public Produto(String titulo, int ano, double precoBruto) {
        this.titulo = titulo;
        this.precoBruto = precoBruto;
        this.ano = ano;
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
