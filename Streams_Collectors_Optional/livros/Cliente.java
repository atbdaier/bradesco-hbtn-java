public class Cliente {
    private Integer codigo;
    private String nome;
    private boolean premium;

    public Cliente(Integer codigo, String nome, boolean premium) {
        this.codigo = codigo;
        this.nome = nome;
        this.premium = premium;
    }

    //Getters e Setters
    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s", codigo, nome, premium ? "Premium" : "Comum");
    }
}
