import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutput;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Gerente_IHC extends JFrame {
	
	private JLabel oqDeseja;
	private JButton criarConta, visualizarInformacoesDaConta, incrementarRendimento, realizarCobrancaDeJuros;
	
	public Gerente_IHC() {
		
		super("Gerente");
		setLayout(new FlowLayout());
		
		oqDeseja = new JLabel("O que deseja fazer");
		add(oqDeseja);
		
		criarConta = new JButton("Criar nova Conta");
		add(criarConta);
		
		visualizarInformacoesDaConta = new JButton("visualizar Informacoes da Conta");
		add(visualizarInformacoesDaConta);
		
		incrementarRendimento = new JButton("Incrementar Rendiamento");
		add(incrementarRendimento);
		
		realizarCobrancaDeJuros = new JButton("Realizar Cobranca de Juros");
		add(realizarCobrancaDeJuros);
		
		opcao botao = new opcao();
		criarConta.addActionListener(botao);
		visualizarInformacoesDaConta.addActionListener(botao);
		incrementarRendimento.addActionListener(botao);
		realizarCobrancaDeJuros.addActionListener(botao);
	}
	
	private class opcao implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			Singleton objeto = Singleton.getInstance();
			
			if(evento.getSource() == criarConta) {
				
				CriarConta_IHC criarConta = new CriarConta_IHC();
				criarConta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				criarConta.setSize(280,130);
				criarConta.setLocationRelativeTo(null);
				criarConta.setVisible(true);
			}
			
			else if(evento.getSource() == visualizarInformacoesDaConta) {
				
				MostrarInformacoesDaConta_IHC mostrarInformacoesDaConta = new MostrarInformacoesDaConta_IHC(objeto.visualizarInformacoes(), objeto.contasCount);
				mostrarInformacoesDaConta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				mostrarInformacoesDaConta.setSize(400,230);
				mostrarInformacoesDaConta.setLocationRelativeTo(null);
				mostrarInformacoesDaConta.setVisible(true);
			}
			
			else if(evento.getSource() == incrementarRendimento) {
				
				
				JOptionPane.showMessageDialog(null, "Rendimento Incrementado com sucesso", "Rendimento", JOptionPane.INFORMATION_MESSAGE);
				objeto.incrementarRendimento();
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Cobranca de Juros realizada com sucesso", "Cobranca de Juros", JOptionPane.INFORMATION_MESSAGE);
				objeto.cobrarJuros();
			}
		}
	}
}