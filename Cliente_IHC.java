import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Cliente_IHC extends JFrame {
	
	private JLabel numeroDaConta, senha;
	private JPasswordField senhaInserir;
	private JTextField numeroDaContaInserir;
	private JButton cancelar, ok;
	
	public Cliente_IHC() {
		
		super("Login Cliente");
		setLayout(new FlowLayout());
		
		numeroDaConta = new JLabel("Insira o numero da conta:");
		add(numeroDaConta);
		
		numeroDaContaInserir = new JTextField(10);
		add(numeroDaContaInserir);
		
		senha = new JLabel("Insira a senha da conta:");
		add(senha);
		
		senhaInserir = new JPasswordField(10);
		add(senhaInserir);
		
		cancelar = new JButton("Cancelar");
		add(cancelar);
		
		ok = new JButton("OK");
		add(ok);
		
		opcao botao = new opcao();
		ok.addActionListener(botao);
		cancelar.addActionListener(botao);
	}
	
	private class opcao implements ActionListener {
		
		public void actionPerformed (ActionEvent evento) {
			
			char pass[] = senhaInserir.getPassword();
			String senha = new String(pass);
			boolean flag = false, flag1 = false;
			
			Singleton objeto = Singleton.getInstance();
			
			if(evento.getSource() == ok) {
				
				if(objeto.contasCount == 0) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma conta criada", "Login", JOptionPane.INFORMATION_MESSAGE);
				}
				
				for(int i = 0; i < objeto.contasCount; i++) {
					
					try {
						if (Integer.parseInt(numeroDaContaInserir.getText()) == objeto.visualizarInformacoes()[i].getNumero()) {
						
							if(objeto.visualizarInformacoes()[i].alteraSenha(senha, senha) == 1) {
				
								dispose();
								ClienteLogado_IHC clienteLogado = new ClienteLogado_IHC();
								clienteLogado.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								clienteLogado.setSize(250,195);
								clienteLogado.setLocationRelativeTo(null);
								clienteLogado.setVisible(true);
								objeto.posicao = i;
								flag = true;
							}
						}

					}
				
					catch(NumberFormatException NumberFormatException) {
						
						if(flag1 == false) {
							
							JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Login", JOptionPane.ERROR_MESSAGE);
							flag1 = true;
						}
					}
				}
				if (flag == false && flag1 == false) {
					flag = true;
					JOptionPane.showMessageDialog(null, "Erro no login, conta ou senha invalido", "Login", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				
				dispose();
			}
		}
	}
}