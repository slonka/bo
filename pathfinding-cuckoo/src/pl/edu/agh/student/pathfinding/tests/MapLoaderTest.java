package pl.edu.agh.student.pathfinding.tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.student.pathfinding.MapLoader;

public class MapLoaderTest {

	BufferedImage testMap1;
	MapLoader loader;
	
	@Before
	public void setUp() throws Exception {
		String mapPath = "maps/test1.png";
		testMap1 = ImageIO.read(getClass().getResource(mapPath));
		loader = new MapLoader();	
	}

	@Test
	public void loadTest() {
		int[][] pixels = loader.load(testMap1);
		
		Assert.assertEquals("First pixel red not matching", 27, loader.getRed(pixels[0][0]));
		Assert.assertEquals("First pixel green not matching", 229, loader.getGreen(pixels[0][0]));
		Assert.assertEquals("First pixel blue not matching", 51, loader.getBlue(pixels[0][0]));
	}

}
