import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.Project
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.finishBuildTrigger
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object SpringPetclinic : Project({
    vcsRoot(PetclinicVcs)

    sequence {
        build(Build) {
            produces("target/spring-petclinic-*.jar => spring-petclinic.zip")
        }
        build(Upload){
            requires(Build, "spring-petclinic.zip")
        }
    }
})

object Build : BuildType({
    name = "Build"

    vcs {
        root(PetclinicVcs)
    }

    steps {
        maven {
            goals = "clean package"
            dockerImage = "maven:3.6.0-jdk-8"
        }
    }
})

object Upload : BuildType({
    name = "Upload"

    steps {
        step {
            type = "ftp-deploy-runner"
            param("jetbrains.buildServer.deployer.ftp.authMethod", "ANONYMOUS")
            param("jetbrains.buildServer.deployer.ftp.transferMethod", "AUTO")
            param("jetbrains.buildServer.deployer.sourcePath", "spring-petclinic.zip")
            param("jetbrains.buildServer.deployer.targetUrl", "some.host.com")
            param("jetbrains.buildServer.deployer.ftp.securityMode", "0")
        }
    }

    triggers {
        finishBuildTrigger {
            buildType = "${Build.id}"
        }
    }
})

object PetclinicVcs : GitVcsRoot({
    name = "PetclinicVcs"
    url = "https://github.com/spring-projects/spring-petclinic.git"
})