/*
 * Copyright (C) 2016 Square, Inc.
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
package com.squareup.sqlite.android.lang

import com.squareup.sqlite.android.SQLiteParser
import org.antlr.intellij.adaptor.lexer.ElementTypeFactory
import java.util.Arrays

object SqliteTokenTypes {
  val TOKEN_ELEMENT_TYPES = ElementTypeFactory.getTokenElementTypes(SqliteLanguage.INSTANCE,
      Arrays.asList(*SQLiteParser.tokenNames))
  val RULE_ELEMENT_TYPES = ElementTypeFactory.getRuleElementTypes(SqliteLanguage.INSTANCE,
      Arrays.asList(*SQLiteParser.ruleNames))
}