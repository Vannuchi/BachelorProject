	import java.awt.geom.Point2D;
import java.math.*;

/**
 * @class Static Class used only for instantiation of methods
 */
public final class Localise {
	
	/**
	 * Constructor not used
	 */
	private Localise() {
		
	}
	
	/**
	 * "Main" function, it calls all the other necessary functions to locate the Node.
	 * This function first guess the position of the node using the method @see startEndDevice(),
	 * then it store in a variable called oldPos for then compute a newPos using @see newPositionEd()
	 * after getting this position it does a while, of the least mean square from both oldPos and newPos
	 * and While the least mean square of oldPos is bigger than newPos ( @see leastMeanSquare() )
	 * we store the newPos in the var oldPos and newPos receive the value of newPositionEd with newPos (the oldPos after the previous attribution)
	 * in the end returning a Node newPos being the "most precise" position of the endDevice. 
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node routerB; this is the routerA of the triangle
	 * @param Node routerC; this is the routerA of the triangle
	 * @return Node EndDevice
	 */
	public static Node findEndDevice(Node nA, Node nB, Node nC){
		Node guessedPosition = startEndDevice(nA, nB, nC);
		Node oldPos = guessedPosition;
//		System.out.println(oldPos.getPosition());
		Node newPos = newPositionED(nA, nB, nC,oldPos);
//		System.out.println(newPos.getPosition());
//		System.out.println(oldPos.getPosition());
		double oldPosLms = Math.abs(leastMeanSquare(nA, nB, nC, oldPos));
		double newPosLms = Math.abs(leastMeanSquare(nA, nB, nC, newPos));
//		System.out.println(newPosLms);
//		System.out.println(oldPosLms);
		Boolean flag = true;
		while(flag){
			if((oldPosLms >= newPosLms) && ( (newPos.getPosition().getX() != oldPos.getPosition().getX()) && (newPos.getPosition().getY() != oldPos.getPosition().getY()) ) ){//ERROR IS HERE
//				System.out.println((newPos.getPosition().getX() == oldPos.getPosition().getX()) && (newPos.getPosition().getY() == oldPos.getPosition().getY()));
//				System.out.println(oldPosLms + "   -   " + newPosLms + "   =   " + (oldPosLms-newPosLms));
//				System.out.println(oldPos.getPosition());
				oldPos = newPos;
				newPos = newPositionED(nA, nB, nC, oldPos);
			}else{
				flag = false;
			}
		}
		return oldPos;
	}
	
	
	/**
	 * startEndDevice() is a function created for guessing the first position of the endDevice
	 * it now does the following, between all the three nodes checks which one has the lower distance
	 * and then "copy" its position, assuming it as endDevice Position at this instance.
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node routerB; this is the routerA of the triangle
	 * @param Node routerC; this is the routerA of the triangle
	 * @return Node EndDevice (guess)
	 */
	private static Node startEndDevice(Node nA, Node nB, Node nC){
		Node closestOne = null;
		double newX = (nA.getPosition().getX() + nB.getPosition().getX() + nC.getPosition().getX())/3;
		double newY = (nA.getPosition().getY() + nB.getPosition().getY() + nC.getPosition().getY())/3;
		Point2D position = new Point2D.Double(newX, newY);
		if(nA.getDistance() >= nB.getDistance()){
			if(nB.getDistance() >= nC.getDistance()){
				closestOne = nC;
			}else{
				closestOne = nB;
			}
		}else{
			if(nA.getDistance() >= nC.getDistance()){
				closestOne = nC;
			}else{
				closestOne = nA;
			}
		}
		
//		Point2D newPos = new Point2D.Double(20.0,20.0);
//		Node endDevice = new Node(newPos , 0, 0);
		Node endDevice = new Node(position, 0, 0);
//		System.out.println(endDevice.getPosition());
		return endDevice;
		
	}
	
	
	
	/**
	 * leasMeanSquare() is a function to calculate the least mean square of the three Routers without weigth.
	 * this is used to find the point between the three routers where it is located the EndDevice,
	 * is used in the findEndDevice() to get the minimalized value that should be the most precise point.
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node routerB; this is the routerA of the triangle
	 * @param Node routerC; this is the routerA of the triangle
	 * @param Node EndDevice; this is the routerA of the triangle
	 * @return double least mean square.
	 */
	private static double leastMeanSquare(Node nodeA, Node nodeB, Node nodeC, Node endDevice){
		double errorA = Math.abs(nodeA.getDistance() - Math.pow(Math.sqrt( Math.pow( ( nodeA.getPosition().getX() - endDevice.getPosition().getX() ), 2.0) + Math.pow( ( nodeA.getPosition().getY() - endDevice.getPosition().getY() ), 2.0 ) ) ,2.0) );
		double errorB = Math.abs(nodeB.getDistance() - Math.pow(Math.sqrt( Math.pow( ( nodeB.getPosition().getX() - endDevice.getPosition().getX() ), 2.0) + Math.pow( ( nodeB.getPosition().getY() - endDevice.getPosition().getY() ), 2.0 ) ) ,2.0) );
		double errorC = Math.abs(nodeC.getDistance() - Math.pow(Math.sqrt( Math.pow( ( nodeC.getPosition().getX() - endDevice.getPosition().getX() ), 2.0) + Math.pow( ( nodeC.getPosition().getY() - endDevice.getPosition().getY() ), 2.0 ) ) ,2.0) );
		double result = ((1-(nodeA.getDevError())) * errorA) + ((1-(nodeB.getDevError())) * errorB) + ((1-(nodeC.getDevError())) * errorC);
		return result;
		
	}

	
	/**
	 * newPositionED() is the function responsible to calculate the newPositiong using gradiant descent,
	 * it determines the tangent that should be followed and then compute the new point.
	 * It calculates the newPos = oldPos - Alpha * (df/dx) 
	 * and the same for (df/dy), where (df/dx) and (df/dy) are the derivatives of the leastMeanSquare in relation to x and to y.
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node routerB; this is the routerA of the triangle
	 * @param Node routerC; this is the routerA of the triangle
	 * @param Node EndDevice; this is the routerA of the triangle
	 * @return Node EndDevice with new position.
	 */
	private static Node newPositionED(Node routerA, Node routerB, Node routerC, Node endDevice){
		double alpha = 0.01;
		double derOfX = derivativeOfX(routerA, endDevice) + derivativeOfX(routerB, endDevice) + derivativeOfX(routerC, endDevice);
		double derOfY = derivativeOfY(routerA, endDevice) + derivativeOfY(routerB, endDevice) + derivativeOfY(routerC, endDevice);
		Point2D difVector = new Point2D.Double(alpha * derOfX, alpha * derOfY);
		Point2D newPoint = new Point2D.Double(endDevice.getPosition().getX() - difVector.getX(), endDevice.getPosition().getY() - difVector.getY());
		
		Node result = new Node(newPoint, 0, 0);
		return result;
	}
	
	/**
	 * derivativeOfX() its just calculate the function of the derivative of leastMeanSquare() and apply it in relation to x
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node EndDevice; this is the routerA of the triangle
	 * @return double newX position after the function on @see newPositionEd()
	 */
	private static double derivativeOfX(Node routerA, Node endDevice){
		double upperPart = 2 * (routerA.getPosition().getX() - endDevice.getPosition().getX() ) * (routerA.getDistance() - Math.sqrt( Math.pow(routerA.getPosition().getY() - endDevice.getPosition().getY(), 2.0 ) + Math.pow(routerA.getPosition().getX() - endDevice.getPosition().getX(),2.0) ) );
		double lowerPart = Math.sqrt( Math.pow(routerA.getPosition().getY() - endDevice.getPosition().getY() , 2.0) + Math.pow(routerA.getPosition().getX() - endDevice.getPosition().getX(), 2.0) );
		double result = upperPart/lowerPart;
//		System.out.println("Upper: " + upperPart + " Lower: " + lowerPart + " Result: " + result);
		if(upperPart == 0.0 || lowerPart == 0.0){
			return 0.0;
		}
		return result;
	}

	/**
	 * derivativeOfY() its just calculate the function of the derivative of leastMeanSquare() and apply it in relation to y
	 *
	 * @param Node routerA; this is the routerA of the triangle 
	 * @param Node EndDevice; this is the routerA of the triangle
	 * @return double newY position after the function on @see newPositionEd()
	 */
	private static double derivativeOfY(Node routerA, Node endDevice){
		double upperPart = 2 * (routerA.getPosition().getY() - endDevice.getPosition().getY() ) * (routerA.getDistance() - Math.sqrt( Math.pow(routerA.getPosition().getX() - endDevice.getPosition().getX(), 2.0 ) + Math.pow(routerA.getPosition().getY() - endDevice.getPosition().getY(),2.0) ) );
		double lowerPart = Math.sqrt( Math.pow(routerA.getPosition().getX() - endDevice.getPosition().getX() , 2.0) + Math.pow(routerA.getPosition().getY() - endDevice.getPosition().getY(), 2.0) );
		double result = upperPart/lowerPart;
		if(upperPart == 0.0 || lowerPart == 0.0){
			return 0.0;
		}
		return result;
	}
	
}
