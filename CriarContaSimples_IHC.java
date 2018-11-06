import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CriarContaSimples_IHC extends CriarContaNova_IHC {
	
	private JButton cancelar, ok;
	
	public CriarContaSimples_IHC(String tipoDeConta) {
		
		super(tipoDeConta);
		
		setLayout(new FlowLayout());
		
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
				
				try {
					
					if(objeto.contaSimples(nomeInserir.getText(), Integer.parseInt(numeroInserir.getText())) == true) {
						
						JOptionPane.showMessageDialog(null, "Conta Simples criada com sucesso", "Criar Conta Simples", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Numero da conta ja existente", "Criar Conta Simples", JOptionPane.ERROR_MESSAGE);					
					}
				}
				catch(NumberFormatException NumberFormatException) {

					JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Criar Conta Simples", JOptionPane.ERROR_MESSAGE);						
				}
			}
			
			else {
				
				dispose();
			}
		}
	}
}