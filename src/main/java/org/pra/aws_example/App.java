package org.pra.aws_example;

import com.amazonaws.util.EC2MetadataUtils;
import org.apache.hadoop.thirdparty.com.google.common.collect.Lists;
import org.apache.hadoop.util.ApplicationClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Hello world!
 */
public class App
{
  public static void main(String[] args)
  {
    Logger LOG = LoggerFactory.getLogger(App.class.getName());
    try {
      App app = new App();
      new EC2MetadataUtils();
      ApplicationClassLoader classLoader = new ApplicationClassLoader("target/libs/*", app.getClass().getClassLoader(),
                                                                      Lists.<String>newArrayList("")
      );
      classLoader.loadClass("com.fasterxml.jackson.databind.PropertyNamingStrategies");
      classLoader.loadClass("com.amazonaws.util.EC2MetadataUtils");
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
