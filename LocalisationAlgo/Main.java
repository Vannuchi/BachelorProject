import java.awt.List;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

	
	/**
	 * Main; we declare the three nodes of the triangle and we create the EndDevice calling the function
	 * of the static class Localize using the function findEndDevice() that uses the 3 Routers previously declared.
	 * then printing in the console the supposed position.
	 */
	public static void main(String[] args) {
		Node nA, nB, nC, eD;
		
		HashMap<Integer, Node> mapOfNodesPerAngles = new HashMap<>();
		
		mapOfNodesPerAngles.put(0, (new Node(new Point2D.Double(1,11), 9.97, 0.02)));
		mapOfNodesPerAngles.put(10, (new Node(new Point2D.Double(1.15,12.74), 9.91, 0.02)));
		mapOfNodesPerAngles.put(20, (new Node(new Point2D.Double(1.6,14.42), 9.89, 0.02)));
		mapOfNodesPerAngles.put(30, (new Node(new Point2D.Double(2.34,16), 9.87, 0.03)));
		mapOfNodesPerAngles.put(40, (new Node(new Point2D.Double(3.34,17.43), 9.79, 0.03)));
		mapOfNodesPerAngles.put(50, (new Node(new Point2D.Double(4.57,18.66), 9.72, 0.01)));
		mapOfNodesPerAngles.put(60, (new Node(new Point2D.Double(6, 19.66), 9.87, 0.02)));
		mapOfNodesPerAngles.put(70, (new Node(new Point2D.Double(7.58,20.4), 10, 0.02)));
		mapOfNodesPerAngles.put(80, (new Node(new Point2D.Double(9.26,20.85), 10.19, 0.02)));
		mapOfNodesPerAngles.put(90, (new Node(new Point2D.Double(11,21), 9.8, 0.02)));
		mapOfNodesPerAngles.put(100, (new Node(new Point2D.Double(12.74,20.85), 9.96, 0.03)));
		mapOfNodesPerAngles.put(110, (new Node(new Point2D.Double(14.42,20.4), 10.03, 0.03)));
		mapOfNodesPerAngles.put(120, (new Node(new Point2D.Double(16,19.66), 9.55, 0.02)));
		mapOfNodesPerAngles.put(130, (new Node(new Point2D.Double(17.43,18.66), 10.12, 0.07)));
		mapOfNodesPerAngles.put(140, (new Node(new Point2D.Double(18.66,17.43), 9.56, 0.07)));
		mapOfNodesPerAngles.put(150, (new Node(new Point2D.Double(19.66,16), 9.58, 0.03)));
		mapOfNodesPerAngles.put(160, (new Node(new Point2D.Double(20.4,14.42), 9.72, 0.02)));
		mapOfNodesPerAngles.put(170, (new Node(new Point2D.Double(20.85,12.74), 9.76, 0.03)));
		mapOfNodesPerAngles.put(180, (new Node(new Point2D.Double(21,11), 9.76, 0.03)));
		mapOfNodesPerAngles.put(190, (new Node(new Point2D.Double(20.85,9.26), 9.97, 0.02)));
		mapOfNodesPerAngles.put(200, (new Node(new Point2D.Double(20.4,7.58), 9.91, 0.02)));
		mapOfNodesPerAngles.put(210, (new Node(new Point2D.Double(19.66, 6), 9.89, 0.02)));
		mapOfNodesPerAngles.put(220, (new Node(new Point2D.Double(18.66, 4.57), 9.87, 0.03)));
		mapOfNodesPerAngles.put(230, (new Node(new Point2D.Double(17.43, 3.34), 9.97, 0.03)));
		mapOfNodesPerAngles.put(240, (new Node(new Point2D.Double(16,2.34), 9.72, 0.01)));
		mapOfNodesPerAngles.put(250, (new Node(new Point2D.Double(14.42, 1.6), 9.87, 0.02)));
		mapOfNodesPerAngles.put(260, (new Node(new Point2D.Double(12.74, 1.15), 10, 0.02)));
		mapOfNodesPerAngles.put(270, (new Node(new Point2D.Double(11, 1), 10.19, 0.02)));
		mapOfNodesPerAngles.put(280, (new Node(new Point2D.Double(9.26,1.15), 9.8, 0.02)));
		mapOfNodesPerAngles.put(290, (new Node(new Point2D.Double(7.58, 1.6), 9.96, 0.03)));
		mapOfNodesPerAngles.put(300, (new Node(new Point2D.Double(6, 2.34), 10.03, 0.03)));
		mapOfNodesPerAngles.put(310, (new Node(new Point2D.Double(4.57, 3.34), 9.54, 0.02)));
		mapOfNodesPerAngles.put(320, (new Node(new Point2D.Double(3.34, 4.57), 10.12, 0.07)));
		mapOfNodesPerAngles.put(330, (new Node(new Point2D.Double(2.34, 6), 9.56, 0.07)));
		mapOfNodesPerAngles.put(340, (new Node(new Point2D.Double(1.6, 7.58), 9.58, 0.03)));
		mapOfNodesPerAngles.put(350, (new Node(new Point2D.Double(1.15, 9.26), 9.72, 0.02)));
		mapOfNodesPerAngles.put(360, (new Node(new Point2D.Double(1, 11), 9.97, 0.02)));
		
		System.out.println("TESTS IN FRONT OF AULA MAGNA");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Usual State, Tag at 5,1 +-");
		nA = new Node(new Point2D.Double(1,1), 5, 3);
		nB = new Node(new Point2D.Double(5,1), 0, 3);
		nC = new Node(new Point2D.Double(1,5), 5, 3);
		eD = Localise.findEndDevice(nA, nB, nC);
		System.out.println("The EndDevice position is: ("+ eD.getPosition().getX() + ", " + eD.getPosition().getY() + ").");
		
		System.out.println("-----------------------------------\n");
		System.out.println("Experiment Front of Aula Magna");
		System.out.println("Tag at: 1,1");
		nA = new Node(new Point2D.Double(0,0), 0.83, 0.463);
		nB = new Node(new Point2D.Double(10,0), 8.87, 0.860);
		nC = new Node(new Point2D.Double(10,10), 13.23, 0.700);
		eD = Localise.findEndDevice(nA, nB, nC);
		System.out.println("The EndDevice position is: ("+ eD.getPosition().getX() + ", " + eD.getPosition().getY() + ").");

		System.out.println("-----------------------------------\n");
		System.out.println("Tag at: 1,5");
		nA = new Node(new Point2D.Double(0,0), 5.02, 0.422);
		nB = new Node(new Point2D.Double(10,0), 10.09, 0.605);
		nC = new Node(new Point2D.Double(10,10), 10.09, 0.664);
		eD = Localise.findEndDevice(nA, nB, nC);
		System.out.println("The EndDevice position is: ("+ eD.getPosition().getX() + ", " + eD.getPosition().getY() + ").");

		System.out.println("-----------------------------------\n");
		System.out.println("Tag at: 5,5");
		nA = new Node(new Point2D.Double(0,0), 6.90, 4.16);
		nB = new Node(new Point2D.Double(10,0), 6.90, 4.12);
		nC = new Node(new Point2D.Double(10,10), 6.96, 6.27);
		eD = Localise.findEndDevice(nA, nB, nC);
		System.out.println("The EndDevice position is: ("+ eD.getPosition().getX() + ", " + eD.getPosition().getY() + ").");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("TESTS OF ALL POSSIBLE ANGLES");
		System.out.println("-----------------------------------\n");
		
		ArrayList<ArrayList<Integer>> allPossibleCombination = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> clone = new ArrayList<Integer>();
		Boolean haveInTheSet = false;
		int counter=0, counterb=0, counterc = 0;
		double x =0, y = 0, errorX =0, errorY=0;
//		try {
			 
//			File file = new File("/Users/Vannuchi/Desktop/text.txt");
 
			// if file doesnt exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
 
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
			
			for(Integer i=0; i <= 360 ; i+=10){
				for(Integer j=0; j <= 360 ; j+=10){
					for(Integer k=0; k <= 360 ; k+=10){
						
						int newAlpha = Math.abs(j-i);
						int newBeta = Math.abs(k-j);
						int newDelta = 0;
						
						if(i-k < 0){
							newDelta = 360 + (i-k);
						}else{
							newDelta = i-k;
						}
						
						ArrayList<Integer> tempCombination = new ArrayList<Integer>();
						if(newAlpha+newBeta+newDelta == 360 && newAlpha != 0  && newBeta != 0 && newDelta != 0){
							tempCombination.add(newAlpha);
							tempCombination.add(newBeta);
							tempCombination.add(newDelta);
							
							Collections.sort(tempCombination);
							
							for(int h=0; h < allPossibleCombination.size(); h++){
								Collections.sort(allPossibleCombination.get(h));
								if(tempCombination.equals(allPossibleCombination.get(h))){
									haveInTheSet = true;
								}
							}
							int rotateAlpha = 0;
							int rotateBeta = 0;
							int rotateGamma = 0;
//							ArrayList<ArrayList<Double>> arrOfArr = new ArrayList<ArrayList<Double>>();
							int tempIndex = 0;
							double tempMaximumError= 0;
//							ExperimentsForAvg tempExperiment;
							ExperimentsForAvg exp = null;
//							Boolean tempFlag = true;
							Double averageTotal = 0.0;
							for(Integer a=0; a <= 350 ; a+=10){
								
								if(haveInTheSet == false){		
									
									if((rotateGamma + newAlpha) < 360){
										rotateAlpha = rotateGamma + newAlpha;
									}else{
										rotateAlpha = (rotateGamma+newAlpha)-360;
									}
									
									if((rotateAlpha + newBeta) < 360){
										rotateBeta = rotateAlpha + newBeta;
									}else{
										rotateBeta = (rotateAlpha+newBeta)-360;
									}
									if((rotateBeta + newDelta) < 360){
										rotateGamma = rotateBeta + newDelta;
									}else{
										rotateGamma = (rotateBeta+newDelta)-360;
									}
									rotateGamma += 10;
									
									allPossibleCombination.add(tempCombination);
									nA = mapOfNodesPerAngles.get(rotateAlpha);
									nB = mapOfNodesPerAngles.get(rotateBeta);
									nC = mapOfNodesPerAngles.get(rotateGamma);
									eD = Localise.findEndDevice(nA, nB, nC);
									x = (Math.round(eD.getPosition().getX() * 100.0) / 100.0);
									y = (Math.round(eD.getPosition().getY() * 100.0) / 100.0);
									errorX = Math.abs(11 - x);
									errorY = Math.abs(11 - y);
									
									
									Double totalError = Math.sqrt( (Double) ( ( Math.pow( errorX , 2.0) + Math.pow( errorY, 2.0))));
//									if(!tempFlag){
//										tempMaximumError = totalError;
//										tempFlag = false;
//									}
									if(tempMaximumError <= totalError){
										exp = new ExperimentsForAvg(newAlpha, newBeta, newDelta, errorX, errorY, totalError, x, y);
										
//										System.out.println(exp);
										
									}
									averageTotal += totalError;
//										tempArrayAvg.add(exp);
//									tempArrayAvg.add((double) newAlpha);
//									tempArrayAvg.add((double) newBeta);
//									tempArrayAvg.add((double) newDelta);
//									tempArrayAvg.add((double) errorX);
//									tempArrayAvg.add((double) errorY);
//									tempArrayAvg.add((double) totalError);
//									if(tempMaximumError <= totalError){
//										tempMaximumError = totalError;
//										tempIndex = a/10;
//									}
									
			//						System.out.println("The EndDevice position is: ("+ eD.getPosition().getX() + ", " + eD.getPosition().getY() + ").");
			//						System.out.println("The Correct Position is: (11,11)");
		//							System.out.println(i + ", " + j + ", " + k + "; " + eD.getPosition().getX() + "; " + eD.getPosition().getY());
									
									
									

									
									
//									Double totalError = Math.sqrt( (Double) ( ( Math.pow( errorX , 2.0) + Math.pow( errorY, 2.0))));
//									
//									String content = newAlpha + "\t" + newBeta + "\t" + newDelta + "\t" + errorX + "\t" + errorY +"\t"+ newAlpha + "\\degree & " + newBeta + "\\degree & " + newDelta + "\\degree & " + errorX + " & " + errorY + " & "+ totalError + " \\\\ \n ";
//	//								String content = newAlpha + "," + newBeta + "," + newDelta + "," + Math.round(eD.getPosition().getX() * 100.0) / 100.0 + "," + Math.round(eD.getPosition().getY() * 100.0) / 100.0 +"\n";
									counterc++;
//									bw.write(content);
								}
								
								
							}
							if(exp != null){
//								System.out.println(exp.getTotalError());
//								String content = exp.getAlpha() + "\t" + exp.getBeta() + "\t" + exp.getGamma() + "\t" + exp.getX() + "\t" + exp.getY() + "\t" + averageTotal + "\t"+ exp.getAlpha() + "\\degree & " + exp.getBeta() + "\\degree & " + exp.getGamma() + "\\degree & " + exp.getX() + " & " + exp.getY() + " & "+ exp.getTotalError() + " \\\\ \n ";
//								bw.write(content);
							}
//							String content = newAlpha + "\t" + newBeta + "\t" + newDelta + "\t" + errorX + "\t" + errorY +"\t"+ newAlpha + "\\degree & " + newBeta + "\\degree & " + newDelta + "\\degree & " + errorX + " & " + errorY + " & "+ totalError + " \\\\ \n ";
//							bw.write(content);
							
							counter++;
						}
						haveInTheSet = false;
						counterb++;
					}
				}
			}
//			bw.flush();
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(counter);
		System.out.println(counterb);
		System.out.println(counterc);
		System.out.println("-------------------------------------------------------------------------------");
		

		
		
	}

}
