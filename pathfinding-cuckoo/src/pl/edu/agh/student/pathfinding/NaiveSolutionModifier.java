package pl.edu.agh.student.pathfinding;
import java.util.Random;

public class NaiveSolutionModifier implements ISolutionModifier {
	private Random r = new Random();
	
	@Override
	public Solution modify(Solution solution) {
		int i = r.nextInt(solution.getSteps().size());
		int j = r.nextInt(solution.getSteps().size());
		
		
		return null;
	}
	
}
