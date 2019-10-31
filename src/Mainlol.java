

public class Mainlol {
	public static void main(String args[]) {
		new Interface(false);
		String version = System.getProperty("java.version");
		System.out.println(version);
        if (!version.equals("1.8.0_211")) {
        	CheckUpdate.popUp("Please use java 8\nIf you don't, the code will not execute correctly!", "incompatible java version detected");
        }
		CheckUpdate ccu= new CheckUpdate();
		try {
			ccu.checkup();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
