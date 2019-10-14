import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import xyz.null0verflow.librandomorgclient.GenerateTrueRandom;
public class Interface extends Component  implements ActionListener{
	private boolean stopc = true;
	private int minimum;
	private int maximum;
	private int baseofnum;
	private int total;
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel panel;
	int cc=0;
	JTextField totalnumber;
	JTextField min;
	JTextField max;
	JTextField base;
	JLabel albel[];
	JLabel allalbel[] = new JLabel[4];
	GenerateTrueRandom gtr = new GenerateTrueRandom("bobdinh139@icloud.com");
	JLabel credit0 = new JLabel("TRUE random generator by measuring amospheric noise");
	JLabel credit1 = new JLabel("by @frychicken (Bob Dinh) with special thanks to random.org API ");
	JLabel credit = new JLabel("Powered by librandom.org-client (written also by @frychicken)");
	JCheckBox darkmode = new JCheckBox("night-mode");
	JCheckBox lightmode = new JCheckBox("light-mode");
	JLabel betaalert = new JLabel("Currently in Beta");
	JButton idontunderstand = new JButton("I don't understand");
	JButton nativedepiction = new JButton("Native Depiction");
	JButton javadepiction = new JButton("Java Depiction");
	JLabel whatIwin = new JLabel("What you earn will appear here");

	JRadioButton chooseal = new JRadioButton("Random integer");
	JRadioButton choosea2 = new JRadioButton("Random sequence");
	JRadioButton choosea3 = new JRadioButton("Random string");
	JCheckBox stringg[] = new JCheckBox[4];
	JButton button = new JButton("Generate TRUE random number");
	ButtonGroup bg;
	JLabel show ;
	boolean isdark;
	public void execute(boolean isdark) {
		this.isdark = isdark;
		frame = new JFrame("Try your luck tuesday");
		try {
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Hi.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bg = new ButtonGroup();
		panel = new JPanel();
		allalbel[0] = new JLabel("Total number");
		allalbel[1] = new JLabel("Min");
		allalbel[2] = new JLabel("Max");
		allalbel[3] = new JLabel("Base");
		stringg[0] = new JCheckBox("unique");
		stringg[1] = new JCheckBox("uppercase");
		stringg[2] = new JCheckBox("lowercase");
		stringg[3] = new JCheckBox("digit");

		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Hi.png")));
		show = new JLabel(icon);
		totalnumber = new JTextField("5");
		min = new JTextField("1");
		max = new JTextField("20");
		base = new JTextField("10");
		panel.setLayout(null);
		int y = 120;
		for (int i=0; i< allalbel.length; allalbel[i++].setBounds(460, y+=30, 100, 25));

		int cccc = 250;
		for (int i=0; i< stringg.length; stringg[i++].setBounds(250, cccc+=30, 100, 25));
		for (int i=0; i< stringg.length; stringg[i++].setVisible(false));
		darkmode.setVisible(!isdark);
		darkmode.setBounds(600, 150, 150, 25);
		darkmode.addActionListener(this);
		lightmode.setVisible(isdark);
		lightmode.setBounds(600, 150, 150, 25);
		lightmode.addActionListener(this);
		choosea3.addActionListener(this);
		choosea2.addActionListener(this);
		chooseal.addActionListener(this);

		nativedepiction.setBounds(30, 300, 200,25);
		nativedepiction.setBackground(Color.MAGENTA);
		javadepiction.setBounds(30, 330, 200,25);
		javadepiction.setBackground(Color.PINK);
		show.setBounds(10, 100, 1000, 1000);
		idontunderstand.setBounds(300, 100, 200,30);
		credit0.setBounds(160, 20, 500, 35);
		credit1.setBounds(200, 50, 450, 25);
		credit.setBounds(220, 70, 400, 25);
		credit0.setFont(new Font("Serif", Font.BOLD, 20));
		credit1.setFont(new Font("Serif", Font.ITALIC, 15));
		credit.setForeground(Color.red);
		betaalert.setBounds(540, 220, 400, 25);
		betaalert.setForeground(Color.BLUE);
		totalnumber.setBounds(250, 150, 200, 25);
		min.setBounds(250, 180, 200, 25);
		max.setBounds(250, 210, 200, 25);
		base.setBounds(250, 240, 200, 25);
		whatIwin.setBounds(20, 530, 200, 50);
		whatIwin.setForeground(Color.RED);
		chooseal.setBounds(50, 150, 150, 25);
		choosea2.setBounds(50, 180, 150, 25);
		choosea3.setBounds(50, 210, 150, 25);
		checkDarkMode();
		bg.add(chooseal);
		bg.add(choosea2);
		bg.add(choosea3);
		button.setBounds(200, 600, 400, 100);
		button.addActionListener(this);
		idontunderstand.addActionListener(this);
		nativedepiction.addActionListener(this);
		javadepiction.addActionListener(this);
		for (int i=0; i< stringg.length; (stringg[i++]).addActionListener(this));
		chooseal.setSelected(true);
		frame.setResizable(false);
		frame.setSize(800, 800);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.add(chooseal);
		panel.add(choosea2);
		panel.add(choosea3);
		for (int i=0; i< allalbel.length; panel.add(allalbel[i++]));
		for (int i=0; i< stringg.length; panel.add(stringg[i++]));
		panel.add(button);
		panel.add(totalnumber);
		panel.add(base);
		panel.add(min);
		panel.add(max);
		panel.add(credit);
		panel.add(credit1);
		panel.add(credit0);
		panel.add(show);
		panel.add(betaalert);
		panel.add(idontunderstand);
		panel.add(darkmode);
		panel.add(lightmode);
		panel.add(nativedepiction);
		panel.add(javadepiction);
		panel.add(whatIwin);
		frame.add(panel);
		frame.setVisible(true);
	}
	private void checkDarkMode() {
		if (isdark) {
			credit0.setForeground(Color.WHITE);
			credit1.setForeground(Color.WHITE);
			chooseal.setBackground(Color.DARK_GRAY);
			chooseal.setForeground(Color.WHITE);
			choosea2.setBackground(Color.DARK_GRAY);
			choosea2.setForeground(Color.WHITE);
			choosea3.setBackground(Color.DARK_GRAY);
			choosea3.setForeground(Color.WHITE);
			darkmode.setBackground(Color.DARK_GRAY);
			darkmode.setForeground(Color.WHITE);
			lightmode.setBackground(Color.DARK_GRAY);
			lightmode.setForeground(Color.WHITE);
			totalnumber.setBackground(Color.DARK_GRAY);
			totalnumber.setForeground(Color.WHITE);
			totalnumber.setCaretColor(Color.WHITE);
			min.setBackground(Color.DARK_GRAY);
			min.setForeground(Color.WHITE);
			min.setCaretColor(Color.WHITE);
			max.setBackground(Color.DARK_GRAY);
			max.setForeground(Color.WHITE);
			max.setCaretColor(Color.WHITE);
			base.setBackground(Color.DARK_GRAY);
			base.setForeground(Color.WHITE);
			base.setCaretColor(Color.WHITE);
			for ( int i=0; i < allalbel.length; allalbel[i++].setForeground(Color.WHITE));
		} else {
			credit0.setForeground(Color.BLACK);
			credit1.setForeground(Color.BLACK);
			chooseal.setBackground(null);
			chooseal.setForeground(Color.BLACK);
			choosea2.setBackground(null);
			choosea2.setForeground(Color.BLACK);
			choosea3.setBackground(null);
			choosea3.setForeground(Color.BLACK);
			darkmode.setBackground(null);
			darkmode.setForeground(Color.BLACK);
			totalnumber.setBackground(Color.WHITE);
			totalnumber.setForeground(Color.BLACK);
			totalnumber.setCaretColor(Color.BLACK);
			min.setBackground(Color.WHITE);
			min.setForeground(Color.BLACK);
			min.setCaretColor(Color.BLACK);
			max.setBackground(Color.WHITE);
			max.setForeground(Color.BLACK);
			max.setCaretColor(Color.BLACK);
			base.setBackground(Color.WHITE);
			base.setForeground(Color.BLACK);
			base.setCaretColor(Color.BLACK);
			for ( int i=0; i < allalbel.length; allalbel[i++].setForeground(Color.BLACK));
		}
	}
	public void changecolor() {
		button.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		button.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Generate TRUE random number")) {
			try {
				minimum = Integer.valueOf(min.getText());
				maximum = Integer.valueOf(max.getText());
				total = Integer.valueOf(totalnumber.getText());
				baseofnum = Integer.valueOf(base.getText());
				generateRand(total, minimum, maximum, baseofnum);
			} catch (Exception exceptionx) {
				exceptionx.printStackTrace();
				CheckUpdate.popUp("Please type in integers", "Warning");
			}
		}
		if (s.equals("Native Depiction")) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			new Interface().execute(isdark);
			frame.dispose();
		}
		if (s.equals("Java Depiction")) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
			new Interface().execute(isdark);
			frame.dispose();
		}
		if (s.equals("I don't understand")) {
			new Help().showHelp();
		}
		if (choosea3.isSelected()) {
			for (int i=0; i< stringg.length; stringg[i++].setVisible(true));
			allalbel[2].setText("Length");
			min.setVisible(false);
			base.setVisible(false);
			allalbel[1].setVisible(false);
			allalbel[3].setVisible(false);
			allalbel[0].setText("Total string");
			allalbel[0].setVisible(true);
			totalnumber.setVisible(true);
		} else if (choosea2.isSelected() || chooseal.isSelected()){
			for (int i=0; i< stringg.length; stringg[i++].setVisible(false));
			allalbel[1].setVisible(true);
			allalbel[2].setText("Max");
			min.setVisible(true);
			base.setVisible(true);
			allalbel[3].setVisible(true);
			allalbel[0].setText("Total number");			
			if (choosea2.isSelected()) {
				allalbel[0].setVisible(false);
				allalbel[3].setVisible(false);
				
				totalnumber.setVisible(false);
				base.setVisible(false);

			} else {
				allalbel[0].setVisible(true);
				allalbel[3].setVisible(true);
				totalnumber.setVisible(true);
				base.setVisible(true);
			}
		}
		if(darkmode.isSelected()) {
			UIManager.put("OptionPane.background", Color.DARK_GRAY);
			UIManager.put("Panel.background", Color.DARK_GRAY);
			UIManager.put("OptionPane.messageForeground", Color.WHITE);
			new Interface().execute(true);
			frame.dispose();
		}
		if(lightmode.isSelected()) {
			UIManager.put("OptionPane.background", null);
			UIManager.put("Panel.background", null);
			UIManager.put("OptionPane.messageForeground", Color.BLACK);
			new Interface().execute(false);
			frame.dispose();
		}
	}
	private void printingNumber(String rannum) {
		if (cc>0)
			for (int i=0; i< albel.length; panel.remove(albel[i++]));
		cc++;
		albel = new JLabel[gtr.getArrayList().size()];
		for (int i=0; i< albel.length; albel[i++] = new JLabel());
		for (int i=0; i< albel.length; albel[i++].setFont(new Font("Serif", Font.BOLD, 60)));
		for(int i=0; i < gtr.getArrayList().size(); i++ ){
			albel[i].setText(gtr.getArrayList().get(i));
		}
		new Thread(new Runnable() {
			public void run() {
				for (int i=0; i< albel.length; i++) {
					albel[i].setForeground(Color.GREEN);
					panel.add(albel[i]);
					for (int j =0; j< Integer.valueOf(gtr.getArrayList().get(i)); j++) {
						try {
							Thread.sleep(30);
							albel[i].setText(Integer.toString(j+1));
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
		int f = -50;
		for (int i=0; i< albel.length; albel[i++].setBounds(f+=150, 400, 100,60));
	}
	private void defaultButton() {
		stopc = false;
		button.setBackground(null);
		button.setForeground(null);
		button.setText("Generate TRUE random number");
	}
	private void showing() {
		String display = "";
		for(int i=0; i < gtr.getArrayList().size(); i++ ){
			if ( i != gtr.getArrayList().size() -1)
				display += gtr.getArrayList().get(i) + ", ";
			else
				display += gtr.getArrayList().get(i);       }
		CheckUpdate.popUp(display, "Done!");
		defaultButton();
	}
	private void waitF() {
		try {
			for (int i=10; i >0; i--) {
				Thread.sleep(1000);
				button.setText("Wait for " +i+" second(s) ...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void generateRand(int total, int minimum, int maximum, int baseofnum) {
		stopc = true;
		button.setText("Retrieving TRUE random number from server");
		new Thread(new Runnable() {
			public void run() {
				while (stopc) {
					try {
						changecolor();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				String quota = gtr.QuotaCheck();
				betaalert.setText("status code: " + Integer.toString(gtr.getStatusCode()) + "; Quota: " + quota); 
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				String rannum = "";
				if (chooseal.isSelected()) {
					if (total > 5) {
						showing();
					} else {
						rannum = gtr.getRandomNumber(total, minimum, maximum, baseofnum);
						printingNumber(rannum);
						int winwhat = Integer.parseInt(gtr.getArrayList().get(0));
						double percentage = (winwhat*100/maximum);
						if (percentage >= 90) {
							whatIwin.setText("you earn: + 1 extra credit!");
						} else if (percentage < 90 && percentage >= 80) {
							whatIwin.setText("You earn: 3D-printed model!");
						}else if (percentage < 80 && percentage >= 40){
							whatIwin.setText("You earn: goodies bag!");
						} else if (percentage < 40 && percentage >= 0){
							whatIwin.setText("You earn: a sticker!");
						}
					}
				}
				else if (choosea2.isSelected()) {
					rannum = gtr.sequenceRandomGenerator(minimum, maximum);
					showing();
					defaultButton();
				}
				else {
					String display = "";
					boolean digit = (stringg[3].isSelected());
					boolean uppercase = (stringg[1].isSelected());
					boolean unique = (stringg[0].isSelected());
					boolean lowercase = (stringg[2].isSelected());
					rannum = gtr.randomStringGenrator(total, maximum, digit, uppercase, lowercase, unique);
					for(int i=0; i < gtr.getArrayList().size(); i++ ){
						display += gtr.getArrayList().get(i) + "\n";
					}
					CheckUpdate.popUp(display, "Done!");
					stopc = false;
					defaultButton();
				}
				button.setText("Done");
				stopc = false;
				button.setBackground(Color.BLACK);
				button.setForeground(Color.ORANGE);
				waitF();
				defaultButton();
			}
		}).start();
	}
}

