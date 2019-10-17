import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Help extends JPanel {

	private static final long serialVersionUID = 1L;
	private Stage stage;  
	private WebView browser;  
	private JFXPanel jfxPanel;  
	private WebEngine webEngine;  
	private JFrame frame;

	public Help(){  
		jfxPanel = new JFXPanel();  
		PlatformImpl.startup(new Runnable() {  
			@Override
			public void run() {  
				ProgressBar progressBar = new ProgressBar();

				stage = new Stage();  

				Group root = new Group();  
				Scene scene = new Scene(root,80,20);  
				stage.setScene(scene);  

				browser = new WebView();
				webEngine = browser.getEngine();
				webEngine.load("https://www.random.org/clients/http/");

				ObservableList<Node> children = root.getChildren();
				Worker<Void> worker = webEngine.getLoadWorker();
				progressBar.progressProperty().bind(worker.progressProperty());
				progressBar.setPrefSize(770, 10);
				children.addAll(browser,progressBar);                                        

				jfxPanel.setScene(scene);  
			}  
		}); 
		setLayout(new BorderLayout());  
		add(jfxPanel, BorderLayout.CENTER);       
	}  

	public void showHelp() {

		SwingUtilities.invokeLater(new Runnable() {  
			@Override
			public void run() {  
				frame = new JFrame("Help");  
				frame.getContentPane().add(new Help());  
				frame.setMinimumSize(new Dimension(800, 600));  
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);  
				frame.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent evt) {
						frame.dispose();
					}
				});
				frame.setVisible(true);  
			}  
		});    

	}

}
