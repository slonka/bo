package pl.edu.agh.student.pathfinding;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapManager {

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
	
	/*
	 * http://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
	 * Gets image without using grb(x,y) method, which is said to be faster
	 */
	public int[][] load(String mapPath) throws IOException {
		BufferedImage image = ImageIO.read(getClass().getResource(mapPath));
		
		final byte[] pixels = ((DataBufferByte) image.getRaster()
				.getDataBuffer()).getData();
		final int width = image.getWidth();
		final int height = image.getHeight();
		final boolean hasAlphaChannel = image.getAlphaRaster() != null;

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
			}
		}

		return result;
	}

	public static void main(String[] arg) {
		
		

	}
}
