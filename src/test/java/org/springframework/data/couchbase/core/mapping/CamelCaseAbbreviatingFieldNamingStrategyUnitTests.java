/*
 * Copyright 2014 the original author or authors.
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
package org.springframework.data.couchbase.core.mapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link CamelCaseAbbreviatingFieldNamingStrategy}.
 *
 * @author Oliver Gierke
 * @author Michael Nitschinger
 * @since 1.1
 */
@RunWith(MockitoJUnitRunner.class)
public class CamelCaseAbbreviatingFieldNamingStrategyUnitTests {

  FieldNamingStrategy strategy = new CamelCaseAbbreviatingFieldNamingStrategy();

  @Mock
  CouchbasePersistentProperty property;

  @Test
  public void shouldConvertPropertyNames() {
    assertFieldNameForPropertyName("fooBar", "fb");
    assertFieldNameForPropertyName("fooBARFooBar", "fbfb");
  }

  private void assertFieldNameForPropertyName(final String propertyName, final String fieldName) {
    when(property.getName()).thenReturn(propertyName);
    assertThat(strategy.getFieldName(property), is(fieldName));
  }

}
