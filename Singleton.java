public class Singleton {
	
	private Conta contas[] = new Conta[30];
	int contasCount = 0, posicao = 0;
	
	private static Singleton instance = null;

	private Singleton() {}
	
	public static Singleton getInstance(){
		
		if(instance == null)
			instance = new Singleton();
	      
		return instance;
	}
	
	public boolean verificaExistenciaDaConta(int numero) {
		
		for(int i = 0; i < contasCount; i++)
			if (contas[i].getNumero() == numero)
				return true;
		
		return false;
	}
	
	public boolean contaSimples(String nome, int numero) {
		
		if(verificaExistenciaDaConta(numero) == false) {
			
			contas[contasCount++] = new ContaSimples(nome, numero);
			return true;
		}
		
		return false;
	}
	
	public boolean contaEspecial(String nome, int numero, double limite, double juros) {
		
		if(verificaExistenciaDaConta(numero) == false) {
			
			contas[contasCount++] = new ContaEspecial(nome, numero, limite, juros);
			return true;
		}
		
		return false;
	}
	
	public boolean contaPoupanca(String nome, int numero, double rendimento) {
		
		if(verificaExistenciaDaConta(numero) == false) {
			
			contas[contasCount++] = new ContaPoupanca(nome, numero, rendimento);
			return true;
		}
		
		return false;
	}
	
	public Conta[] visualizarInformacoes() {
		
		return contas;
	}
	
	public void depositar(double valor) {
		
		contas[posicao].depositar(valor);
	}
	
	public int sacar(double valor) throws ExceptionSaque {
		
		if(contas[posicao] instanceof ContaPoupanca || contas[posicao] instanceof ContaSimples)
			if (valor > contas[posicao].getSaldo())
				throw new ExceptionSaque();
		
		try {
			
			return contas[posicao].sacar(valor);
		}
		
		catch (ExceptionSaque ExceptionSaque) {
			
			return -1;
		}
	}
	
	public int alterarSenha(String senhaAntiga, String senhaNova) {
		
		return contas[posicao].alteraSenha(senhaAntiga, senhaNova);
	}
	
	public void incrementarRendimento() {
		
		for(int i = 0; i < contasCount; i++) {
			
			if (contas[i] instanceof ContaPoupanca) {
				
				ContaPoupanca aux;
				aux = (ContaPoupanca)contas[i];
				aux.rendimento();
			}
		}
	}
	
	public void cobrarJuros() {
		
		for(int i = 0; i < contasCount; i++) {
			
			if (contas[i] instanceof ContaEspecial) {
				
				ContaEspecial aux;
				aux = (ContaEspecial)contas[i];
				aux.juros();
			}
		}
	}
}
