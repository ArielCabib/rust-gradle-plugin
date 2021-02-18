package com.arielcabib.plugin.gradle.rust

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Exec

/**
 * Created by ariel on 17/05/15.
 */
class RustPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.tasks.create('rustBuild', Exec).configure {
             commandLine 'cargo', 'build'
        }

        project.tasks.create('rustRun', Exec).configure {
            standardInput System.in
            commandLine 'cargo', 'run'
        }

        project.tasks.create('rustUpdate', Exec).configure {
             commandLine 'cargo', 'update'
        }
    }
}
