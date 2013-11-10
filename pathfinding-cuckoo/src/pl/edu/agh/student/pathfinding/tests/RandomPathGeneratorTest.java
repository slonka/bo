package pl.edu.agh.student.pathfinding.tests;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.student.pathfinding.RandomPathGenerator;
import pl.edu.agh.student.pathfinding.map.IMap;
import pl.edu.agh.student.pathfinding.map.BitmapMap;

public class RandomPathGeneratorTest{

	RandomPathGenerator generator;

	@Before
	public void setUp() throws Exception {
		generator = new RandomPathGenerator(new BitmapMap(new File("maps/RandomPathGeneratorTest/RozjebutTest.png")));
	}

	@Test
	public void getSolutionTest() {
		Assert.assertTrue(generator.getSolution().getSteps().size() != 0);
	}

}
package pl.edu.agh.student.pathfinding.tests;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.student.pathfinding.RandomPathGenerator;
import pl.edu.agh.student.pathfinding.map.IMap;
import pl.edu.agh.student.pathfinding.map.BitmapMap;

public class RandomPathGeneratorTest{

	RandomPathGenerator generator;

	@Before
	public void setUp() throws Exception {
		generator = new RandomPathGenerator(new BitmapMap(new File("maps/RandomPathGeneratorTest/RozjebutTest.png")));
	}

	@Test
	public void getSolutionTest() throws IOException {
		Assert.assertTrue(generator.getSolution().getSteps().size() != 0);
		generator = new RandomPathGenerator(new BitmapMap(new File("maps/RandomPathGeneratorTest/PrzejsciaNiMa.png")));
		Assert.assertTrue(generator.getSolution().getSteps().size() == 0);
	}

}
