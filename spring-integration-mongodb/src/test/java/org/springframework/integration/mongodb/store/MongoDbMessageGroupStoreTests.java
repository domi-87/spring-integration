/*
 * Copyright 2007-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.mongodb.store;

import org.junit.Test;

import org.springframework.integration.mongodb.rules.MongoDbAvailable;
import org.springframework.integration.store.MessageStore;

/**
 * @author Oleg Zhurakousky
 * @author Gary Russell
 * @author Artem Bilan
 *
 */
public class MongoDbMessageGroupStoreTests extends AbstractMongoDbMessageGroupStoreTests {

	@Override
	protected MongoDbMessageStore getMessageGroupStore() {
		MongoDbMessageStore mongoDbMessageStore =
				new MongoDbMessageStore(this.clientDbFactory);
		mongoDbMessageStore.afterPropertiesSet();
		return mongoDbMessageStore;
	}

	@Override
	protected MessageStore getMessageStore() {
		return getMessageGroupStore();
	}

	@Test
	@MongoDbAvailable
	public void testWithAggregatorWithShutdown() {
		super.testWithAggregatorWithShutdown("mongo-aggregator-config.xml");
	}

}
