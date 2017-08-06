activemq-point  ActiveMq  点对点模式
在测试类encryptActiveMqPwd方法中生成自己的activemq的密码,并修改配置文件中activemq密码
直接启动ActivemqPointApplication中的main方法,会看到任务自动发布
在浏览器中输入http://localhost:8080/send/jaood,也可以发布内容
在浏览器中输入http://localhost:8080/index,可以测试thymeleaf模版
点对点模式需要设置jms.pub-sub-domain=false关闭订阅模式支持

关于springboot使用thymeleaf模版,参考http://blog.csdn.net/u014695188/article/details/52347318


点对点模式：
    当一条记录被发布,有且只有一个消费者者能获取到发布内容