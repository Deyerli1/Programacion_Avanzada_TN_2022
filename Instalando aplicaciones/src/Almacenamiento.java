import java.util.ArrayList;

public class Almacenamiento {
	private int appSize;
	private ArrayList<Aplicacion> apps;

	Almacenamiento(int appSize, ArrayList<Aplicacion> apps) {
		this.appSize = appSize;
		this.apps = apps; // this is valid. List = List is valid
	}

	public Aplicacion deleteSpace() throws Exception {
		Aplicacion purged = new Aplicacion(0,0);
		int totalAvailableSpace = 0;
		for (Aplicacion app : apps) {
			totalAvailableSpace += app.getOriginalSize();
		}
		if (totalAvailableSpace < appSize) {
			throw new Exception("No hay espacio");
		}
		int i = 0;
		while (true) {

			int maxSizeFound = 0;
			for (Aplicacion app : apps) {
				int currentSize = app.getContinousSize();
				int nextIndex = apps.indexOf(app) + i;

				if (nextIndex >= apps.size()) {
					break;
				}

				currentSize += apps.get(nextIndex).getOriginalSize();
				app.setContinousSize(currentSize);
				app.setIndex(i);
				if (maxSizeFound < currentSize) {
					maxSizeFound = currentSize;
					purged = app;
				}
			} // CC de estos ciclos?
			if (maxSizeFound >= appSize) {
				break;
			} else {
				i++;
			}

		}
		return purged;
	}
}
