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
            build '/eztrade/eztrade-equities-service/${BRANCH_NAME}'
            build '/eztrade/eztrade-forex-service/${BRANCH_NAME}'
        }
    }
}