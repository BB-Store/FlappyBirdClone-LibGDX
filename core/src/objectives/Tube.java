package objectives;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import java.util.Random;

public class Tube implements Disposable {

    private static final int Fluctuation = 220;
    private static final int Tube_Gap = 100;
    private static final int Lowest_Opening = 70;
    public static final int Tube_Width = 52;
    public static final int Tube_Height = 320;

    private Texture tubeTop, tubeBottom;
    private Vector2 posTubeTop, posTubeBottom;
    private Random random;

    public Tube(float x) {
        tubeTop = new Texture("PipeDown.png");
        tubeBottom = new Texture("PipeUp.png");
        random = new Random();
        posTubeTop = new Vector2(x, random.nextInt(Fluctuation) + Tube_Gap + Lowest_Opening);
        posTubeBottom = new Vector2(x, posTubeTop.y - Tube_Gap - Tube_Height);
    }

    public void reposition(float x) {
        posTubeTop.set(x, random.nextInt(Fluctuation)+ Tube_Gap +Lowest_Opening);
        posTubeBottom = new Vector2(x, posTubeTop.y - Tube_Gap - Tube_Height);
    }

    public Texture getTubeTop() {
        return tubeTop;
    }

    public Texture getTubeBottom() {
        return tubeBottom;
    }

    public Vector2 getPosTubeTop() {
        return posTubeTop;
    }

    public Vector2 getPosTubeBottom() {
        return posTubeBottom;
    }

    @Override
    public void dispose() {
        tubeTop.dispose();
        tubeBottom.dispose();
    }
}
