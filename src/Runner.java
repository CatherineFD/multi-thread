import controller.Controller;
import model.Model;
import setting.WindowCreator;
import view.View;

public class Runner {

    public Runner() {}

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        WindowCreator windowCreator = new WindowCreator();
        View view = new View(controller, model, windowCreator);



        controller.startGame();
    }


}
