package data;

public enum TileType {
	
	Grass("redirect2", true), Dirt("redirect",false), Hole("hole",false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
