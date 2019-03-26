package cn.itcast.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicConsumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("itcast_topic");
        MessageConsumer consumer = session.createConsumer(topic);
        // 监听消息
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                MapMessage mapMessage = (MapMessage)message;
                try {
                    String username = mapMessage.getString("username");
                    System.out.println(username);
                    String password = mapMessage.getString("password");
                    System.out.println(password);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 需要一直开着监听器 所以用循环  当监听到生产者 生产消息  这边就会消费消息
        while (true){}



    }

}
