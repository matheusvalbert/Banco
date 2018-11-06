import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class SaqueDeposito_IHC extends JFrame {
	
	private JLabel valor;
	private JTextField valorDigitar;
	private JButton cancelar, ok;
	private String func;
	
	public SaqueDeposito_IHC(String oqFazer, String funcao) {
		
		super(oqFazer);
		setLayout(new FlowLayout());
		
		func = oqFazer;
		
		valor = new JLabel(funcao);
		add(valor);
			
		valorDigitar = new JTextField(10);
		add(valorDigitar);
				
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
				
				if(func.equals("Deposito")) {
					
					try {
					
						objeto.depositar(Double.parseDouble(valorDigitar.getText()));
						dispose();
						JOptionPane.showMessageDialog(null, "Deposito Realizado com sucesso", "Deposito", JOptionPane.INFORMATION_MESSAGE);
					}
					
					catch (NumberFormatException NumberFormatException) {
						
						JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Deposito", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else {
						
					try {
					
						if(objeto.sacar(Double.parseDouble(valorDigitar.getText())) == 0) {
						
							JOptionPane.showMessageDialog(null, "Limite insuficiente", "Saque", JOptionPane.ERROR_MESSAGE);
							}
							
						else {
							
							JOptionPane.showMessageDialog(null, "Saque Realizado com sucesso", "Saque", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
					}
						
					catch (NumberFormatException NumberFormatException) {
						
						JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Saque", JOptionPane.ERROR_MESSAGE);
					}
					
					catch (ExceptionSaque exceptionSaque) {
							
						JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Saque", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
			else {
				
				dispose();
			}
		}
	}
}