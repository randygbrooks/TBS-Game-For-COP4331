package view.gui;

import javafx.scene.canvas.GraphicsContext;
import view.Point;

public abstract class Panel {
    private static final int TICKS_PER_IMAGE = 20;
    private static final int IMAGES_TO_LOOP = 4;
    private int animationImage = 0;
    private int animationCount = 0;
    private boolean isVisible = true;
    
    public abstract void draw(GraphicsContext gc, Point screenDimensions);
    
    public void setIsVisible(boolean isVisible) {
    	this.isVisible = isVisible;
    }
    
    public boolean getIsVisible() {
    	return isVisible;
    }
    
    public void updateAnimationCount() {
        animationCount++;
        if (animationCount > TICKS_PER_IMAGE) {
            animationCount = 0;
            updateAnimation();
        }
    }

    private void updateAnimation() {
        if (animationImage < IMAGES_TO_LOOP - 1) {
            animationImage++;
        } else {
            animationImage = 0;
        }
    }

    public int getAnimationImage() {
        return animationImage;
    }

    public int getAnimationCount() {
        return animationCount;
    }
}
