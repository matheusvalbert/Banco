import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class CriarContaNova_IHC extends JFrame {
	
	private JLabel nome, numero;
	public JTextField nomeInserir, numeroInserir;
	
	public CriarContaNova_IHC(String tipoDeConta) {
	
		super(tipoDeConta);
		setLayout(new FlowLayout());
		
		
		nome = new JLabel("Nome do Cliente:");
		add(nome);
		
		nomeInserir = new JTextField(10);
		add(nomeInserir);
		System.out.println(nomeInserir.getText());
		
		numero = new JLabel("Numero da Conta:");
		add(numero);
		
		numeroInserir = new JTextField(10);
		add(numeroInserir);
	}
}