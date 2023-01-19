package bank.test;

import org.junit.Test;

import bank.tools.MD5Tools;

public class MyTest {
	
	@Test
	public void test() {
		MD5Tools md5Tools = new MD5Tools();
		System.out.println(md5Tools.string2MD5("awe45a6e546aw4eawea4we54aw6e456w4e6awe6aw4e5wa4564aw56e4a5w64e56aw4e56456szd4fdkfgiofdjgiodfjgiodfjgiodfjigojgiofd").length());
		
	}
}
