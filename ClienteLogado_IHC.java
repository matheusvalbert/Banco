import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ClienteLogado_IHC extends JFrame {
	
	private JLabel oquedeseja;
	private JButton saque, deposito, informacoes, alterarSenha;
	
	public ClienteLogado_IHC() {
		
		super("Cliente");
		setLayout(new FlowLayout());
		
		oquedeseja = new JLabel("O que deseja fazer:");
		add(oquedeseja);
		
		saque = new JButton("Realizar saque");
		add(saque);
		
		deposito = new JButton("Realizar Deposito");
		add(deposito);
		
		informacoes = new JButton("Visualizar Informacoes da Conta");
		add(informacoes);
		
		alterarSenha = new JButton("Alterar senha");
		add(alterarSenha);
		
		opcao botao = new opcao();
		saque.addActionListener(botao);
		deposito.addActionListener(botao);
		informacoes.addActionListener(botao);
		alterarSenha.addActionListener(botao);
	}
	
	private class opcao implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			if(evento.getSource() == saque) {
				
				SaqueDeposito_IHC saque = new SaqueDeposito_IHC("Saque", "Digite o valor que deseja sacar:");
				saque.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				saque.setSize(380,100);
				saque.setLocationRelativeTo(null);
				saque.setVisible(true);
			
			}
			
			else if(evento.getSource() == deposito) {
				
				SaqueDeposito_IHC deposito = new SaqueDeposito_IHC("Deposito", "Digite o valor que deseja depositar:");
				deposito.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				deposito.setSize(380,100);
				deposito.setLocationRelativeTo(null);
				deposito.setVisible(true);
			}
			
			else if(evento.getSource() == informacoes) {
				
				InformacoesDaConta_IHC informacoesDaConta = new InformacoesDaConta_IHC();
				informacoesDaConta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				informacoesDaConta.setSize(380,100);
				informacoesDaConta.setLocationRelativeTo(null);
				informacoesDaConta.setVisible(true);
			}
			
			else {
				
				AlterarSenha_IHC senha = new AlterarSenha_IHC();
				senha.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				senha.setSize(280,125);
				senha.setLocationRelativeTo(null);
				senha.setVisible(true);
			}
		}
	}
}