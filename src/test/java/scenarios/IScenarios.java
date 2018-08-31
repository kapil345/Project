package scenarios;

public abstract class IScenarios {

    public abstract void execute();
    public abstract void verify();

    public void run() {
        execute();
        verify();
    }
}
