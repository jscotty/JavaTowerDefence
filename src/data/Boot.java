package data;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;
import helpers.Clock;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Boot {
	
	
	public Boot(){
		BeginSession();
		
		int[][] map = {
				{2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{2, 2, 2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0},
				{2, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0},
				{2, 2, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0},
				{2, 2, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
				{2, 2, 0, 0, 1, 2, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{2, 2, 0, 0, 1, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
				{2, 2, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
				{2, 2, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
				{2, 2, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
				{2, 2, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
				{2, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		TileGrid grid = new TileGrid(map);
		grid.SetTile(2, 2, grid.GetTile(1, 2).getType());
		
		Enemy e = new Enemy(QuickLoad("enemy"), grid.GetTile(0, 7), grid, 64, 64, 8,20);
		Wave wave = new Wave(40, e);
		
		Player player = new Player(grid);
		
		while(!Display.isCloseRequested()){
			Clock.update();
			e.Update();
			
			grid.Draw();
			wave.Update();
			
			player.Update();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	private void glMatrixMode(int glProjection) {
		
	}

	public static void main(String[] args){
		new Boot();
		
	      
	}
}
