import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class CheckUpdate extends JPanel {
	private static final long serialVersionUID = 1L;
	private boolean stillqm = true;
	private String todis = "Checking for updates";
	private JFrame frameH; 
	private DrawCheck drc;
	private final Timer t;
	private boolean check = true;
	public CheckUpdate(){
		frameH = new JFrame("Checking update"); 
		drc= new DrawCheck(frameH);
		t = new Timer(10, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//updating variables 
				drc.changec(todis);
				frameH.repaint();
			}
		});
		t.start();
	}
	public static void popUp(String todis, String title) {
			JOptionPane.showMessageDialog((Component) null, todis,
					title, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void toRepaint(String todis) {
		drc.changec(todis);
		frameH.repaint();
	}

	public void closeUpWindow() {
		frameH.setVisible(false);  
		frameH.dispose();
		stillqm = false;
	}

	public void checkup() throws Exception {

		frameH.getContentPane().add(BorderLayout.CENTER, drc); 
		frameH.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frameH.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				stillqm = false;
				check = false;
				frameH.dispose();
			}
		});
		frameH.setResizable(false);
		frameH.setSize(300, 300); 	
		frameH.setLocationRelativeTo(null);
		frameH.setVisible(true);  

		while (stillqm) {
			try {
			} catch(Exception e) {
				e.printStackTrace();
			}
			toRepaint(todis);
			int cheee = drc.getVersion(); 
			BufferedReader br = null;
			StringBuilder fromcom = new StringBuilder();
			try {
				long tStart = System.currentTimeMillis();
				URL url = new URL("https://raw.githubusercontent.com/bobdinh139/HostImage/master/tryYourLuckTuesday/currentVersion.txt");
				br = new BufferedReader(new InputStreamReader(url.openStream()));
				String line;
				while (((line = br.readLine()) != null) &&check) {
					toRepaint(todis);
					long tEnd = System.currentTimeMillis();
					if ((tEnd - tStart)/1000.0 >= (10)) {
						todis = "Error checking update: Timed out!";
						System.out.println(todis);
						popUp(todis, "Update");
						toRepaint(todis);
						closeUpWindow();
						return;
					}

					fromcom.append(line);
				}
				if (!check) {
					return;
				}
				t.stop();
			}catch (Exception e) {
				todis = "Error: Cannot connect to server!";
				System.out.println(todis);
				popUp(todis,"Update");
				toRepaint(todis);
				closeUpWindow();
				return ;
			} finally {
				if (br != null) {
					br.close();
				}
			} 
			int c =Integer.valueOf(fromcom.toString());
			int d = cheee;
			if (c > d) {
				todis = "New version is available";
				System.out.println(todis + "current version: "+ d +"; newest version: "+ c);
				toRepaint(todis);
				if (JOptionPane.showConfirmDialog((Component) null, "Newer version is available Do you want to update?\nNewest version: " +c+" your version: "+d,
						"Confirm", JOptionPane.YES_NO_OPTION) ==0) {
					todis = "Updating...";
					System.out.println("Updating");
					toRepaint(todis);
					updatedapro();

				} else
					closeUpWindow();
			}
			else {
				System.out.println("No new updates " + "current version: "+ d +"; newest version: "+ c);
				popUp("No new updates","Update");
				closeUpWindow();

			}

		}

	}
	
	private void updatedapro() {
       popUp("Updater and hash-checker are not yet developed because I am too lazy\nPlease update it manually", "Couldn't automatically get update");

	}
}