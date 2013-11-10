package pl.edu.agh.student.pathfinding;

public class CuckooSolver {

	/*
	http://en.wikipedia.org/wiki/Cuckoo_search
	 	Objective function: f(\mathbf{x}), \quad \mathbf{x}=(x_1,x_2,\dots,x_d); \, 
		Generate an initial population of  n  host nests; 
		While (t<MaxGeneration) or (stop criterion)
		   Get a cuckoo randomly (say, i) and replace its solution by performing Lévy flights;
		   Evaluate its quality/fitness F_i 
		         [For maximization, F_i \propto f(\mathbf{x}_i) ];
		   Choose a nest among n (say, j) randomly;
		   if (F_i>F_j ),
		          Replace j by the new solution;
		   end if
		   A fraction (p_a) of the worse nests are abandoned and new ones are built;
		   Keep the best solutions/nests;
		   Rank the solutions/nests and find the current best;
		   Pass the current best solutions to the next generation;
		end while
	*/
	
}
