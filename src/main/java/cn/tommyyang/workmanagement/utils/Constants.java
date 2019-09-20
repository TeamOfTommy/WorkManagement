package cn.tommyyang.workmanagement.utils;

import cn.tommyyang.slf4j4json.Logger;
import cn.tommyyang.slf4j4json.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author : TommyYang
 * @Time : 2019-09-11 18:11
 * @Software: IntelliJ IDEA
 * @File : Constants.java
 */
public class Constants {

    private static final String CONFIG_FILE = "constants.properties";
    private static Properties properties = new Properties();

    private static final Logger LOG = LoggerFactory.getLogger(Constants.class);

    static {
        InputStream inStream = Constants.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        try {
            properties.load(inStream);
        } catch (IOException e) {
            LOG.error().strField("event", "load-constants").strField("error", e.getMessage())
                    .exception("\nexception:\n", e).log();
        }
    }

    public static final String WEB_ROOT = properties.getProperty("web_root", "http://fengrui.snailsheep.com");

    public static final String FILE_DIR = properties.getProperty("excel_dir", "/data/wwwroot/fengrui.snailsheep.com/excels");

}
