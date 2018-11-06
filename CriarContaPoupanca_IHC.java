import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarContaPoupanca_IHC extends CriarContaNova_IHC {
	
	private JLabel rendimento;
	private JTextField rendimentoInserir;
	private JButton cancelar, ok;
	
	public CriarContaPoupanca_IHC(String tipoDeConta) {
		
		super(tipoDeConta);
		
		rendimento = new JLabel("Rendimento da Conta:");
		add(rendimento);
		
		rendimentoInserir = new JTextField(10);
		add(rendimentoInserir);
		
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
					
					if(objeto.contaPoupanca(nomeInserir.getText(), Integer.parseInt(numeroInserir.getText()), Double.parseDouble(rendimentoInserir.getText())) == true) {
					
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso", "Criar Conta Poupanca", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					
					else {
						
						JOptionPane.showMessageDialog(null, "Numero da conta ja existente", "Criar Conta Poupanca", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				catch(NumberFormatException NumberFormatException) {
					
					JOptionPane.showMessageDialog(null, "Entrada Invalida, tente novamente", "Criar Conta Poupanca", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else {
				
				dispose();
			}
		}
	}
}