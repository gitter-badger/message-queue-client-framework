/*
 * Copyright 2015-2016 Dark Phoenixs (Open-Source Organization).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.darkphoenixs.mq.factory;

import org.darkphoenixs.mq.consumer.Consumer;
import org.darkphoenixs.mq.exception.MQException;

/**
 * <p>Title: ConsumerFactory</p>
 * <p>Description: 消费者工厂接口</p>
 *
 * @since 2015-06-01
 * @author Victor.Zxy
 * @version 1.0
 */
public interface ConsumerFactory {

	/**
	 * <p>Title: addConsumer</p>
	 * <p>Description: 增加消费者</p>
	 *
	 * @param consumer 消费者
	 * @throws MQException MQ异常
	 */
	public <T> void addConsumer(Consumer<T> consumer) throws MQException;

	/**
	 * <p>Title: getConsumer</p>
	 * <p>Description: 获得消费者</p>
	 *
	 * @param consumerKey 消费者标识
	 * @return 消费者
	 * @throws MQException MQ异常
	 */
	public <T> Consumer<T> getConsumer(String consumerKey) throws MQException;

	/**
	 * <p>Title: init</p>
	 * <p>Description: 初始化工厂</p>
	 *
	 * @throws MQException MQ异常
	 */
	public void init() throws MQException;
	
	/**
	 * <p>Title: destroy</p>
	 * <p>Description: 销毁工厂</p>
	 * 
	 * @throws MQException MQ异常
	 */
	public void destroy() throws MQException;

}
