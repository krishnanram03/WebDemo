package Framework.BaseComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count=0;
	int maxTry=2;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxTry)
		{
			count++;
			result.setAttribute("retry", true);
			return true;
		}
		return false;
	}

}
