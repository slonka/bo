package pl.edu.agh.student.pathfinding;

public interface ISolutionModifier {
	/*
	 * Modifies solution - must update f value;
	 */
	Solution modify(Solution solution); 
}
