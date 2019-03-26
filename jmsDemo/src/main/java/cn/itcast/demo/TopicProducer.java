package cn.itcast.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 创建生产者
 */
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("itcast_topic");
        MessageProducer producer = session.createProducer(topic);
        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setString("username","jzh");
        mapMessage.setString("password","123456");

        producer.send(mapMessage);

        producer.close();
        session.close();
        connection.close();


    }
}
