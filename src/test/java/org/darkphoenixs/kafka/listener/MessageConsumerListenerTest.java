package org.darkphoenixs.kafka.listener;


import org.darkphoenixs.kafka.consumer.MessageConsumer;
import org.darkphoenixs.mq.exception.MQException;
import org.junit.Assert;
import org.junit.Test;

public class MessageConsumerListenerTest {

	@Test
	public void test() throws Exception {
		
		MessageConsumerListener<String> listener = new MessageConsumerListener<String>();
		
		try {
			listener.onMessage("test");
		} catch (Exception e) {
			Assert.assertTrue(e instanceof MQException);
		}

		MessageConsumer<String> consumer = new MessageConsumer<String>();

		consumer.setConsumerKey("ProtocolId");
		
		Assert.assertNull(listener.getConsumer());
		listener.setConsumer(consumer);
		
		listener.onMessage("test");
	}
	
}
