package com.luffy.mqtt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description 读取配置文件
 * @fiel com.luffy.mqtt.util.PropertiesUtil
 * @author Jimmy
 * @date 2018-07-03 14:04:48
 */
public class PropertiesUtil {

    public static final String MQTT_HOST;
    public static final String MQTT_CLIENT_ID;
    public static final String MQTT_USER_NAME;
    public static final String MQTT_PASSWORD;
    public static final int MQTT_TIMEOUT;
    public static final int MQTT_KEEP_ALIVE;


    private static  Properties PROPERTIES;

    static {
        loadMqttProperties();
        MQTT_HOST = PROPERTIES.getProperty("host");
        MQTT_CLIENT_ID = PROPERTIES.getProperty("clientId");
        MQTT_USER_NAME = PROPERTIES.getProperty("userName");
        MQTT_PASSWORD = PROPERTIES.getProperty("passWord");
        MQTT_TIMEOUT = Integer.valueOf(PROPERTIES.getProperty("timeOut"));
        MQTT_KEEP_ALIVE = Integer.valueOf(PROPERTIES.getProperty("keepAlive"));

    }


    /**
     * @description 加载配置文件
     * @author Jimmy
     * @date 2018-06-28 16:44:04
     * @param
     * @return java.util.Properties
     */
    private static Properties loadMqttProperties() {
        if(null == PROPERTIES){
            synchronized (PropertiesUtil.class){
                if(null == PROPERTIES){
                    PROPERTIES = new Properties();
                    try (InputStream inputstream = PropertiesUtil.class.getResourceAsStream("/application.yml")){
                        PROPERTIES.load(inputstream);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return PROPERTIES;
    }
}
