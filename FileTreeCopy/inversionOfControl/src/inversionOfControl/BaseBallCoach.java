package inversionOfControl;

public class BaseBallCoach implements Coach{

    @Override
    public void getDailyWorkout(){
        System.out.println("I am BaseBall Coach\n"+"BaseBall Call Coach Workout for 30 min.");
    }

}
