package src;
import javax.swing.SwingUtilities;

    public class MainAppTemp {
        public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ActionSuggestion action = new ActionSuggestion();
            action.showGUI();
        });

    }
}
