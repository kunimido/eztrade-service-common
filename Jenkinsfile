pipeline {
    agent any

    tools {
        jdk 'JDK 1.8'
        maven 'Maven 3.3.9'
    }

    stages {
        stage('Maven build') {
            steps {
                sh 'mvn -B clean install'
            }
        }
    }

    post {
        success {
            build "/eztrade/eztrade-equities-service/${env.BRANCH_NAME}"
            build "/eztrade/eztrade-forex-service/${env.BRANCH_NAME}"
        }
    }
}