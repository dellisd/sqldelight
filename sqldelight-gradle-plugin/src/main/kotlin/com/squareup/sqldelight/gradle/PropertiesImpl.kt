package com.squareup.sqldelight.gradle

import com.alecstrong.sql.psi.core.DialectPreset
import com.squareup.sqldelight.core.SqlDelightCompilationUnit
import com.squareup.sqldelight.core.SqlDelightDatabaseName
import com.squareup.sqldelight.core.SqlDelightDatabaseProperties
import com.squareup.sqldelight.core.SqlDelightPropertiesFile
import com.squareup.sqldelight.core.SqlDelightSourceFolder
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Nested
import java.io.File

data class SqlDelightPropertiesFileImpl(
  override val databases: List<SqlDelightDatabasePropertiesImpl>
) : SqlDelightPropertiesFile

data class SqlDelightDatabasePropertiesImpl(
  @Input override val packageName: String,
  @Nested override val compilationUnits: List<SqlDelightCompilationUnitImpl>,
  @Input override val className: String,
  @Nested override val dependencies: List<SqlDelightDatabaseNameImpl>,
  @Input override val dialectPresetName: String = DialectPreset.SQLITE_3_18.name,
  @Input override val deriveSchemaFromMigrations: Boolean = false,
  // Output directory is already cached [SqlDelightTask.outputDirectory].
  @Internal override val outputDirectoryFile: File,
  // Only useed by intellij plugin to help with resolution.
  @Internal override val rootDirectory: File
) : SqlDelightDatabaseProperties

data class SqlDelightDatabaseNameImpl(
  @Input override val packageName: String,
  @Input override val className: String
) : SqlDelightDatabaseName

data class SqlDelightCompilationUnitImpl(
  @Input override val name: String,
  @Nested override val sourceFolders: List<SqlDelightSourceFolderImpl>
) : SqlDelightCompilationUnit

data class SqlDelightSourceFolderImpl(
  // Sources are already cached [SqlDelightTask.getSources]
  @Internal override val folder: File,
  @Input override val dependency: Boolean = false
) : SqlDelightSourceFolder
