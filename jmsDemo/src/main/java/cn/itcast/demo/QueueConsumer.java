package cn.itcast.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *创建消费者
 */
public class QueueConsumer {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.128:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("itcast63_queue");
        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage receive = (TextMessage) consumer.receive();
        System.out.println(receive.getText());
        consumer.close();
        session.close();
        connection.close();
    }

}
