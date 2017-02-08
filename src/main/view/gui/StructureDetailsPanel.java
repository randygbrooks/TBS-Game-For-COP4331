package view.gui;

import java.awt.Font;
import java.awt.Graphics;

import controls.structure.StructureEnum;
import controls.unit.UnitEnum;
import game.Game;
import game.entities.PowerState;

public class StructureDetailsPanel extends DetailsPanel{
private Game game;
Font detailsFont = new Font("Lucida Sans", Font.BOLD, 20);
Font bigFont = new Font("Lucida Sans", Font.BOLD, 35);

	public StructureDetailsPanel(Game game) {
		this.game = game;
	}

	public void draw(Graphics g, int width, int height) {
		drawBar(g, width, height);
		drawText(g, height);
	}

	private void drawText(Graphics g, int height) {
		Font old = g.getFont();
		g.setFont(detailsFont);
		g.drawString("Structure Details:", 10, height - 65);
		if (game.getSomeItemSelected() && game.getCurrentPlayer().getBases().size() > 0) {
			g.drawString("Type: ", 30, height - 35);
			g.drawString("Health: ", 30, height - 10);
			g.drawString("Attack: ", 430, height - 35);
			g.drawString("Defense: ", 430, height - 10);
			g.drawString("Armor: ", 830, height - 35);
			g.drawString("Upkeep: ", 830, height - 10);
		
			if (game.getCurrentType() == StructureEnum.BASE) {
				g.drawString("Base", 130, height - 35);
			}
			g.drawString(game.getCurrentPlayer().getBases().get(0).getHealth() + "", 130, height - 10);
			g.drawString(game.getCurrentPlayer().getBases().get(0).getAttackDamage() + "", 530, height - 35);
			g.drawString(game.getCurrentPlayer().getBases().get(0).getDefenseDamage() + "", 530, height - 10);
			g.drawString(game.getCurrentPlayer().getBases().get(0).getArmor() + "", 930, height - 35);
			g.drawString(game.getCurrentPlayer().getBases().get(0).getUpkeep() + "", 930, height - 10);
		} else {
			g.setFont(bigFont);
			g.drawString("You Have No Structures", 35, height - 25);
		}
		g.setFont(old);
	}
		
}