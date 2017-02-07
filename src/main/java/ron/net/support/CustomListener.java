package ron.net.support;

import org.testng.IExecutionListener;

/**
 * Created by RomanTo on 2/6/2017.
 */
public class CustomListener implements IExecutionListener {
    private int m_count = 0;

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG is going to start");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG is finished");
    }

}
