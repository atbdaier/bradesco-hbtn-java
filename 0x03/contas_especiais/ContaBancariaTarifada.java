import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica{
    private int quantidadeTransacoes = 0;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        aplicarTaxaTransacao();
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        aplicarTaxaTransacao();
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    private void aplicarTaxaTransacao() {
        quantidadeTransacoes++;
        setSaldo(getSaldo() - 0.1);
    }
}