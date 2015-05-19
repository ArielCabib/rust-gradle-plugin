#rust-gradle-plugin
A [rust plugin](https://plugins.gradle.org/plugin/com.arielcabib.rust) for Gradle.

##How to use
###A new rust project in IntelliJ 14
* File -> New -> Project
* Choose Gradle on the as the build system
* Choose a GroupId, ArtifactId, Version
* Hit Next
* Choose a location for your project
* Add this to the beginning of build.gradle:
```Gradle
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.arielcabib:rust-gradle-plugin:0.1-SNAPSHOT"
  }
}

apply plugin: "com.arielcabib.rust"
```

* In terminal, cd to your new project root directory. Run these three lines:
```Shell
cargo new tmp --bin
mv tmp/Cargo.toml tmp/.git tmp/.gitignore tmp/src .
rmdir tmp
```

* In the IntelliJ Gradle panel, hit refresh, and you're good to go. The rustBuild and rustRun will appear under Tasks -> other

##How to contribute
###With IntelliJ 14
* Clone the repo
* File -> New -> Project from existing sources
* Navigate to the cloned repo
* Import project from external model -> Gradle
* Finish
* For some reason, the jar task wasn't working out of the box. The jar wouldn't include the compiled Groovy files, but only the META-INF. I found a workaround that solves it. Define a new empty artifact. Make it contain the 'rust-gradle-plugin' compile output, and build it. From now on, the jar task will produce a good jar.
* To compile, use the Gradle jar task.
* To test the compile output with a test project, add this to your build.gradle (in the other project):
```Gradle
buildscript {
    dependencies {
        classpath files("/.../rust-gradle-plugin/build/libs/rust-gradle-plugin-0.1-SNAPSHOT.jar")
    }
}
apply plugin: "com.arielcabib.rust"
```
