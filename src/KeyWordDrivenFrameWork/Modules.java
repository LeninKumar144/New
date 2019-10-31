package KeyWordDrivenFrameWork;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Modules {
	public KeyWordEngine keyWordEngine;
  @Test
  public void f() {
	  keyWordEngine = new KeyWordEngine();

	  keyWordEngine.startExecution("UserLogin");
  }
}
