pipeline {
    agent any

    triggers {
        upstream(upstreamProjects: "/eztrade/eztrade-parent/${env.BRANCH_NAME}", threshold: hudson.model.Result.UNSTABLE)
    }

    tools {
        jdk 'JDK 1.8'
        maven 'Maven 3.5.0'
    }

    stages {
        stage('Maven build') {
            steps {
                sh 'mvn -B -V -U clean install'
            }
        }
    }
}