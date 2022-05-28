
public class Aplicacion {
	private int originalSize;
	private int continousSize;
	private int index;
	
	Aplicacion(int originalSize, int index){
		this.originalSize = originalSize;
		this.index = index;
		continousSize = 0;
	}

	public int getContinousSize() {
		return continousSize;
	}

	public void setContinousSize(int continousSize) {
		this.continousSize = continousSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getOriginalSize() {
		return originalSize;
	}

}
