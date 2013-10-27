package pl.edu.agh.student.pathfinding.tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.student.pathfinding.MapManager;

public class MapManagerTest {

	MapManager map;
	int[][] pixels;
	
	@Before
	public void setUp() throws Exception {
		map = new MapManager();
		String mapPath = "tests/maps/test1.png";
		pixels = map.load(mapPath);
	}

	@Test
	public void loadTest() {		
		Assert.assertEquals("First pixel red not matching", 27, MapManager.getRed(pixels[0][0]));
		Assert.assertEquals("First pixel green not matching", 229, MapManager.getGreen(pixels[0][0]));
		Assert.assertEquals("First pixel blue not matching", 51, MapManager.getBlue(pixels[0][0]));
		Assert.assertEquals("First pixel grayscale not matching", 51 + 229 + 27, MapManager.getGrayscale(pixels[0][0]));
	}

}
