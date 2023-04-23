package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Enemy extends BaseActor{

    public boolean collected;

    private String[] animazioni = {};
    Animation<TextureRegion> textureRegion;
    private float posX;
    private float posY;

    /*
    private String[] persona2telefono =
            {"persona-2-telefono-1.png", "persona-2-telefono-2.png"};

    private String[] persona2telefono2 =
            {"persona-2-telefono-1(viola).png", "persona-2-telefono-2(viola).png"};


    Animation<TextureRegion> persona2;
    Animation<TextureRegion> persona2_2;

     */
    public Enemy(float x, float y, Stage s,Animation<TextureRegion> textureRegionAnimation, String[] animazioni, float posX, float posY) {
        super(x, y, s);

        /*
        randomEnemy(persona2, persona2telefono, s);
        persona2 = loadAnimationFromFiles(persona2telefono, 0.5f, true);
        setBoundaryPolygon(8);
         */

        this.animazioni = animazioni;
        this.textureRegion = textureRegionAnimation;
        this.posX = posX;
        this.posY = posY;


        textureRegionAnimation = loadAnimationFromFiles(animazioni, 0.5f, true);
        setAnimation(textureRegionAnimation);
        setBoundaryPolygon(8);
        collected = false;

    }

    //GET
    public String[] getAnimazioni() {
        return animazioni;
    }

    public Animation<TextureRegion> getTextureRegion() {
        return textureRegion;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void randomEnemy(Animation<TextureRegion> textureRegionAnimation, String[] animazioni, Stage stage){
        textureRegionAnimation = loadAnimationFromFiles(animazioni, 0.5f, true);
        setAnimation(textureRegionAnimation);
        setBoundaryPolygon(8);

    }
    public boolean isCollected()
    {
        return collected;
    }

    public void collect()
    {
        collected = true;
        clearActions();
        addAction( Actions.fadeOut(0) );
        addAction( Actions.after( Actions.removeActor() ) );
    }
}
