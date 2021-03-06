package org.darkphoenixs.kafka.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.darkphoenixs.kafka.codec.MessageDecoderImpl;
import org.darkphoenixs.kafka.codec.MessageEncoderImpl;
import org.darkphoenixs.kafka.pool.KafkaMessageReceiverPool;
import org.darkphoenixs.kafka.pool.KafkaMessageSenderPool;
import org.darkphoenixs.mq.exception.MQException;
import org.darkphoenixs.mq.message.MessageBeanImpl;
import org.junit.Assert;
import org.junit.Test;

public class KafkaMessageTemplateTest {

	
	@Test
	public void test() throws Exception {

		KafkaMessageTemplate<MessageBeanImpl> template = new KafkaMessageTemplate<MessageBeanImpl>();

		Assert.assertNull(template.getDecoder());
		template.setDecoder(new MessageDecoderImpl());

		Assert.assertNull(template.getEncoder());
		template.setEncoder(new MessageEncoderImpl());

		Assert.assertNull(template.getMessageSenderPool());
		template.setMessageSenderPool(new KafkaMessageSenderPoolImpl());

		MessageBeanImpl messageBean = new MessageBeanImpl();
		long date = System.currentTimeMillis();
		messageBean.setMessageNo("MessageNo");
		messageBean.setMessageType("MessageType");
		messageBean.setMessageAckNo("MessageAckNo");
		messageBean.setMessageDate(date);
		messageBean.setMessageContent("MessageContent".getBytes("UTF-8"));

		template.convertAndSend(new KafkaDestination("QUEUE.TEST"), messageBean);

		Assert.assertNull(template.getMessageReceiverPool());
		template.setMessageReceiverPool(new KafkaMessageReceiverPoolImpl());

		template.receiveAndConvert(new KafkaDestination("QUEUE.TEST"), 1, 0, 1);

	}

	private class KafkaMessageSenderPoolImpl extends
			KafkaMessageSenderPool<byte[], byte[]> {

		@Override
		public KafkaMessageSender<byte[], byte[]> getSender(long waitTimeMillis) {

			return new KafkaMessageSender<byte[], byte[]>() {

				@Override
				public void shutDown() {

					System.out.println("shutDown");
				}

				@Override
				public void sendWithKey(String topic, byte[] key, byte[] value) {

					System.out.println("sendWithKey" + topic);
				}

				@Override
				public void send(String topic, byte[] value) {

					System.out.println("send" + topic);
				}

				@Override
				public void close() {

					System.out.println("close");
				}
			};
		}
	}

	private class KafkaMessageReceiverPoolImpl extends
			KafkaMessageReceiverPool<byte[], byte[]> {

		@Override
		public KafkaMessageReceiver<byte[], byte[]> getReceiver() {

			return new KafkaMessageReceiver<byte[], byte[]>() {

				@Override
				public Map<byte[], byte[]> receiveWithKey(String topic,
						int partition, long beginOffset, long readOffset) {

					System.out.println("receiveWithKey" + topic);

					return null;
				}

				@Override
				public List<byte[]> receive(String topic, int partition,
						long beginOffset, long readOffset) {

					System.out.println("receive" + topic);

					MessageBeanImpl messageBean = new MessageBeanImpl();
					
					try {
						return Arrays.asList(new MessageEncoderImpl().encode(messageBean));
					} catch (MQException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return null;
				}

				@Override
				public long getLatestOffset(String topic, int partition) {

					System.out.println("getLatestOffset" + topic);

					return 0;
				}

				@Override
				public long getEarliestOffset(String topic, int partition) {

					System.out.println("getEarliestOffset" + topic);

					return 0;
				}

				@Override
				public void close() {

					System.out.println("close");
				}
			};
		}

	}
}
