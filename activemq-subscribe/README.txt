activemq-subscribe  ActiveMq  订阅模式
在测试类encryptActiveMqPwd方法中生成自己的activemq的密码,并修改配置文件中activemq密码
直接启动ActivemqPointApplication中的main方法,会看到任务自动发布
订阅模式需要设置jms.pub-sub-domain=true开启订阅模式支持


订阅模式：
    当一条记录被发布,所有订阅了这个主题的消费者，都会收到发布内容