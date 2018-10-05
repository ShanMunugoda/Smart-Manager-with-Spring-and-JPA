/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.comp.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author SDMROX
 */
public class AppInitializer extends Application{

    public static AnnotationConfigApplicationContext ctx;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
                    ctx=new AnnotationConfigApplicationContext();
                    ctx.register(AppConfig.class);
                    ctx.refresh();
        try {

            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/comp/view/Main.fxml"));

            Scene mainScene = new Scene(root);

            primaryStage.setTitle("Company-Management-System");
            primaryStage.setScene(mainScene);
            primaryStage.setResizable(false);
            
            primaryStage.show();
           

        } catch (IOException ex) {
            Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public static void navigateToHome(Node node, Stage mainStage) {

    
            TranslateTransition tt = new TranslateTransition(Duration.millis(300), node);
            tt.setFromX(0);
            tt.setToX(-node.getScene().getWidth());
            tt.play();
            
            Platform.runLater(()->{
            
                try {
                    Parent root = FXMLLoader.load(AppInitializer.class.getResource("/lk/ijse/comp/view/Main.fxml"));
                    Scene mainScene = new Scene(root);
                    mainStage.setScene(mainScene);
                    
                    TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
                    tt1.setToX(0);
                    tt1.setFromX(-mainScene.getWidth());
                    tt1.play();
                    
                    mainStage.centerOnScreen();
                } catch (IOException ex) {
                    Logger.getLogger(AppInitializer.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            });
    }
    
}
