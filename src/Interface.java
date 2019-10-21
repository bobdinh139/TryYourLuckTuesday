import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class Interface extends ActuallyInterface implements ActionListener{
	private static final long serialVersionUID = 1L;
	private boolean click = false;
	public Interface(boolean isdark) {
		super(isdark);
		darkmode.addActionListener(this);
		lightmode.setVisible(isdark);
		lightmode.addActionListener(this);
		choosea3.addActionListener(this);
		choosea2.addActionListener(this);
		chooseal.addActionListener(this);
		button.addActionListener(this);
		idontunderstand.addActionListener(this);
		nativedepiction.addActionListener(this);
		javadepiction.addActionListener(this);
		for (int i=0; i< stringg.length; (stringg[i++]).addActionListener(this));
	}

	private void changecolor() {
		button.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		button.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Generate TRUE random number")) {
			click = !click;
			try {
				minimum = Integer.valueOf(min.getText());
				maximum = Integer.valueOf(max.getText());
				total = Integer.valueOf(totalnumber.getText());
				baseofnum = Integer.valueOf(base.getText());
				if ( (baseofnum != 10) && (baseofnum != 2) && (baseofnum !=16) && (baseofnum !=8)) {
					CheckUpdate.popUp("Base should be 2 or 8 or 10 or 16", "Warning");
					return;
				}
				generateRand(total, minimum, maximum, baseofnum);
			} catch (Exception exceptionx) {
				exceptionx.printStackTrace();
				CheckUpdate.popUp("Please use integers", "Warning");
			}
		}
		if (s.equals("Native Depiction")) {
			if(!click)
				toggleNativeDepic();
			else 
				CheckUpdate.popUp("Wait for the cooldown", "Action can't be done");
		}
		if (s.equals("Java Depiction")) {
			if(!click)
				toggleJavaDepic();
			else 
				CheckUpdate.popUp("Wait for the cooldown", "Action can't be done");
		}
		if (s.equals("I have doubts")) {
			new Help().showHelp();
		}
		if (choosea3.isSelected()) {
			choosechoose3();
		} else if (choosea2.isSelected() || chooseal.isSelected()){
			choose1or2();		
			if (choosea2.isSelected()) {
				choose2();

			} else {
				choose1();
			}
		}
		if(darkmode.isSelected()) {
			if(!click)
				togglenight();
			else 
				CheckUpdate.popUp("Wait for the cooldown", "Action can't be done");
		}
		if(lightmode.isSelected()) {
			if(!click)
				togglelight();
			else 
				CheckUpdate.popUp("Wait for the cooldown", "Action can't be done");
		}
	}

	private boolean checkDuplicates() {
		int c =1;
		for(int i=0; i < gtr.getArrayList().size(); i++ ){
			String a =  gtr.getArrayList().get(i);
			for(int j=c; j < gtr.getArrayList().size(); j++ ) {
				if (a.equals(gtr.getArrayList().get(j))) {
					return true;
				}
			}
			c++;
		}
		return false;
	}

	private void winWhat() {
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
					for (int j =0; j<= Integer.valueOf(gtr.getArrayList().get(i)); j++) {
						try {
							Thread.sleep(30);
							albel[i].setText(Integer.toString(j));
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
				display += gtr.getArrayList().get(i);       
		}
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
		click = !click;
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
				String rannum = "";
				if (chooseal.isSelected()) {
					if (total > 5 || baseofnum !=10) {
						showing();
					} else {
						rannum = gtr.getRandomNumber(total, minimum, maximum, baseofnum);
						if(!checkDuplicates())
							printingNumber(rannum);
						else {
							String[] options = new String[2];
							options[1] = new String("Force-Override");
							options[0] = new String("Close");
							int result = JOptionPane.showOptionDialog(
									frame,
									"Duplicates found, please re-generate!\nDue to popular demand, the numbers will not be shown!\n", 
									"Duplicates detected",            
									JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null,     
									options,  
									options[0] 
									);

							if(result == JOptionPane.NO_OPTION){
								printingNumber(rannum);
							}
						}
						System.out.println(rannum);
						winWhat();
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
		new Thread(new Runnable() {
			public void run() {
				while(stopc) {
					String quota = gtr.QuotaCheck();
					String sCode = Integer.toString(gtr.getStatusCode());
					betaalert.setText("<html>status code: " + sCode + "; Quota: "+quota+"<br/>" + gtr.getOutput() + "</html>"); 
				}
				if (gtr.getStatusCode()==503) {
					CheckUpdate.popUp("Too many requests\nWait for 10 mins to a day if this continues", "Error 503");
				}

			}
		}).start();
	}
}
