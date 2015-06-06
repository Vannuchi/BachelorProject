import java.awt.geom.Point2D;


/**
 * Definition of Class
 *
 * @class This class is the structure of the Nodes for localization, bing used for Routers and EndDevices.
 * 
 */
public class Node {
	public Point2D position;
	public double distance;
	public double devError;
	
	/**
	 * Node Constructor
	 *
	 * @param Point2D Position 
	 * @param double Distance
	 * @param double DeviationError
	 * @return constructor (Node Object)
	 */
	public Node(Point2D position, double distance, double devError) {
		this.position = position;
		this.distance = distance;
		this.devError = devError;
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setPosition(Point2D position) {
		this.position = position;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDevError() {
		return devError;
	}
	
	public void setDevError(double devError) {
		this.devError = devError;
	}

}
