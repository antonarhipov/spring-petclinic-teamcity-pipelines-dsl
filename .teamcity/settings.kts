import jetbrains.buildServer.configs.kotlin.v2018_2.*

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.2"

project(SpringPetclinic)

// MOVED THE CONFIGURATION OBJECTS TO settings/SpringPetclinic.kt
// The code below is _still_ here for demo purpose
//
//object SpringPetclinic : Project({
//    vcsRoot(PetclinicVcs)
//
//    sequence {
//        build(Build) {
//            produces("target/spring-petclinic-*.jar => spring-petclinic.zip")
//        }
//        build(Upload){
//            requires(Build, "spring-petclinic.zip")
//        }
//    }
//})
//
//object Build : BuildType({
//    name = "Build"
//
//    vcs {
//        root(PetclinicVcs)
//    }
//
//    steps {
//        maven {
//            goals = "clean package"
//            dockerImage = "maven:3.6.0-jdk-8"
//        }
//    }
//})
//
//object Upload : BuildType({
//    name = "Upload"
//
//    steps {
//        step {
//            type = "ftp-deploy-runner"
//            param("jetbrains.buildServer.deployer.ftp.authMethod", "ANONYMOUS")
//            param("jetbrains.buildServer.deployer.ftp.transferMethod", "AUTO")
//            param("jetbrains.buildServer.deployer.sourcePath", "spring-petclinic.zip")
//            param("jetbrains.buildServer.deployer.targetUrl", "some.host.com")
//            param("jetbrains.buildServer.deployer.ftp.securityMode", "0")
//        }
//    }
//
//    triggers {
//        finishBuildTrigger {
//            buildType = "${Build.id}"
//        }
//    }
//})
//
//object PetclinicVcs : GitVcsRoot({
//    name = "PetclinicVcs"
//    url = "https://github.com/spring-projects/spring-petclinic.git"
//})

//
//fun wrapWithFeature(buildType: BuildType, featureBlock: BuildFeatures.() -> Unit): BuildType {
//    buildType.features {
//        featureBlock()
//    }
//    return buildType
//}