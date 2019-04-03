package components.audio_list;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class AudioSampleListView {
	
	
	private static final int LIST_ELEMENT_WIDTH = 200;
	
	private static final int LIST_ELEMENT_HEIGHT = 175;
	
	
	
	private ListView<String> _listView;



	
	
	
	public AudioSampleListView(AudioSampleList model) {
		
	
		
		_listView = new ListView<String>();
		
		
		for(String e: model.getAll()) {
			
			_listView.getItems().add(e);
		}
		this._listView.setMinSize(LIST_ELEMENT_WIDTH, LIST_ELEMENT_HEIGHT);
		
		this._listView.getSelectionModel()
		  .selectedItemProperty()
		  .addListener(model);
	
	}
	

	
	
	public ListView<String> getList() {
		
		return this._listView;
	}

	
	
	
	public VBox getView() {
		
		
		return new VBox(this._listView);

	}
	
	

}
