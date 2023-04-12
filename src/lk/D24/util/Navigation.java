package lk.D24.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case STUDENT:
                window.setTitle("Student Manage");
                initUI("StudentManageForm.fxml");
                break;

            case DASHBOARD:
                window.setTitle("Dashboard Manage");
                initUI("Dashboard.fxml");
                break;

        }
    }

    public static void initUI(String location) {
        try {
            Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/D24/resources/view/" + location)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
