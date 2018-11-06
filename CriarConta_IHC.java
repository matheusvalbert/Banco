import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CriarConta_IHC extends JFrame {
	
	private JLabel tipoDaConta;
	private JButton contaSimples, contaEspecial, contaPoupanca;
	
	public CriarConta_IHC(){
		
		super("Criacao de Contas");
		setLayout(new FlowLayout());
		
		
		tipoDaConta = new JLabel("Qual o tipo da conta que deseja criar?");
		add(tipoDaConta);
		
		contaSimples = new JButton("Conta Simples");
		add(contaSimples);
		
		contaEspecial = new JButton("Conta Especial");
		add(contaEspecial);
		
		contaPoupanca = new JButton("Conta Poupanca");
		add(contaPoupanca);
		
		opcao botao = new opcao();
		contaSimples.addActionListener(botao);
		contaEspecial.addActionListener(botao);
		contaPoupanca.addActionListener(botao);
	}
	
	private class opcao implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			if(evento.getSource() == contaSimples) {
				
				CriarContaSimples_IHC criarContaSimples = new CriarContaSimples_IHC("Conta Simples");
				criarContaSimples.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				criarContaSimples.setSize(280,130);
				criarContaSimples.setLocationRelativeTo(null);
				criarContaSimples.setVisible(true);
			}
			
			else if(evento.getSource() == contaEspecial) {
				
				CriarContaEspecial_IHC criarContaEspecial = new CriarContaEspecial_IHC("Conta Especial");
				criarContaEspecial.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				criarContaEspecial.setSize(280,180);
				criarContaEspecial.setLocationRelativeTo(null);
				criarContaEspecial.setVisible(true);
			}
			
			else {
				
				CriarContaPoupanca_IHC criarContaPoupanca = new CriarContaPoupanca_IHC("Conta Poupanca");
				criarContaPoupanca.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				criarContaPoupanca.setSize(280,160);
				criarContaPoupanca.setLocationRelativeTo(null);
				criarContaPoupanca.setVisible(true);
			}
		}
	}
}