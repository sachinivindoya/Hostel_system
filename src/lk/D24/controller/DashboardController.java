package lk.D24.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.D24.util.Navigation;
import lk.D24.util.Routes;

public class DashboardController {

    public Button btnSt;
    public AnchorPane pane;

    public void btnStOnAction(ActionEvent actionEvent) {
        Navigation.navigate(Routes.STUDENT,pane);
    }
}
