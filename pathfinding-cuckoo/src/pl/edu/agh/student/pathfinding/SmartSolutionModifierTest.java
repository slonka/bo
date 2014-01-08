package pl.edu.agh.student.pathfinding;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.student.pathfinding.map.BitmapMap;

public class SmartSolutionModifierTest {

	RandomPathGenerator generator;
	SmartSolutionModifier ssm = new SmartSolutionModifier();
	
	@Before
	public void setUp() throws Exception {
		generator = new RandomPathGenerator(new BitmapMap(new File("maps/test_cut2.png")));
	}

	@Test
	public void testCutSolution() {
		Solution s = generator.getSolution();
		
		try {
			ssm.cutSolution(s);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

}
