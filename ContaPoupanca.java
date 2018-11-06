public class ContaPoupanca extends Conta {
	
	private double rendimento;

	public ContaPoupanca(String nomeDoCorrentista, int numeroDaConta, double rendimento) {
		
		super(nomeDoCorrentista, numeroDaConta, 0);
		this.rendimento = rendimento;
	}
	
	public void rendimento() {
		
		depositar(getSaldo() * (rendimento/100));
	}
	
	public double getRendimento() {
		
		return rendimento;
	}
}