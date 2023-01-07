package io.zenwave360.example.adapters.web;



import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Integration Tests with WebTestClient for OpenAPI")
@SelectClasses({
    CustomerApiIT.class,
    CustomerOrderApiIT.class,
})
@IncludeClassNamePatterns({ "^.*IT$" })
public class ControllersTestSet {
}
