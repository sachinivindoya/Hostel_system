package lk.D24.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.D24.dto.StudentDTO;
import lk.D24.service.ServiceFactory;
import lk.D24.service.ServiceType;
import lk.D24.service.custom.StudentService;
import lk.D24.util.Navigation;
import lk.D24.util.Routes;
import lk.D24.view.tm.StudentTm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentManageFormController {
    public AnchorPane pane;
    public JFXButton btnBack;
    public JFXButton btnSaveUpdate;
    public JFXButton btnRemove;
    public JFXTextField txtStId;
    public JFXTextField txtStName;
    public JFXTextField txtStAddress;
    public JFXTextField txtStContact;
    public JFXTextField txtStDob;
    public JFXTextField txtStGender;
    public TableView tblStudentDtl;
    public TableColumn colStId;
    public TableColumn colStName;
    public TableColumn colStAddress;
    public TableColumn colStContact;
    public TableColumn colStDob;
    public TableColumn colStGender;
    public TableColumn colStOption;
    public StudentService studentService;
    private String Id;


    public void initialize() {
        this.studentService = ServiceFactory.getInstance().getService(ServiceType.STUDENT);
        initializeTable();
        setTableData();
    }

    private void initializeTable() {

        colStId.setCellValueFactory(new PropertyValueFactory<>("student ID"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        colStDob.setCellValueFactory(new PropertyValueFactory<>("Date of Birth"));
        colStGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        colStOption.setCellValueFactory(new PropertyValueFactory<>("Option"));

        tblStudentDtl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                btnSaveUpdate.setText("Update");
                setData((StudentTm) newValue);
            }
        });
    }

    private void setData(StudentTm studentTm) {

        Id = studentTm.getStudentID();
        txtStName.setText(studentTm.getName());
        txtStAddress.setText(studentTm.getAddress());
        txtStContact.setText(studentTm.getContact());
        txtStDob.setText(studentTm.getDoB());
        txtStGender.setText(studentTm.getGender());
    }

    private void setTableData() {

        List<StudentTm> tmList = studentService.getAllStudent().stream().map(studentDTO -> new StudentTm(studentDTO.getStudentID(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(), studentDTO.getDoB(),studentDTO.getGender(),getBtn(studentDTO))).collect(Collectors.toList());
        tblStudentDtl.setItems(FXCollections.observableArrayList(tmList));
    }

    private JFXButton getBtn(StudentDTO s) {

        JFXButton btn = new JFXButton("Delete");
        btn.setStyle("-fx-background-color: #e55039; -fx-background-radius: 20; -fx-text-fill: #ffffff;");
        btn.setOnAction(event -> {
            deleteStudent(s);
        });
        return btn;
    }

    private void deleteStudent(StudentDTO studentDTO) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure do you want to delete this Student ?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            studentService.deleteStudent(studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully delete student !", ButtonType.OK).show();
            setTableData();
            clear();
        }
    }

    private void clear() {

        txtStName.clear();
        txtStAddress.clear();
        txtStContact.clear();
        txtStDob.clear();
        txtStGender.clear();
        btnSaveUpdate.setText("Add");
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        if (txtStName.getText().isEmpty() || !txtStName.getText().matches("([\\w ]{1,})")) {
            new Alert(Alert.AlertType.ERROR, "Name text invalid or empty", ButtonType.OK).show();
            txtStName.setFocusColor(Paint.valueOf("Red"));
            txtStName.requestFocus();
            return;
        }else if (txtStAddress.getText().isEmpty() || !txtStAddress.getText().matches("([\\w ]{1,})")) {
            new Alert(Alert.AlertType.ERROR, "Address text invalid or empty", ButtonType.OK).show();
            txtStAddress.setFocusColor(Paint.valueOf("Red"));
            txtStAddress.requestFocus();
            return;
        }else if(txtStContact.getText().isEmpty() || !txtStContact.getText().matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")) {
            new Alert(Alert.AlertType.ERROR, "Salary text invalid or empty", ButtonType.OK).show();
            txtStContact.setFocusColor(Paint.valueOf("Red"));
            txtStContact.requestFocus();
            return;
        }else if(txtStDob.getText().isEmpty() || !txtStDob.getText().matches("^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$" )) {
            new Alert(Alert.AlertType.ERROR, "Salary text invalid or empty", ButtonType.OK).show();
            txtStDob.setFocusColor(Paint.valueOf("Red"));
            txtStDob.requestFocus();
            return;
        }else if (txtStGender.getText().isEmpty() || !txtStGender.getText().matches("([\\w ]{1,})")) {
            new Alert(Alert.AlertType.ERROR, "Address text invalid or empty", ButtonType.OK).show();
            txtStGender.setFocusColor(Paint.valueOf("Red"));
            txtStGender.requestFocus();
            return;
        }else if (btnSaveUpdate.getText().equalsIgnoreCase("Add")) {
            if (studentService.saveStudent(new StudentDTO(studentService.getNextPk(), txtStName.getText(), txtStAddress.getText(), txtStContact.getText(),txtStDob.getText(),txtStGender.getText())) == null){
                new Alert(Alert.AlertType.ERROR, "Failed to save the student !", ButtonType.OK).show();
                return;
            }
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully added student !", ButtonType.OK).show();
            setTableData();
            clear();
        }else {
            if (studentService.updateStudent(new StudentDTO(Id, txtStName.getText(), txtStAddress.getText(),txtStContact.getText(),txtStDob.getText(),txtStGender.getText())) == null) {
                new Alert(Alert.AlertType.ERROR, "Failed to update the student !", ButtonType.OK).show();
                return;
            }
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully update student !", ButtonType.OK).show();
            setTableData();
            clear();
        }

    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        clear();
    }

    public void txtStIdOnAction(ActionEvent actionEvent) {
    }
}
