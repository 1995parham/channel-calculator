package test;

import com.zolaliran.channelcalculator.gui.MainWindow;
import com.zolaliran.channelcalculator.log.DefaultLogger;

public class Main {

	public static void main(String[] args) {
		try {
			new MainWindow().setVisible(true);
		} catch (Exception exception) {
			DefaultLogger.getInstance().logException(exception);
		}
	}

}
