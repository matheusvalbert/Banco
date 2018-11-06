public class ContaEspecial extends Conta {
	
	private double juros;
	
	public ContaEspecial(String nomeDoCorrentista, int numeroDaConta, double limite, double juros) {
		
		super(nomeDoCorrentista, numeroDaConta, limite);
		this.juros = juros;
	}
	
	public void juros() {
		
		if (getSaldo() < 0) {
			
			depositar(getSaldo() * (juros/100));
		}
	}
	
	public double getJuros() {
		
		return juros;
	}
}
