package GUI_PROJECT_2;

public class main {
    public static void main(String[] args) {
        View view = new View();

        Controller controller = new Controller(view);

        controller.initController();
    }
}