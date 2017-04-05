pipeline {
    agent any

    tools {
        jdk 'JDK 1.8'
        maven 'Maven 3.3.9'
    }

    stages {
        stage('Maven build') {
            steps {
                sh 'mvn -B -V -U clean install'
            }
        }
    }

    post {
        success {
            build job: "/eztrade/eztrade-equities-service/${env.BRANCH_NAME}", wait: false
            build job: "/eztrade/eztrade-forex-service/${env.BRANCH_NAME}", wait: false
        }
    }
}