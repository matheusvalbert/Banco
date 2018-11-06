import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MostrarInformacoesDaConta_IHC extends JFrame {
	
	private JLabel clientes;
	
	public MostrarInformacoesDaConta_IHC(Conta contas[], int contasCount) {
		
		super("Contas");
		setLayout(new FlowLayout());
		
		for(int i = 0; i < contasCount; i++) {
			
			if (contas[i] instanceof ContaSimples) {
				
				clientes = new JLabel("Nome: " + contas[i].getCorrentista() + "\t Numero: " + contas[i].getNumero() + "\t Saldo: " + contas[i].getSaldo());
				add(clientes);
			}
			
			else if (contas[i] instanceof ContaEspecial) {
				
				ContaEspecial aux;
				aux = (ContaEspecial)contas[i];
				clientes = new JLabel("Nome: " + contas[i].getCorrentista() + "\t Numero: " + contas[i].getNumero() + "\t Saldo: " + contas[i].getSaldo() + "\t Limite: " + contas[i].getLimite() + "\t Juros: " + aux.getJuros());
				add(clientes);
			}
			
			else if (contas[i] instanceof ContaPoupanca) {
				
				ContaPoupanca aux;
				aux = (ContaPoupanca)contas[i];
				clientes = new JLabel("Nome: " + contas[i].getCorrentista() + "\t Numero: " + contas[i].getNumero() + "\t Saldo: " + contas[i].getSaldo() + "\t Rendimento: " + aux.getRendimento());
				add(clientes);
			}
		}
	}
}
