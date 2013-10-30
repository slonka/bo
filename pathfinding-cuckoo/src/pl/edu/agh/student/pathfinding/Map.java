package pl.edu.agh.student.pathfinding;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class Map {

/*	private final int MAP_START_COLOR = 0x00FF0000; // red
	private final int MAP_END_COLOR = 0x0000FF00; // green
	private final int NOT_WALKABLE_COLOR = 0x00FFFFFF; */
	
	private Point startPoint;
	private Point endPoint;
	
	private int[][] rawMap;
	public BufferedImage img;
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public Map(String mapPath) {
		try {
			rawMap = load(mapPath);
		} catch (Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
	
	public void display() {

	}
	
	/*
	 * http://stackoverflow.com/questions/2615522/java-bufferedimage-getting-red-green-and-blue-individually/2615537#2615537
	 * colors are represented by 4 four byte values
	 * 00000000 00000000 00000000 11111111
	 * ^ Alpha  ^Red     ^Green   ^Blue
	 */
	public static int getAlpha(int color) {
		return (color >> 24) & 0x000000FF;
	}
	
	public static int getRed(int color) {
		return (color >> 16) & 0x000000FF;
	}	
	
	public static int getGreen(int color) {
		return (color >>8 ) & 0x000000FF;		
	}
	
	public static int getBlue(int color) {
		return (color) & 0x000000FF;
	}
	
	public static int getGrayscale(int color) {		
		return getRed(color) + getGreen(color) + getBlue(color);
	}
	
	public int getPixel(int x, int y) {
		return rawMap[x][y];
	}
	
	public int getPixel(Point p) {
		return getPixel(p.x, p.y);
	}
	
	public boolean isStartingPoint(int color) {
		if (getRed(color) == 0 && getGreen(color) == 255 && getBlue(color) == 0 ) {
			return true;
		} else {
			return false;
		}			
	}
	
	public boolean isEndingPoint(int color) {
		if (getRed(color) == 255 && getGreen(color) == 0 && getBlue(color) == 0 ) {
			return true;
		} else {
			return false;
		}			
	}
	
	public boolean isWalkable(int color) {
		if (Map.getRed(color) != 255 && Map.getGreen(color) != 255 && Map.getBlue(color) != 255 ) {
			return false;
		} else {
			return true;
		}			
	}
	
	/*
	 * http://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
	 * Gets image without using grb(x,y) method, which is said to be faster
	 */
	private int[][] load(String mapPath) throws Exception {
		img = ImageIO.read(getClass().getResource(mapPath));
		
		final byte[] pixels = ((DataBufferByte) img.getRaster()
				.getDataBuffer()).getData();
		final int width = img.getWidth();
		final int height = img.getHeight();
		final boolean hasAlphaChannel = img.getAlphaRaster() != null;
		boolean hasStartingPoint = false, hasEndingPoint = false;;
		

		int[][] result = new int[height][width];
		if (hasAlphaChannel) {
			final int pixelLength = 4;
			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
				int argb = 0;
				argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
				argb += ((int) pixels[pixel + 1] & 0xff); // blue
				argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
				argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
				result[row][col] = argb;
				
				//System.out.println("red: " + Map.getRed(argb) + " green: " + Map.getGreen(argb) + " blue: " + Map.getBlue(argb));
				if (isStartingPoint(argb)) {
					startPoint = new Point(col, row);
					hasStartingPoint = true;					
				} else if (isEndingPoint(argb)) {
					endPoint = new Point(col, row);
					hasEndingPoint = true;
				}
				
				col++;
				if (col == width) {
					col = 0;
					row++;
				}
			}
		} else {
			final int pixelLength = 3;
			for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
				int argb = 0;
				argb += -16777216; // 255 alpha
				argb += ((int) pixels[pixel] & 0xff); // blue
				argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
				argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
				result[row][col] = argb;
				col++;
				if (col == width) {
					col = 0;
					row++;
				}
				
				if (isStartingPoint(argb)) {
					startPoint = new Point(col, row);
					hasStartingPoint = true;					
				} else if (isEndingPoint(argb)) {
					endPoint = new Point(col, row);
					hasEndingPoint = true;
				}
			}
		}
		
		if(!(hasStartingPoint && hasEndingPoint)) {
			throw new IllegalStateException("No starting / ending point");
		}

		return result;
	}

	public static void main(String[] arg) {
		
		

	}
}
