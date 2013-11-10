package pl.edu.agh.student.pathfinding;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.TreeSet;

import pl.edu.agh.student.pathfinding.map.IMap;

public class CuckooSolver implements ISolver {
	private IPathGenerator generator;
	private int n;
	private Solution[] nest;
	private int[] f; // quality/fitness
	private int maxGeneration;
	private IMap map;
	private Random r = new Random();
	private float pa; // Probability of Abandonment
	private ISolutionModifier solutionModifier;
	
	public CuckooSolver(IMap map, IPathGenerator generator, ISolutionModifier solutionModifier, int population, int maxGeneration, float pa) {		
		this.generator = generator;
		this.n = population;
		this.maxGeneration = maxGeneration;
		this.map = map;
		this.solutionModifier = solutionModifier;
		this.pa = pa;
		nest = new Solution[n];
		f = new int[n];
	}

	@Override
	public Solution solve() {
		
		// Generate an initial population of  n  host nests
		for(int i=0; i<n; i++) {
			nest[i] = generator.getSolution(map.getStartingPoint(), map.getFinishPoint());
			f[i] = nest[i].f();
		}
		
		for (int t=0; t<maxGeneration; t++) { // While (t<MaxGeneration) or (stop criterion)
			// Get a cuckoo randomly (say, i) and replace its solution by performing random operations;
			int i = r.nextInt(n);
			Solution randomNest = nest[i];
			randomNest = solutionModifier.modify(nest[i]);
			
			// Evaluate its quality/fitness
			int fi = randomNest.f();
			
			//Choose a nest among n (say, j) randomly;
			int j = r.nextInt(n);
			int fj = f[j];
			
			if(fi > fj) {
				nest[i] = randomNest;
				f[i] = fi;
			}
			
			
			
			// A fraction (pa) of the worse nests are abandoned and new ones are built;
			
			
		}
		
		return null;
	}
	
	/*
	http://en.wikipedia.org/wiki/Cuckoo_search
	 	Objective function: f(\mathbf{x}), \quad \mathbf{x}=(x_1,x_2,\dots,x_d); \, 
		 
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
