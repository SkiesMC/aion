[releases-page]: https://github.com/SkiesMC/aion/releases "GitHub Releases"

# Aion

Foundation plugin for SkiesMC Paper's plugin projects.

Aion plugin provides a set of utilities and tools to help developers create plugins for SkiesMC.

**Notes:** The core of this plugin maybe not compatible with plugins made with Java. To ensure compatibility, please use
Kotlin.

## Installation

> [!IMPORTANT]
> Requires Java 21 (or higher) and Paper 1.21 (or higher).

1. Download the latest version of the plugin from the [releases page][releases-page].
2. Place the downloaded JAR file in the `plugins` folder of your server.
3. Start the server.

## Available features

* **Kotlin support**:
    * Provides Kotlin runtime and standard library.
    * Supports Kotlin Coroutines via MC Coroutine.
    * Enforces Kotlin dependencies versions for other plugins.
    * Provides Kotlin extensions for some Bukkit & Paper classes.
* **Folia compatibility:**
    * Plugin is designed to work with Folia.
* **Suspending plugin lifecycle**:
    * Allows suspending in loading, enabling, disabling method.
* **Suspending listeners**:
    * Allows suspending event listeners.
    * Provides a way to listen to events in a suspending way.
* **Bukkit persistence API**:
    * Adds Key, UUID data types.
    * Extensions for setting and getting data.

## API setup

> [!NOTE]
> Do not shade the Aion API into your plugin. Use the provided dependency with standalone plugin instead.

### Gradle Kotlin DSL

Add this section to your `repositories` block in your `build.gradle.kts` file:

```kotlin
maven("https://maven.pkg.github.com/SkiesMC/aion") {
    credentials {
        username = providers.gradleProperty("github.actor").getOrElse(System.getenv("GITHUB_ACTOR"))
        password = providers.gradleProperty("github.token").getOrElse(System.getenv("GITHUB_TOKEN"))
    }
}
```

Next, add this to your `dependencies` block:

```kotlin
compileOnly("io.skiesmc.aion:aion-core:0.2.0")
```

<details>
<summary>Version catalog</summary>

Add this to your `versions` block in your `gradle/libs.versions.toml` file:

```toml
aion = "0.2.0"
```

Next, add this to your `libraries` block in your `gradle/libs.versions.toml` file:

```toml
aion-core = { module = "io.skiesmc.aion:aion-core", version.ref = "aion" }
```

Finally, add this to your `dependencies` block in your `build.gradle.kts` file:

```kotlin
compileOnly(libs.aion.core)
```

</details>
