import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import xyz.null0verflow.librandomorgclient.TooManyRequest;
public class Interface extends ActuallyInterface implements ActionListener{
	private static final long serialVersionUID = 1L;
	private boolean click = false;

	// add listeners 
	public Interface(boolean isdark) {
		super(isdark);
		darkmode.addActionListener(this);
		lightmode.setVisible(isdark);
		lightmode.addActionListener(this);
		atmosphericNoise.addActionListener(this);
		radioactivedecay.addActionListener(this);
		choosea3.addActionListener(this);
		choosea2.addActionListener(this);
		chooseal.addActionListener(this);
		button.addActionListener(this);
		idontunderstand.addActionListener(this);
		nativedepiction.addActionListener(this);
		javadepiction.addActionListener(this);
		for (int i=0; i< stringg.length; (stringg[i++]).addActionListener(this));
	}

	// change color for the generate random button
	private void changecolor() {
		button.setForeground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
		button.setBackground(new Color(0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1)), 0 + (int)(Math.random() * ((255 - 0) + 1))));
	}
	// When anything is clicked 
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Generate TRUE random number")) {
			click = !click;

			try {
				if (atmosphericNoise.isSelected())
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
		if (radioactivedecay.isSelected()) {
			radioactiveSelect();
		} else if (atmosphericNoise.isSelected()) {
			atmosphericSelect();
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

	// convert raw number from 0-255 to 0-20 and check dups, print number out
	private void convertNumber(JSONArray arr) {
		int number[] = new int[arr.size()];
		for (int i=0; i < arr.size(); i++) {
			number[i] = Integer.valueOf(String.valueOf(arr.get(i)));
		}
		for (int i=0; i < number.length;i++) {
					Random r = new Random(number[i]);
					number[i] = r.nextInt((20 - 0) + 1) + 0;
		}

		if (!checkDuplicates(number)) {
			printingNumber(number);
		} else {
			String[] options = new String[2];
			options[1] = new String("Force-Override");
			options[0] = new String("Close");
			int result = foundDups(options, "Duplicates found, please re-generate!\nDue to popular demand, the numbers will not be shown!\n", "Duplicates detected");
			if(result == JOptionPane.NO_OPTION){
				printingNumber(number);
			}
		}
		winWhat(number[0]);

	}

	// checking duplicates for radioactive decay
	private boolean checkDuplicates(int arr[]) {
		int c =1;
		for(int i=0; i < arr.length; i++ ){
			int a =  arr[i];
			for(int j=c; j < arr.length; j++ ) {
				if (a == arr[j]) {
					return true;
				}
			}
			c++;
		}
		return false;
	}

	// checking duplicates for atmospheric noise
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

	// calculate what you win
	private void winWhat(int winwhat) {
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

	// print out numbers for radioactive decay
	private void printingNumber(int arr[]) {
		if (cc>0)
			for (int i=0; i< albel.length; panel.remove(albel[i++]));
		cc++;
		albel = new JLabel[arr.length];
		for (int i=0; i< albel.length; albel[i++] = new JLabel());
		for (int i=0; i< albel.length; albel[i++].setFont(new Font("Serif", Font.BOLD, 60)));
		for(int i=0; i < arr.length; i++ ){
			albel[i].setText(String.valueOf(arr[i]));
		}
		new Thread(new Runnable() {
			public void run() {
				for (int i=0; i< albel.length; i++) {
					albel[i].setForeground(Color.GREEN);
					panel.add(albel[i]);
					for (int j =-1; j<= Integer.valueOf(arr[i]); j++) {
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

	// print number for atmospheric noise
	private void printingNumber() {
		if (cc>0)
			for (int i=-1; i< albel.length; panel.remove(albel[i++]));
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

	// reset the generate button to default
	private void defaultButton() {
		stopc = false;
		button.setBackground(null);
		button.setForeground(null);
		button.setText("Generate TRUE random number");
	}

	// display random data if there are more than 5 numbers or they are sequences or they are strings
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

	// cool down before each request
	private void waitF() {
		try {
			for (int i=10; i >0; i--) {
				Thread.sleep(1000);
				button.setText("Wait for " +i+" second(s) ...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			CheckUpdate.popUp(e.toString(), "Error");
		}
		click = !click;
	}

	// display cool down
	private void buttonWaitDisplay() {
		button.setText("Done");
		stopc = false;
		button.setBackground(Color.BLACK);
		button.setForeground(Color.ORANGE);
		waitF();
		defaultButton();
	}

	//showing library output for quota, etc
	private void displayOutput(boolean isDecay, String data) {
		new Thread(new Runnable() {
			public void run() {
				while(stopc) {
					String quota  = "";
					String sCode ="";
					JSONArray rawnum = null ;
					if (!isDecay) {
						try {
							quota = gtr.QuotaCheck();
						} catch (TooManyRequest | IOException e) {
							e.printStackTrace();
							CheckUpdate.popUp(e.toString(), "Error");
						}
						sCode = "status code: " + Integer.toString(gtr.getStatusCode());
					}else {
						quota = rade.parseURl(data, "quotaRequestsRemaining");
						sCode = "Quota bytes: "+rade.parseURl(data, "quotaBytesRemaining");
						try {
							rawnum = rade.getRandom(data);
						} catch (ParseException e) {
							e.printStackTrace();
							CheckUpdate.popUp(e.toString(), "Error");
						}
					}
					betaalert.setText("<html>" + sCode + "; Quota: "+quota+"<br/>" + gtr.getOutput() + "<br/>"+rawnum+"</html>"); 
				}
			}
		}).start();
	}
	// Generate random number
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
						CheckUpdate.popUp(e.toString(), "Error");
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				String rannum = "";
				if (radioactivedecay.isSelected()) {
					String data= "";
					try {
						data = rade.getDataFromServer(Integer.toString(total), min.getText());
					} catch (Exception e) {
						e.printStackTrace();
						CheckUpdate.popUp(e.toString(), "Error!");
					}
					displayOutput(true, data);
					try {
						if (total > 5)
							CheckUpdate.popUp(rade.getRandom(data).toString(), "Done!");
						else
							convertNumber(rade.getRandom(data));
					} catch (ParseException e) {
						e.printStackTrace();
						CheckUpdate.popUp(e.toString(), "Error!");
					}
				}
				else if (atmosphericNoise.isSelected()) {
					displayOutput(false, "");
					if (chooseal.isSelected()) {
						try {
							rannum = gtr.getRandomNumber(total, minimum, maximum, baseofnum);
							if (total > 5 || baseofnum !=10) {
								showing();
								buttonWaitDisplay();
								return;
							}
						} catch (TooManyRequest | IOException e) {
							CheckUpdate.popUp(e.toString(), "Error!");
							e.printStackTrace();
							stopc = false;
							return;
						}
						if(!checkDuplicates())
							printingNumber();
						else {
							String[] options = new String[2];
							options[1] = new String("Force-Override");
							options[0] = new String("Close");
							int result = foundDups(options, "Duplicates found, please re-generate!\nDue to popular demand, the numbers will not be shown!\n", "Duplicates detected");

							if(result == JOptionPane.NO_OPTION){
								printingNumber();
							}
						}
						System.out.println(rannum);
						winWhat(Integer.parseInt(gtr.getArrayList().get(0)));
					}
					else if (choosea2.isSelected()) {
						try {
							rannum = gtr.sequenceRandomGenerator(minimum, maximum);
						} catch (TooManyRequest | IOException e) {
							CheckUpdate.popUp(e.toString(), "Error!");
							e.printStackTrace();
							stopc = false;
							return;
						}
						showing();
						defaultButton();
					}
					else {
						String display = "";
						boolean digit = (stringg[3].isSelected());
						boolean uppercase = (stringg[1].isSelected());
						boolean unique = (stringg[0].isSelected());
						boolean lowercase = (stringg[2].isSelected());
						try {
							rannum = gtr.randomStringGenrator(total, maximum, digit, uppercase, lowercase, unique);
						} catch (TooManyRequest | IOException e) {
							CheckUpdate.popUp(e.toString(), "Error!");
							e.printStackTrace();
							stopc = false;
							return;
						}
						for(int i=0; i < gtr.getArrayList().size(); i++ ){
							display += gtr.getArrayList().get(i) + "\n";
						}
						CheckUpdate.popUp(display, "Done!");
						stopc = false;
						defaultButton();
					}
				}
				buttonWaitDisplay();
			}
		}).start();

	}
}
