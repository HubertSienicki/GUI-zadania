package GUI_PROJECT_2;

public class main {
    public static void main(String[] args) {
        View view = new View();
        FileContent fileContent = new FileContent();

        Controller controller = new Controller(view, fileContent);

        controller.initController();
    }
}
