/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
    Created on : Sep 23, 2016, 1:51:38 PM
    Author     : DanFrancis
*/

package draftselection;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class DraftSelection extends Application {
        public static void main(String[] args) {
        launch(args);
    }
    
    
    final Label teamSelection = new Label ();
    final Label categorySelection = new Label ();
    final Button buttonSubmit = new Button ("Submit Pick");
    final Button buttonCancel = new Button ("Cancel Last Pick");
    final Label select = new Label ();
    
    
    
    
    String category = " ";
    String team = " ";
    
    
    @Override public void start(Stage stage) {
        
        stage.setTitle("Freund Football Draft Selection");
        Scene scene = new Scene(new Group(), 858, 390);
        scene.getStylesheets().add("draftselection/DraftSelection.css");
        
        final Text noTeam = new Text();
            noTeam.setId("noTeam");    
            
        final Label player = new Label ("PORKCHOP");
            player.setId("playerText");        
        
        final ImageView imageHelmet = new ImageView(new Image(DraftSelection.class.getResourceAsStream("graphics/helmetlogo/packers.png")));
            imageHelmet.setFitHeight(219);
            imageHelmet.setFitWidth(232);    
            
        final ImageView imageDraft = new ImageView(new Image(DraftSelection.class.getResourceAsStream("graphics/draft.jpg")));
            
            //grid.add(new ImageView(new Image(DraftSelection.class.getResourceAsStream("graphics/large-logo.png"))), 0, 0);
            
        final ComboBox teamBox = new ComboBox();
                teamBox.getItems().addAll(
                "Arizona Cardinals", "Atlanta Falcons", "Baltimore Ravens", "Buffalo Bills", "Carolina Panthers", "Chicago Bears", "Cincinnati Bengals",
                "Cleveland Browns", "Dallas Cowboys", "Denver Broncos", "Detroit Lions", "Green Bay Packers", "Houston Texans", "Indianapolis Colts",
                "Jacksonville Jaguars", "Kansas City Chiefs", "Los Angeles Rams", "Miami Dolphins", "Minnesota Vikings", "New England Patriots",
                "New Orleans Saints", "New York Giants", "New York Jets", "Oakland Raiders", "Philadelphia Eagles", "Pittsburgh Steelers", "San Diego Chargers",
                "San Francisco 49ers", "Seattle Seahawks", "Tampa Bay Buccaneers", "Tennessee Titans", "Washington Redskins" );   
                teamBox.setId("teamBox-text");
                teamBox.setPromptText("Select Team");
                teamBox.setVisibleRowCount(6);
                teamBox.setMaxWidth(Double.MAX_VALUE);
                
                teamBox.valueProperty().addListener(new ChangeListener<String>() {
                    @Override public void changed(ObservableValue ov, String t, String t1) {
                        team = t1;                
                    }    
                });
                
        final ComboBox categoryBox = new ComboBox();
                categoryBox.getItems().addAll("Passing", "Rushing", "Special", "Defense", "Wins" );   
                categoryBox.setId("catBox-text");
                categoryBox.setPromptText("Select Category");
                categoryBox.setVisibleRowCount(5);
                categoryBox.setMaxWidth(Double.MAX_VALUE);
                
                categoryBox.valueProperty().addListener(new ChangeListener<String>() {
                    @Override public void changed(ObservableValue ov, String t, String t1) {
                        category = t1;                
                    }    
                });
                
                //categoryBox.valueProperty().addListener(new ChangeListener<ImageView>() {
                //    @Override public void changed(ObservableValue ov, ImageView t, ImageView t1) {
               //         imageHelmet = t1;                
                //    }    
                //});
                
                Button btnSubmit = new Button("Submit Pick");
                    btnSubmit.setMaxWidth(Double.MAX_VALUE);
                    
                Button btnCancel = new Button("Cancel Last Pick");
                    btnCancel.setMaxWidth(Double.MAX_VALUE);
            
                btnSubmit.addEventHandler(ActionEvent.ACTION, (e)-> {
                      teamSelection.setText(team);   
                      categorySelection.setText(category);
                      select.setText("Selects");
                      noTeam.setText("");
                      
                      if(teamBox.getValue() == null || categoryBox.getValue() == null){
                      noTeam.setText("Please Select Team & Category");
                      teamSelection.setText(""); 
                      categorySelection.setText("");
                      select.setText("");
                      }
                      
                      teamBox.setValue(null);   
                      categoryBox.setValue(null); 
                      
                 });
            
                btnCancel.addEventHandler(ActionEvent.ACTION, (e)-> {
                      teamSelection.setText(""); 
                      categorySelection.setText("");
                      select.setText("");
                });
                
        
        
            
        final Label onClock = new Label ("    ON THE CLOCK :");
            onClock.setId("topRowText");
            
        final Label round = new Label (" ROUND :");
            round.setId("topRowText");    
            
                  
        
            
        final Label roundNumber = new Label ("15");
            roundNumber.setId("playerText");  
            
        
            
        
        
        GridPane grid = new GridPane();
        
        ColumnConstraints column1 = new ColumnConstraints(78);   
        ColumnConstraints column2 = new ColumnConstraints(110);
        ColumnConstraints column3 = new ColumnConstraints(10);
        ColumnConstraints column4 = new ColumnConstraints(120);
        ColumnConstraints column5 = new ColumnConstraints(120);
        ColumnConstraints column6 = new ColumnConstraints(120);
        ColumnConstraints column7 = new ColumnConstraints(130);
        ColumnConstraints column8 = new ColumnConstraints(50);
        grid.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
        
        RowConstraints row1 = new RowConstraints(108);   
        RowConstraints row2 = new RowConstraints(10);
        RowConstraints row3 = new RowConstraints(40);
        RowConstraints row4 = new RowConstraints(40);
        RowConstraints row5 = new RowConstraints(40);
        RowConstraints row6 = new RowConstraints(40);
        
        grid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);
            
        grid.setStyle("-fx-background-color: BLACK;");
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 25, 25, 25));
        
        final Separator sepVert1 = new Separator();
            sepVert1.setOrientation(Orientation.VERTICAL);
            sepVert1.setValignment(VPos.CENTER);
            sepVert1.setPrefHeight(219);
            GridPane.setConstraints(sepVert1, 2, 1);
            GridPane.setRowSpan(sepVert1, 7);
            
        final Separator sepHor1 = new Separator();
            sepHor1.setOrientation(Orientation.HORIZONTAL);
            sepHor1.setHalignment(HPos.CENTER);
            sepHor1.setPrefWidth(788);
            GridPane.setConstraints(sepHor1, 0, 1);
            GridPane.setColumnSpan(sepHor1, 8);    
            
         
        
        grid.getChildren().addAll( sepVert1, sepHor1);
                
        grid.add(new ImageView(new Image(DraftSelection.class.getResourceAsStream("graphics/large-logo.png"))), 0, 0);
        grid.add(imageHelmet, 3, 2, 2, 5);
        //grid.add(imageDraft, 3, 2, 2, 5);
        grid.add(onClock, 1, 0, 3, 1);
        grid.add(player, 4, 0, 2, 1);
        grid.add(teamBox, 0, 2, 2, 1);
        grid.add(categoryBox, 0, 3, 2, 1);
        grid.add(btnSubmit, 0, 4, 2, 1);
        grid.add(btnCancel, 0, 5, 2, 1);
        grid.add(round, 6, 0);
        grid.add(roundNumber, 7, 0);
        grid.add(select, 5, 3, 3, 1);
        grid.add(teamSelection, 5, 4, 3, 1); 
        grid.add(categorySelection, 5, 5, 3, 1); 
        grid.add(noTeam, 0,6, 2, 1);
        //grid.add(playerRecent, 5, 2, 3, 1);
        
        
        //GridPane.setHalignment(playerRecent, HPos.CENTER); //player
        GridPane.setHalignment(select, HPos.CENTER);
        GridPane.setHalignment(teamSelection, HPos.CENTER);
        GridPane.setHalignment(categorySelection, HPos.CENTER);
        GridPane.setHalignment(noTeam, HPos.CENTER);
        
                
        //grid.setGridLinesVisible(true);
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
}
