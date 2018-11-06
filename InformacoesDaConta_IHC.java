import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InformacoesDaConta_IHC extends JFrame {
	
	private JLabel informacoes;
	private JButton ok;
	
	public InformacoesDaConta_IHC() {
		
		super("Informacoes da conta");
		setLayout(new FlowLayout());
		
		Singleton objeto = Singleton.getInstance();
		
		if (objeto.visualizarInformacoes()[objeto.posicao] instanceof ContaSimples) {
			
			informacoes = new JLabel("Nome: " + objeto.visualizarInformacoes()[objeto.posicao].getCorrentista() + "\t Numero: " + objeto.visualizarInformacoes()[objeto.posicao].getNumero() + "\t Saldo: " + objeto.visualizarInformacoes()[objeto.posicao].getSaldo());
			add(informacoes);
		}
		
		else if (objeto.visualizarInformacoes()[objeto.posicao] instanceof ContaEspecial) {
			
			ContaEspecial aux;
			aux = (ContaEspecial)objeto.visualizarInformacoes()[objeto.posicao];
			informacoes = new JLabel("Nome: " + objeto.visualizarInformacoes()[objeto.posicao].getCorrentista() + "\t Numero: " + objeto.visualizarInformacoes()[objeto.posicao].getNumero() + "\t Saldo: " + objeto.visualizarInformacoes()[objeto.posicao].getSaldo() + "\t Limite: " + objeto.visualizarInformacoes()[objeto.posicao].getLimite() + "\t Juros: " + aux.getJuros());
			add(informacoes);
		}
		
		else if (objeto.visualizarInformacoes()[objeto.posicao] instanceof ContaPoupanca) {
			
			ContaPoupanca aux;
			aux = (ContaPoupanca)objeto.visualizarInformacoes()[objeto.posicao];
			informacoes = new JLabel("Nome: " + objeto.visualizarInformacoes()[objeto.posicao].getCorrentista() + "\t Numero: " + objeto.visualizarInformacoes()[objeto.posicao].getNumero() + "\t Saldo: " + objeto.visualizarInformacoes()[objeto.posicao].getSaldo() + "\t Rendimento: " + aux.getRendimento());
			add(informacoes);
		}
		
		ok = new JButton("OK");
		add(ok);
		
		usuario botao = new usuario();
		ok.addActionListener(botao);
	}
	
	private class usuario implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			if(evento.getSource() == ok) {
				
				dispose();
			}
		}
	}
}