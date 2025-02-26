package IRetryAnalyzer;

//import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AnalyzerTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAnalyzer(){
        System.out.println("failed");

    }
}
