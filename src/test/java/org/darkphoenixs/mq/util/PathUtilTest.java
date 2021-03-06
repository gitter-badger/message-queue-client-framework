package org.darkphoenixs.mq.util;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class PathUtilTest {

	@Test
	public void test() throws Exception {
		
		Assert.assertNotNull(new PathUtil());
		Assert.assertEquals("conf", PathUtil.CONF);
		Assert.assertEquals(System.getProperty("user.dir"), PathUtil.PATH);
		Assert.assertEquals(File.separator, PathUtil.SEPARATOR);
		System.out.println(PathUtil.CONF_PATH);
	}
}
