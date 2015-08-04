/*
 * Farhad Amiri date: 7/31/2015
 * class: CSCI 202 
 * Purpose: JavaFX two movable vertices and their distances
 * 
 */
package assignment6;

/**
 *
 * @ import the required javaFX objects
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.geometry.Point2D;

/**
 *@Required: variables and correct location 
 * @Ensure: show the result and drag the circles 
 * 
 */
public class assignment6 extends Application {
// decalaring global variable for x and y cordinate 
    double x = 40;
    double x1 = 120;
    double y = 40;
    double y1 = 150;
    double width = 250;
    double height = 300;

    @Override
    // start primary stage 
    public void start(Stage primaryStage) {
        // creating a pane to hold the nodes
        Pane pane = new Pane();
        // creating two circles with radius of 10 , set color
        Circle circle1 = new Circle(x, y, 10);
        Circle circle2 = new Circle(x1, y1, 10);
        circle1.setFill(Color.RED);
        circle2.setFill(Color.BLUE);
        // creating line and put it on the center 
        Line line = new Line(x, y, x1, y1);
        line.setFill(Color.YELLOW);
        Point2D p = new Point2D(x1, y1);
        Text t = new Text((x + x1) / 2, (y + y1) / 2, p.distance(x, y) + "");
        pane.getChildren().addAll(circle1, circle2, line, t);
        
        // handle the action while the mouse dragging and update the distance measurment
        circle1.setOnMouseDragged(e -> {

            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
            line.setStartX(e.getX());
            line.setStartY(e.getY());
            t.setX((e.getX() + x) / 2);
            t.setY((e.getY() + y) / 2);

            t.setText(p.distance(e.getX(), e.getY()) + "");

        });// Set On Mouse for circle1
        circle2.setOnMouseDragged(e -> {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());

            line.setEndX(e.getX());
            line.setEndY(e.getY());
            t.setX((e.getX() + x) / 2);
            t.setY((e.getY() + y) / 2);

            t.setText(p.distance(e.getX(), e.getY()) + "");

        });// Set On Mouse for circle2

       // set the pane in the scene with hight and width
        Scene scene = new Scene(pane, 250, 300);
        // set the scene in the primary stage to show 
        primaryStage.setScene(scene);
        primaryStage.show();

    }// Start Method

    /**
     * @Ensure launch the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }// Main 

}// Class
