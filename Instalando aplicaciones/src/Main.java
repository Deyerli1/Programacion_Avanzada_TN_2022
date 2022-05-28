
public class Main {
	public static void main(String[] args) {
		String path = "data.in";
		GestorArchivos file = new GestorArchivos(path);
		file.readFile();
		file.getApps();
		file.getSize();
		Almacenamiento pepe = new Almacenamiento(file.getSize(), file.getApps());
		try {
			Aplicacion sol = pepe.deleteSpace();
			file.writeFile("data.out", sol);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
}
