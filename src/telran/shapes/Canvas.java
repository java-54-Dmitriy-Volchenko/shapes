package telran.shapes;


import java.util.function.Predicate;

import telran.util.shapes.Utilites;

public class Canvas extends Shape {
	private Shape[] shapes;
	
	
	public Canvas(long id, Shape[] shapes) {
		super(id);
		this.shapes = shapes;
	}
	
	public Shape[] addShape(Shape shape) {
		shapes = Utilites.add(shapes, shape); 
		return shapes;
		
	}	

	public Shape[]removeShape(long id) {
        Predicate<Shape> predicate = shape -> shape.getId() ==id;
    	shapes = Utilites.removeIf(shapes, predicate);
		return shapes;
	
	}

	 public Shape[] getShapes() {
		 
		return shapes;
	}

	public void setShapes(Shape[] shapes) {
		this.shapes = shapes;
	}

	public int square() {
	        int resSquare = 0;
	        for (Shape shape : shapes) {
	            resSquare += shape.square();
	        }
	        return resSquare;
	    }

	    @Override
	    public int perimeter() {
	        int resPerimeter = 0;
	        for (Shape shape : shapes) {
	            resPerimeter += shape.perimeter();
	        }
	        return resPerimeter;
	    }

	
	}
	