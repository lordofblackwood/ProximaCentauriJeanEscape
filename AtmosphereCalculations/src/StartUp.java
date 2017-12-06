import controller.EquationController;
import model.EquationModel;
import view.EquationView;

public class StartUp {
  public static void main(String[] args) {
    EquationModel model = new EquationModel();
    EquationView view = new EquationView();
    EquationController controller = new EquationController(model, view);
    view.setListener(controller);
    controller.StartView();
  }
}
