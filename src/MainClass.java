import java.sql.SQLException;

public class MainClass {
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		view.setVisible(true);
	}
}
