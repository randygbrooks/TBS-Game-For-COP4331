package view.game;

import java.awt.Color;
import java.awt.Font;

import game.Game;
import game.gameboard.Location;
import game.gameboard.TerrainEnum;

public class TileDrawer {
	private GamePanel gamePanel;
	private Game game;
	private Font numFont = new Font("Lucida Sans", Font.BOLD, 20);
	
	private static final boolean DEBUG = false;
	
	public TileDrawer(GamePanel gamePanel, Game game) {
		this.gamePanel = gamePanel;
		this.game = game;
	}
	
	private void drawTile(int x, int y, TerrainEnum type) {
			switch(type) {
				case GRASS:
					gamePanel.drawStaticTileElement(x, y, "TERRAIN_GRASS");
					break;
				case SAND:
					gamePanel.drawStaticTileElement(x, y, "TERRAIN_SAND");
					break;
				case WATER:
					gamePanel.drawAnimatedTileElement(x, y, "TERRAIN_WATER1", "TERRAIN_WATER2", "TERRAIN_WATER3");
					break;
				case INVISIBLE:
					break;
			}
	}
	
	protected void drawMovingTiles() {
		for (Location moveLocation : game.getMoveLocations()) {
			if (game.getGameBoard().getTiles()[moveLocation.getX()][moveLocation.getY()].getTileType() != TerrainEnum.INVISIBLE ) {
				gamePanel.drawStaticTileElement(moveLocation.getX(), moveLocation.getY(), "MOVE_SELECTED");
			}
		}
	}
	
	protected void drawTiles() {
		Color oldColor = gamePanel.getG2D().getColor();
		Font oldFont = gamePanel.getG2D().getFont();
		gamePanel.getG2D().setFont(numFont);
		gamePanel.getG2D().setColor(Color.BLACK);
		for (int i = 0; i < game.getGameBoard().getTiles().length; i++) {
			for (int j = 0; j < game.getGameBoard().getTiles()[i].length; j++) {
				if (DEBUG) {
					gamePanel.getG2D().drawString("(" + i + " ," + j + ")", gamePanel.getCamera().offsetX(i, j) - 13,
							gamePanel.getCamera().offsetY(i, j) - 13);
				}
				drawTile(i, j, game.getGameBoard().getTiles()[i][j].getTileType());
				if (game.getGameBoard().getTiles()[i][j].getUnits().size() > 1 && !game.getGameBoard().getTiles()[i][i].containsArmy) {
					gamePanel.getG2D().drawString("" + game.getGameBoard().getTiles()[i][j].getUnits().size()
							, gamePanel.getCamera().offsetX(i, j) + 5, gamePanel.getCamera().offsetY(i, j) + 22);
				}
					
			}
		}
		gamePanel.getG2D().setColor(oldColor);
		gamePanel.getG2D().setFont(oldFont);
	}
}
