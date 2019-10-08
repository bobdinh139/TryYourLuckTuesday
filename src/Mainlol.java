

public class Mainlol {
  public static void main(String args[]) {
	  Interface UI = new Interface();
	  CheckUpdate ccu= new CheckUpdate();
		try {
			ccu.checkup();
		} catch (Exception e) {
			e.printStackTrace();

		}
	  UI.execute(false);
	  
  }
	
}
