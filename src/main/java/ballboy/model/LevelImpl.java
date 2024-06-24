package ballboy.model;

import javafx.scene.image.Image;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class LevelImpl implements Level{
    private EntityRegistry entityregistry;
    private MovementRegistry movementregistry;
    private List<Entity> entities;
    private double levelHeight;
    private double levelWidth;
    private double floorHeight;
    private Hero hero;
    private long tickCount = 0;
    private List<Floor> floors;
    private List<Step> steps;
    private FinishingEntity finishing;
    private List<Enemy> enemies;


    LevelImpl(double floorHeight, String floorImage, double levelHeight, double levelWidth, String heroImage, double heroX, double heroY, String heroSize, String cloudImage, JSONArray cloudPOS, String stepImage, JSONArray stepPOS, String targetImage, JSONObject targetPOS, JSONArray enemyArray){
        Random rand = new Random();
        entities = new ArrayList<>();
        entityregistry = new EntityRegistry();
        movementregistry = new MovementRegistry();
        floors = new ArrayList<>();
        steps = new ArrayList<>();
        enemies = new ArrayList<>();
        hero = (Hero) entityregistry.getFactory(heroSize).createEntity(heroImage,heroX,heroY);
        this.floorHeight = floorHeight;
        this.levelHeight = levelHeight;
        this.levelWidth = levelWidth;
        Iterator<JSONObject> clIterator = cloudPOS.iterator();
        while (clIterator.hasNext()){
            JSONObject obj = clIterator.next();
            double cloudX = (double) obj.get("x");
            double cloudY = (double) obj.get("y");
            Cloud cloud = (Cloud) entityregistry.getFactory("cloud").createEntity(cloudImage,cloudX,cloudY);
            cloud.setWidth(rand.nextDouble() * 51.0 + 50.0);
            entities.add(cloud);
        }
        for(int num = 0; num < levelWidth ; num+=100){
            Floor floor = (Floor) entityregistry.getFactory("floor").createEntity(floorImage,num,floorHeight);
            floors.add(floor);
            entities.add(floor);
        }
        Iterator<JSONObject> stIterator = stepPOS.iterator();
        while (stIterator.hasNext()){
            JSONObject obj = stIterator.next();
            double stepX = (double) obj.get("x");
            double stepY = (double) obj.get("y");
            double stepWidth = (double) obj.get("width");
            Step step = (Step) entityregistry.getFactory("step").createEntity(stepImage,stepX,stepY);
            step.setWidth(stepWidth);
            steps.add(step);
            entities.add(step);
        }
        Iterator<JSONObject> enIterator = enemyArray.iterator();
        while(enIterator.hasNext()){
            JSONObject obj = enIterator.next();
            double enemyX = (double) obj.get("x");
            double enemyY = (double) obj.get("y");
            String enemyMode = (String) obj.get("mode");
            String enemyImage = (String) obj.get("image");
            Enemy enemy = (Enemy) entityregistry.getFactory("enemy").createEntity(enemyImage,enemyX,enemyY);
            enemy.setMovementStrategy(movementregistry.getFactory(enemyMode).createMovement());
            enemies.add(enemy);
            entities.add(enemy);
        }
        finishing = (FinishingEntity) entityregistry.getFactory("finishing").createEntity(targetImage,(double) targetPOS.get("x"),(double) targetPOS.get("y"));
        entities.add(finishing);
        entities.add(hero);
    }

    @Override
    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public double getLevelHeight() {
        return levelHeight;
    }

    @Override
    public double getLevelWidth() {
        return levelWidth;
    }

    @Override
    public void tick() {
        tickCount ++;

        for (Floor floor : floors){
            if (checkCollision(hero,floor)){
                hero.setYPos(floor.getYPos()-hero.getHeight()-1);
                hero.invertAcc();
            }
            for (Enemy enemy : enemies){
                if (checkCollision(enemy,floor)){
                    enemy.setYPos(floor.getYPos()-enemy.getHeight()-1);
                }
            }
        }
        for (Step step : steps){
            if(checkCollision(hero,step)){
                handleHeroStepCollision(hero,step);
            }
            for (Enemy enemy : enemies){
                if(checkCollision(enemy,step)){
                    handleEnemyStepCollision(enemy,step);
                }
            }
        }
        for(Enemy enemy : enemies){
            if(checkCollision(hero,enemy)){
                hero.reset();
            }
            enemy.think(hero,tickCount);
        }
        if(checkCollision(hero,finishing)){
            System.exit(0);
        }
        if ( (hero.getXPos()+hero.getWidth()) >= levelWidth){
            hero.setXPos(levelWidth-hero.getWidth()-1);
        }
        for (Entity entity : entities){
            entity.tick();
        }

    }

    private boolean checkCollision(Entity entityA, Entity entityB) {
        if (entityA == entityB) {
            return false;
        }

        return (entityA.getXPos() < (entityB.getXPos() + entityB.getWidth())) &&
                ((entityA.getXPos() + entityA.getWidth()) > entityB.getXPos()) &&
                (entityA.getYPos() < (entityB.getYPos() + entityB.getHeight())) &&
                ((entityA.getYPos() + entityA.getHeight()) > entityB.getYPos());
    }
    public void handleHeroStepCollision(Hero hero, Step step){
        if((hero.getYPos() < step.getYPos()) && ((hero.getYPos() + hero.getHeight()) > (step.getYPos() + step.getHeight()))){
            if ((hero.getXPos()<(step.getXPos() + step.getWidth()))&&((hero.getXPos()+hero.getWidth())>(step.getXPos() + step.getWidth()))){
                hero.setXPos(step.getXPos()+step.getWidth() + 1);
            }
            else if ((hero.getXPos()<step.getXPos())&&((hero.getXPos()+hero.getWidth())>step.getXPos())){
                hero.setXPos(step.getXPos()-hero.getWidth() - 1);
            }
        }
        else if((hero.getXPos() < (step.getXPos() + step.getWidth())) && ((hero.getXPos() + hero.getWidth()) > step.getXPos())){
            if ((hero.getYPos() < step.getYPos())&& ((hero.getYPos()+hero.getHeight() > step.getYPos()))){
                hero.setYPos(hero.getYPos() - 1);
                hero.invertAcc();
            }
            else if((hero.getYPos() < (step.getYPos() + step.getHeight()))&&((hero.getYPos() + hero.getHeight())> (step.getYPos()+step.getHeight()))){
                hero.setYPos(hero.getYPos() + 1);
                hero.invertAcc();
            }
        }
    }

    public void handleEnemyStepCollision(Enemy hero, Step step){
        if((hero.getYPos() < step.getYPos()) && ((hero.getYPos() + hero.getHeight()) > (step.getYPos() + step.getHeight()))){
            if ((hero.getXPos()<(step.getXPos() + step.getWidth()))&&((hero.getXPos()+hero.getWidth())>(step.getXPos() + step.getWidth()))){
                hero.setXPos(step.getXPos()+step.getWidth() + 1);
            }
            else if ((hero.getXPos()<step.getXPos())&&((hero.getXPos()+hero.getWidth())>step.getXPos())){
                hero.setXPos(step.getXPos()-hero.getWidth() - 1);
            }
        }
        else if((hero.getXPos() < (step.getXPos() + step.getWidth())) && ((hero.getXPos() + hero.getWidth()) > step.getXPos())){
            if ((hero.getYPos() < step.getYPos())&& ((hero.getYPos()+hero.getHeight() > step.getYPos()))){
                hero.setYPos(hero.getYPos() - 1);
            }
            else if((hero.getYPos() < (step.getYPos() + step.getHeight()))&&((hero.getYPos() + hero.getHeight())> (step.getYPos()+step.getHeight()))){
                hero.setYPos(hero.getYPos() + 1);
            }
        }
    }

    @Override
    public double getFloorHeight() {
        return floorHeight;
    }

    @Override
    public double getHeroX() {
        return hero.getXPos();
    }

    @Override
    public double getHeroY() {
        return hero.getYPos();
    }

    @Override
    public boolean boostHeight() {
        hero.setYVel(-1.0);
        return true;
    }

    @Override
    public boolean dropHeight() {
        hero.setYVel(1.0);
        return true;
    }

    @Override
    public boolean moveLeft() {
        hero.setXAcc(-0.1);
        return true;
    }

    @Override
    public boolean moveRight() {
        hero.setXAcc(0.1);
        return true;
    }

    @Override
    public boolean stopBoostHeight() {
        hero.setYVel(0.0);
        return true;
    }

    @Override
    public boolean stopDropHeight() {
        hero.setYVel(0.0);
        return true;
    }

    @Override
    public boolean stop(){
        hero.stop();
        return true;
    }

    public Hero getHero(){
        return hero;
    }
}
