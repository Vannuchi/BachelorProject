
public class ExperimentsForAvg {
	double alpha;
	double beta;
	double gamma;
	double errorX;
	double errorY;
	double totalError;
	double x;
	double y;
	
	public ExperimentsForAvg(double a, double b, double g, double eX, double eY, double total, double x, double y) {
		this.alpha = a;
		this.beta = b;
		this.gamma = g;
		this.errorX = eX;
		this.errorY = eY;
		this.totalError = total;
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getGamma() {
		return gamma;
	}

	public void setGamma(double gamma) {
		this.gamma = gamma;
	}

	public double getErrorX() {
		return errorX;
	}

	public void setErrorX(double errorX) {
		this.errorX = errorX;
	}

	public double getErrorY() {
		return errorY;
	}

	public void setErrorY(double errorY) {
		this.errorY = errorY;
	}

	public double getTotalError() {
		return totalError;
	}

	public void setTotalError(double totalError) {
		this.totalError = totalError;
	}
	

}
