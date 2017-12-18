//Each object of the shape class is either a circle, square, or triangle
//There is one dimension, it represent radius if the shape is a circle, or side length if it's a square or triangle
//Two methods, getType and getArea
//Don't need to add getDimension because that can be deduced from type and area

public class Shape {
	
	public static String[] possibleTypes = {"Circle", "Square", "Triangle"};
	private String type;
	private double dimension;
	
	public Shape(){
		int r = (int)(Math.random()*possibleTypes.length);
		type = possibleTypes[r];
		dimension = Math.random()*10;
	}
	
	public Shape(String type){
		this.type = type;
		dimension = 1.0;
	}
	
	public Shape(String type, double dimension){
		this.type = type;
		this.dimension = dimension;
	}
	
	public String getType(){
		return type;
	}
	
	public double getArea(){
		if (type.equals(possibleTypes[0])){ //shape is a circle
			return Math.PI*dimension*dimension;
		} else if (type.equals(possibleTypes[1])){ //shape is a square
			return dimension*dimension;
		}  else { //shape is a triangle
			return (Math.sqrt(3)/4.0)*dimension*dimension;
		}
	}

}
