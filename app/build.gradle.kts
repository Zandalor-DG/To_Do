plugins {
  alias(libs.plugins.convention.android.app)
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
}

dependencies {
  // UIComponents
  api(libs.androidx.navigation.compose)
  api(libs.androidx.core.ktx)
  api(platform(libs.androidx.compose.bom))
  api(libs.androidx.compose.ui)
  api(libs.androidx.compose.ui.graphics)
  api(libs.androidx.compose.ui.tooling.preview)
  api(libs.androidx.compose.material3)

  // Hilt
  api(libs.hilt.navigation.compose)

  // Javax
  api(libs.javax.inject)

  // Tests
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.androidx.test.espresso.core)
  debugImplementation(libs.androidx.compose.ui.tooling)
  debugImplementation(libs.androidx.compose.ui.test.manifest)

  // Annotations
  api(libs.androidx.annotation)
  compileOnly(libs.findbugs.jsr305)
}