public abstract class Conta {

		private int numeroDaConta;
		private String correntista;
		private double saldo;
		private double limite;
		private String senha;
		
		public Conta () {
			
			numeroDaConta = -1;
			correntista = "";
			saldo = -1;
			limite = -1;
			senha = "";
		}
		
		public Conta (String nomeDoCorrentista, int numeroDaConta, double limite) {
			
			this.limite = limite;
			this.numeroDaConta = numeroDaConta;
			this.correntista = nomeDoCorrentista;
			saldo = 0.0;
			senha = "0000";
		}
		
		public void setNumero(int numeroDaConta) {
			
			this.numeroDaConta = numeroDaConta;
		}
		
		public int getNumero () {
			
			return numeroDaConta;
		}
		
		public void setCorrentista(String correntista) {
			
			this.correntista = correntista;
		}
		
		public String getCorrentista () {
			
			return correntista;
		}
		
		public double getSaldo () {
			
			return saldo;
		}
		
		public void setLimite (double limite) {
			
			this.limite = limite;
		}
		
		public double getLimite () {
			
			return limite;
		}
		
		public int sacar (double valor) {
			
			if (saldo >= valor || saldo + limite >= valor) {
				
				saldo -= valor;
				return 1;
			}
			return 0;
		}
		
		public void depositar (double valor) {
			
			saldo += valor;
		}
		
		public int alteraSenha (String senhaAntiga, String senhaNova) {
			
			if(senha.equals(senhaAntiga)) {
				
				senha = senhaNova;
				return 1;
			}
			else {
				
				return 0;
			}
		}
}
