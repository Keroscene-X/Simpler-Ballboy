package ballboy.model;

import javafx.scene.image.Image;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GameEngineImpl implements GameEngine {

    private Level level;
    private smallHero smallHero;

    public GameEngineImpl(String filename) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/"+filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject heroPOS = (JSONObject) jsonObject.get("ballboy_POS");
            String herosize = (String) jsonObject.get("ballboySize");
            double floorHeight = (double) jsonObject.get("floorHeight");
            double levelHeight = (double) jsonObject.get("levelHeight");
            double levelWidth = (double) jsonObject.get("levelWidth");
            String heroImage = (String) jsonObject.get("ballboyImage");
            String cloudImage = (String) jsonObject.get("cloud_pic");
            JSONArray cloudPOS = (JSONArray) jsonObject.get("cloud_POS");
            String floorImage = (String) jsonObject.get("floor_pic");
            JSONArray stepPOS = (JSONArray) jsonObject.get("steps_POS");
            String stepImage = (String) jsonObject.get("steps_pic");
            JSONObject target_pos= (JSONObject) jsonObject.get("target_POS");
            String targetImage = (String) jsonObject.get("target_pic");
            JSONArray enemy = (JSONArray) jsonObject.get("enemy");
            level = new LevelImpl(floorHeight,floorImage, levelHeight, levelWidth, heroImage,(double) heroPOS.get("x"),(double) heroPOS.get("y"),herosize,cloudImage,cloudPOS, stepImage, stepPOS, targetImage,target_pos,enemy);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }

    }

    @Override
    public Level getCurrentLevel() {
        return level;
    }

    @Override
    public void startLevel() {
        return;
    }

    @Override
    public boolean boostHeight() {
        level.boostHeight();
        return true;
    }

    @Override
    public boolean dropHeight() {
        level.dropHeight();
        return true;
    }

    @Override
    public boolean moveLeft() {
        level.moveLeft();
        return true;
    }

    @Override
    public boolean moveRight() {
        level.moveRight();
        return true;
    }

    @Override
    public boolean stopBoostHeight() {
        level.stopBoostHeight();
        return true;
    }

    @Override
    public boolean stopDropHeight() {
        level.stopDropHeight();
        return true;
    }

    @Override
    public boolean stop(){
        level.stop();
        return true;
    }
    @Override
    public void tick() {
        level.tick();
    }
}
