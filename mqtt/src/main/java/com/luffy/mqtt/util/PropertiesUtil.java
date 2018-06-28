package com.luffy.mqtt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Jimmy on 2018/6/28
 */
public class PropertiesUtil {

    public static final String MQTT_HOST;
    public static final String MQTT_CLIENT_ID;
    public static final String MQTT_USER_NAME;
    public static final String MQTT_PASSWORD;
    public static final int MQTT_TIMEOUT;
    public static final int MQTT_KEEP_ALIVE;


    private static  Properties properties;

    static {
        loadMqttProperties();
        MQTT_HOST = properties.getProperty("host");
        MQTT_CLIENT_ID = properties.getProperty("clientId");
        MQTT_USER_NAME = properties.getProperty("userName");
        MQTT_PASSWORD = properties.getProperty("passWord");
        MQTT_TIMEOUT = Integer.valueOf(properties.getProperty("timeOut"));
        MQTT_KEEP_ALIVE = Integer.valueOf(properties.getProperty("keepAlive"));

    }


    /**
     * @description 加载配置文件
     * @author Jimmy
     * @date 2018-06-28 16:44:04
     * @param
     * @return java.util.Properties
     */
    private static Properties loadMqttProperties() {
        if(null == properties){
            synchronized (PropertiesUtil.class){
                if(null == properties){
                    properties = new Properties();
                    try (InputStream inputstream = PropertiesUtil.class.getResourceAsStream("/application.yml")){
                        properties.load(inputstream);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return properties;
    }
}
