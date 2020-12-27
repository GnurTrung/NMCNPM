package src.view;

import com.utils.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import src.model.Product;

public class ProductController implements Initializable {
    //region khai báo biến controls
    @FXML
    public TableView<Product> tableProduct;
    @FXML
    public TableColumn<Product, String> colProductID;
    @FXML
    public TableColumn<Product, String> colProductName;
    @FXML
    public TableColumn<Product, String> colProductUnit;
    @FXML
    public TableColumn<Product, String> colProductDetail;
    @FXML
    public TableColumn<Product, String> colProductPrice;
    @FXML
    public TextField txtProductName;
    @FXML
    public TextField txtProductId;
    @FXML
    public TextField txtProductUnit;
    @FXML
    public TextField txtProductDetail;
    @FXML
    public TextField txtProductPrice;
    @FXML
    public Button btnAddProduct;
    @FXML
    public Button btnDeleteProduct;
    @FXML
    public Button btnEditProduct;
    @FXML
    public TextField textSearch;
    @FXML
    public AnchorPane panelSach;
    @FXML
    public ImageView imgAnhBia;
    //endregion

    //region controller
    private ObservableList<Product> listProduct;
    //endregion

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCell();
        loadData();

        //check permission
        if(Account.currentUser.getIdper() == 1) {
            btn1.setVisible(false);
            btn2.setVisible(false);
            btn3.setVisible(false);
        }

        txt1.setEditable(false);
        txt2.setEditable(false);
        txt3.setEditable(false);
        txt4.setEditable(false);
        txt5.setEditable(false);

        textTimKiem.textProperty().addListener((observableValue, s, t1) -> {
            listProduct.clear();
           //TO-DO listProduct.addAll(ProductService.getInstance().searchProduct(t1));
        });
    }

    private void setCell() {
        // TO-DO viết các hàm lấy dữ liệu 
        // colID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        // colName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        // colUnit.setCellValueFactory(cellData -> cellData.getValue().maTheLoaiProperty());
        // colDetail.setCellValueFactory(cellData -> cellData.getValue().maTacGiaProperty());
        // colPrice.setCellValueFactory(cellData -> cellData.getValue().namXBProperty().asObject());
    }

    private void loadData() {
        //
        //listProduct = FXCollections.observableArrayList(ProductService.getInstance().getAllSach());
        //tableProduct.setItems(listProduct);
    }

    public void refreshTable() {
        listProduct.clear();
        loadData();
        clearInput();
    }

    public void clearInput() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
    }
    public void bindingData() {
        // không cần thiết
        // Sach temp = tableSach.getSelectionModel().getSelectedItem();
        // System.out.println(TacGiaService.getInstance().getTacGiaByID(temp.getMaTacGia()));
        // txtMaSach.setText(temp.getMaSach());
        // txtTenSach.setText(temp.getTenSach());
        // txtMaTacGia.setText((String.valueOf(temp.getMaTacGia())) + " - " + TacGiaService.getInstance().getTacGiaByID(temp.getMaTacGia()).getTenTacGia());
        // txtMaTheLoai.setText((String.valueOf(temp.getMaTheLoai())) + " - " + TheLoaiService.getInstance().getTheLoaiByID(temp.getMaTheLoai()).getTenTheLoai());
        // txtNamXB.setText((String.valueOf(temp.getNamXB())));;
        // txtNXB.setText(temp.getNXB());
        // txtNgayNhap.setText((String.valueOf(temp.getNgayNhap())));
        // txtTriGia.setText((String.valueOf(temp.getTriGia())));
        // txtSoLuong.setText((String.valueOf(temp.getSoLuong())));
        // if (String.valueOf(temp.getTinhTrang()).equals("Trống"))
        // {
        //     rdbTrong.setSelected(true);
        //     rdbDangMuon.setSelected(false);
        //     rdbMat.setSelected(false);
        //     rdbHuHong.setSelected(false);
        // }
        // else if(String.valueOf(temp.getTinhTrang()).equals("Đang mượn"))
        // {
        //     rdbDangMuon.setSelected(true);
        //     rdbTrong.setSelected(false);
        //     rdbMat.setSelected(false);
        //     rdbHuHong.setSelected(false);
        // }
        // else if(String.valueOf(temp.getTinhTrang()).equals("Mất"))
        // {
        //     rdbMat.setSelected(true);
        //     rdbTrong.setSelected(false);
        //     rdbDangMuon.setSelected(false);
        //     rdbHuHong.setSelected(false);
        // }
        // else
        // {
        //     rdbHuHong.setSelected(true);
        //     rdbTrong.setSelected(false);
        //     rdbDangMuon.setSelected(false);
        //     rdbMat.setSelected(false);
        // }

        // System.out.println(temp.getImage());
        // imgAnhBia.setImage(temp.getImage());
        // imgAnhBia.setCache(true);

    }

    public void btnAddProduct_Click(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/AddProductDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            //
            AddProductController addProductController = loader.getController();
            addProductController.setProductController(this);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEditProduct_Click(ActionEvent event) {
        if (tableProduct.getSelectionModel().getSelectedIndex() >= 0) {
            Product temp = tableProduct.getSelectionModel().getSelectedItem();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/EditProductDialog.fxml"));
                AnchorPane page = (AnchorPane) loader.load();

                // Create the dialog Stage.
                Stage dialogStage = new Stage();
                dialogStage.initStyle(StageStyle.UNDECORATED);
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);
                //
                EditProductController editProductController = loader.getController();
                editProductController.setProductController(this);
                editSachController.setEditSach(temp);
                dialogStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("THÔNG BÁO");
            alert.setHeaderText("Chưa chọn sản phẩm cần chỉnh sửa!");
            alert.showAndWait();
        }
    }

    public void btnDeleteProduct_Click(ActionEvent event) {

        if (tableProduct.getSelectionModel().getSelectedIndex() >= 0) {
            Product temp = tableProduct.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xóa sách");
            alert.setHeaderText("Bạn muốn xóa sản phẩm này ra khỏi danh sách?");
            alert.setContentText("[" + temp.getID() + "] " + temp.getName()); 

            // option != null.
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == null) {
            } else if (option.get() == ButtonType.OK) {
                int rs = SachService.getInstance().deleteSach(temp.getMaSach());
                Util.showSuccess(rs, "Quản lý sản phẩm", "Xóa sản phẩm thành công!");
                refreshTable();
            } else if (option.get() == ButtonType.CANCEL) {
            } else {
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("THÔNG BÁO");
            alert.setHeaderText("Chưa chọn sản phẩm cần xóa!");
            alert.showAndWait();
        }

    }
}
