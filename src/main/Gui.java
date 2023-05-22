package main;

/**
 * Super class Gui to inherit subclass gui
 * @author H Yang
 */
public abstract class Gui implements UserInterface{

    /**
     * game environment which has all of this game system
     */
    protected GameEnvironment gameEnvironment;

    /**
     * initial setup about each user interface
     * @param gameEnvironment this program's entire system
     */
    public abstract void setup(GameEnvironment gameEnvironment);

}
