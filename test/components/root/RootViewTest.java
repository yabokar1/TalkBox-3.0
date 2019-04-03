package components.root;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.layout.HBox;

class RootViewTest {

	@Test
	void test() {
		RootView rv = new RootView();
		
		rv.addChildView(new HBox());
		
		assertEquals(1,rv.getChildren().size());
	}

}
