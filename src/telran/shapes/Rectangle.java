package telran.shapes;

public class Rectangle extends Shape {
	private int width;
	private int height;
	

	public Rectangle(long id, int width, int height) {
		super(id);
		this.width = width;
		this.height = height;}
	
	

	public Rectangle(long id, int width) {
		super(id);
		this.width = width;
		this.height = width;}



	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}



	@Override
	public int square() {		
		return height*width;
	}

	@Override
	public int perimeter() {		
		return (height+width)*2;
	}

	
}
