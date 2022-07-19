package com.stackroute.testsuites;

import com.stackroute.MathServiceTest;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectPackages("com.stackroute")
//@SelectPackages({"", ""})
@SelectClasses(MathServiceTest.class)
//can choose package or specific class
@IncludeTags("smoke")
//filter by tags
public class BasicServiceTestSuite {
}
