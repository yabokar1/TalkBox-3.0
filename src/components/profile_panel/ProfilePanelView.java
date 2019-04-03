package components.profile_panel;

import java.util.ArrayList;

import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ProfilePanelView {
	
	
	private TreeView treeView;
	
	private TreeItem root;
	
	
	public ProfilePanelView(){
		
		this.root = new TreeItem<String>("Default Profile");
		
		this.treeView = new TreeView(this.root);
		
		
		addSoundToCurrentProfile("First Sound");
		
		
//		TextField enterProfile = new TextField("Enter Profile");
//		enterProfile.setOnMouseClicked(e -> enterProfile.clear());
//		enterProfile.setOnAction(e -> {
//		profile.setProfileTitle(enterProfile.getText());
//			panel.getChildren().clear();
//			panel.resetColumn();
//			panel.resetRow();
//			
//
//		 });
//		
//		ArrayList<TreeItem<String>> profileSet = new ArrayList<TreeItem<String>>();
//		
//		this.profiles.add(this.profileSet);
//		
//		
//		
//		TreeItem<String> newItem = new TreeItem<String>(e);
		
//		newItem.setExpanded(false);
		

	}
	
	
	public void addSoundToCurrentProfile(String soundName) {
		
		
		TreeItem<String> newItem = new TreeItem<String>(soundName);
		
		newItem.setExpanded(false);

		this.root.getChildren().add(newItem);
	}

	
	
	
	public TreeView getView() {
		
		return this.treeView;
	}
}
