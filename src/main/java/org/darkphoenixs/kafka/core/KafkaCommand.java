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
package org.darkphoenixs.kafka.core;

import kafka.admin.TopicCommand;

/**
 * <p>Title: KafkaCommand</p>
 * <p>Description: Kafka命令类</p>
 *
 * @since 2015-06-01
 * @author Victor.Zxy
 * @version 1.0
 */
public class KafkaCommand {

	/** 空格 */
	private static final String space = " ";

	/**
	 * <p>Title: topicCommand</p>
	 * <p>Description: 命令操作</p>
	 *
	 * @param options 命令参数
	 */
	public static void topicCommand(String... options) {

		TopicCommand.main(options);
	}

	/**
	 * <p>Title: listOptions</p>
	 * <p>Description: 查询队列列表操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 */
	public static void listOptions(String zookeeperStr) {

		StringBuffer listOptions = new StringBuffer();

		listOptions.append("--list").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr);

		TopicCommand.main(listOptions.toString().split(space));
	}
	
	/**
	 * <p>Title: createOptions</p>
	 * <p>Description: 创建队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 * @param replications 复制个数
	 * @param partitions 分区个数
	 */
	public static void createOptions(String zookeeperStr, String topic,
			int replications, int partitions) {

		StringBuffer createOptions = new StringBuffer();

		createOptions.append("--create").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--replication-factor").append(space)
				.append(replications).append(space).append("--partitions")
				.append(space).append(partitions).append(space)
				.append("--topic").append(space).append(topic);

		TopicCommand.main(createOptions.toString().split(space));
	}


	/**
	 * <p>Title: selectOptions</p>
	 * <p>Description: 查询队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 */
	public static void selectOptions(String zookeeperStr, String topic) {

		StringBuffer selectOptions = new StringBuffer();

		selectOptions.append("--describe").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--topic").append(space).append(topic);

		TopicCommand.main(selectOptions.toString().split(space));
	}

	/**
	 * <p>Title: updateOptions</p>
	 * <p>Description: 修改队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 * @param partitions 分区个数
	 */
	public static void updateOptions(String zookeeperStr, String topic,
			int partitions) {

		StringBuffer updateOptions = new StringBuffer();

		updateOptions.append("--alter").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--topic").append(space).append(topic).append(space)
				.append("--partitions").append(space).append(partitions);

		TopicCommand.main(updateOptions.toString().split(space));
	}

	/**
	 * <p>Title: updateOptions</p>
	 * <p>Description: 修改队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 * @param config 配置参数
	 */
	public static void updateOptions(String zookeeperStr, String topic,
			String... config) {

		StringBuffer updateOptions = new StringBuffer();

		updateOptions.append("--alter").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--topic").append(space).append(topic);

		for (int i = 0; i < config.length; i++) {

			if (config[i].indexOf("=") > 0)

				updateOptions.append(space).append("--config").append(space)
						.append(config[i]);
			else
				updateOptions.append(space).append("--delete-config")
						.append(space).append(config[i]);

		}

		TopicCommand.main(updateOptions.toString().split(space));

	}

	/**
	 * <p>Title: updateOptions</p>
	 * <p>Description: 修改队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 * @param partitions 分区个数
	 * @param config 配置参数
	 */
	public static void updateOptions(String zookeeperStr, String topic,
			int partitions, String... config) {

		StringBuffer updateOptions = new StringBuffer();

		updateOptions.append("--alter").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--topic").append(space).append(topic).append(space)
				.append("--partitions").append(space).append(partitions);

		for (int i = 0; i < config.length; i++) {

			if (config[i].indexOf("=") > 0)

				updateOptions.append(space).append("--config").append(space)
						.append(config[i]);
			else
				updateOptions.append(space).append("--delete-config")
						.append(space).append(config[i]);

		}

		TopicCommand.main(updateOptions.toString().split(space));
	}

	/**
	 * <p>Title: deleteOptions</p>
	 * <p>Description: 删除队列操作</p>
	 *
	 * @param zookeeperStr zookeeper地址
	 * @param topic 队列名称
	 */
	public static void deleteOptions(String zookeeperStr, String topic) {

		StringBuffer deleteOptions = new StringBuffer();

		deleteOptions.append("--delete").append(space).append("--zookeeper")
				.append(space).append(zookeeperStr).append(space)
				.append("--topic").append(space).append(topic);

		TopicCommand.main(deleteOptions.toString().split(space));

	}
}
