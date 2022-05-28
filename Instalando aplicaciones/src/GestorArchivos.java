import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorArchivos {
	private String path;
	private int size;
	private ArrayList<Aplicacion> apps;
	
	GestorArchivos(String path){
		this.path = path;
	}
	
	public void readFile() {
		try {
			Scanner refarch = new Scanner(new File(path));
			int total_apps = refarch.nextInt();
			apps = new ArrayList<Aplicacion>();
			size = refarch.nextInt();
			
			for (int i = 0; i < total_apps; i++) {
				apps.add(new Aplicacion(refarch.nextInt(),i));
			}
			refarch.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeFile(String path, Aplicacion solution) {
		try {
			FileWriter f = new FileWriter(path);
			PrintWriter output= new PrintWriter(f);
			output.println(solution.getIndex()+1);
			output.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Aplicacion> getApps() {
		return apps;
	}
	
}
