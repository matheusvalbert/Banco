import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class AlterarSenha_IHC extends JFrame {
	
	private JLabel senhaNova, senhaAntiga;
	private JPasswordField senha, senhaA;
	private JButton cancelar, ok;
	
	public AlterarSenha_IHC() {
		
		super("Alterar senha");
		setLayout(new FlowLayout());
		
		senhaAntiga = new JLabel("Digite a senha antiga:");
		add(senhaAntiga);
		
		senhaA = new JPasswordField(10);
		add(senhaA);
		
		senhaNova = new JLabel("Digite a nova senha:");
		add(senhaNova);
		
		senha = new JPasswordField(10);
		add(senha);
		
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
			
			Singleton objeto = Singleton.getInstance();
			
			if(evento.getSource() == ok) {
				
				char pass[] = senhaA.getPassword(), pass1[] = senha.getPassword();
				
				String senhaAntiga = new String(pass);
				String senhaNova = new String(pass1);
				
				if(objeto.alterarSenha(senhaAntiga, senhaNova) == 0) {
					
					JOptionPane.showMessageDialog(null, "senha incorreta, tente novamente", "senha", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "senha alterada com sucesso", "senha", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
			
			else {
				
				dispose();
			}
		}
	}
}