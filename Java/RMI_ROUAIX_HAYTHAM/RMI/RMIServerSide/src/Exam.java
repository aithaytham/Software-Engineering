

public class Exam {
	private String name;
	private Double score;
	private Double coef;

	public Exam(String name, Double score, Double coef) {
		this.name = name;
		this.score = score;
		this.coef = coef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getCoef() {
		return coef;
	}

	public void setCoef(Double coef) {
		this.coef = coef;
	}

	
}
