package telran.shapes.tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import telran.shapes.Shape;
import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Square;

class ShapeTests {
	
	
	@Test
	void shapeTest() {	
		Shape shapeRectangle = new Rectangle(115,5,6);	
		
		assertEquals (30, shapeRectangle.square());
		assertEquals (22, shapeRectangle.perimeter());
		
		Shape shapeSquare = new Square (118,6);
		
		assertEquals (36, shapeSquare.square());
		assertEquals (24, shapeSquare.perimeter());
		
		
		Shape shapeRectangleSquare = new Rectangle(5,6);	
		assertFalse (shapeRectangleSquare.square()==30);
		assertTrue (shapeRectangleSquare.square()==36);	
	
		
	}

	@Test
	void canvasTests() {
		Shape[] shapes = {};
		Canvas canvas = new Canvas(1, shapes);
		
		Shape shapeRectangle1 = new Rectangle(115,5,6);	
		Shape shapeRectangle2 = new Rectangle(116,6,7);	
		Shape shapeSquare1 = new Rectangle(117,5);	
		Shape shapeSquare2 = new Rectangle(101,3);
		
		canvas.addShape(shapeRectangle1);	
		canvas.addShape(shapeRectangle2);	
		canvas.addShape(shapeSquare1);	
		
		
		Shape[] expected = {shapeRectangle1, shapeRectangle2, shapeSquare1};
		Shape[] actual = canvas.getShapes();
		
		assertArrayEquals(expected,actual);
		
		assertEquals(97, canvas.square());
		assertEquals(68, canvas.perimeter());
		
		canvas.addShape(shapeSquare2);	
		Shape[] expected2 = {shapeRectangle1, shapeRectangle2, shapeSquare1,shapeSquare2 };
		Shape[] actual2 = canvas.getShapes();
		assertArrayEquals(expected2,actual2);
		
		canvas.removeShape(117);
		Shape[] expected3 = {shapeRectangle1, shapeRectangle2, shapeSquare2 };
		Shape[] actual3 = canvas.getShapes();
		assertArrayEquals(expected3,actual3);
		
		assertEquals(81, canvas.square());
		assertEquals(60, canvas.perimeter());
		
		canvas.removeShape(119);		
		Shape[] actual4 = canvas.getShapes();
		assertArrayEquals(expected3,actual4);
		
		assertEquals(81, canvas.square());
		assertEquals(60, canvas.perimeter());
		
		canvas.removeShape(115);
		canvas.removeShape(116);
		canvas.removeShape(117);
		canvas.removeShape(101);
		//trying to remove something from empty array
		canvas.removeShape(115);
		
		Shape[] expected5 = {};
		Shape[] actual5 = canvas.getShapes();
		assertArrayEquals(expected5,actual5);
		
		assertEquals(0, canvas.square());
		assertEquals(0, canvas.perimeter());
		
		//checking weather shapes still "alive" after removing from array
		canvas.addShape(shapeRectangle1);		
		Shape[] expected6 = {shapeRectangle1};
		Shape[] actual6 = canvas.getShapes();
		
		assertArrayEquals(expected6,actual6);
		
		assertEquals(30, canvas.square());
		assertEquals(22, canvas.perimeter());
		
		//trying add and delete shape with a not unic id
		
		Shape shapeRectangle3 = new Rectangle(115,10,11);
		canvas.addShape(shapeRectangle3);
		Shape[] expected7 = {shapeRectangle1, shapeRectangle3};
		Shape[] actual7 = canvas.getShapes();
		assertArrayEquals(expected7,actual7);
		
		canvas.removeShape(115);
		
		
		
	}
	@Test
	void canvasInCanvasTests() {//checking, if algorithm uses all shapes in array, including shapes in the inner array(canvas)
		Shape[] shapes = {};
		Canvas canvas = new Canvas(1, shapes);
		
		Shape shapeRectangle1 = new Rectangle(115,5,6);	
		Shape shapeRectangle2 = new Rectangle(116,6,7);	
		Shape shapeSquare1 = new Rectangle(117,5);	
		Shape shapeSquare2 = new Rectangle(101,3);
		
		canvas.addShape(shapeRectangle1);	
		canvas.addShape(shapeRectangle2);	
		canvas.addShape(shapeSquare1);	
		
		Canvas canvas2 = new Canvas(2, shapes);
		canvas2.addShape(shapeSquare2);
		canvas2.addShape(canvas);
		
		Shape[] expected = {shapeSquare2, canvas };
		Shape[] actual = canvas2.getShapes();
		assertArrayEquals(expected,actual);
		
		assertEquals(106, canvas2.square());
		assertEquals(80, canvas2.perimeter());
		
	}
	@Test
	void removingTests() { //checking, if algorithm removes all elements with same id
		Shape[] shapes = {};
		Canvas canvas = new Canvas(1, shapes);
		
		Shape shapeRectangle1 = new Rectangle(115,5,6);	
		Shape shapeRectangle2 = new Rectangle(116,6,7);	
		Shape shapeSquare1 = new Rectangle(117,5);	
		Shape shapeSquare2 = new Rectangle(101,3);
		
		canvas.addShape(shapeRectangle1);	
		canvas.addShape(shapeRectangle2);	
		canvas.addShape(shapeSquare1);
		canvas.addShape(shapeSquare2);
		canvas.addShape(shapeSquare2);
		
		
		Shape[] expected = {shapeRectangle1, shapeRectangle2, shapeSquare1, shapeSquare2, shapeSquare2};
		Shape[] actual = canvas.getShapes();
		
		assertArrayEquals(expected,actual);
		
		canvas.removeShape(101);
		Shape[] expected1 = {shapeRectangle1, shapeRectangle2, shapeSquare1};
		Shape[] actual1 = canvas.getShapes();
		assertArrayEquals(expected1,actual1);
	}
	
}
