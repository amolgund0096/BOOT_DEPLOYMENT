pipeline {
    agent any

    tools {
        jdk 'JDK 8'              // Matches the name from Jenkins tool config
        maven 'Maven 3.9.10'     // Matches your Maven config
    }

    environment {
        APP_NAME = 'springboot-app'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/amolgund0096/BOOT_DEPLOYMENT.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Run Spring Boot') {
            steps {
                echo "Launching Spring Boot App..."
                sh 'nohup java -jar target/*.jar > log.txt 2>&1 &'
            }
        }
    }

    post {
        success {
            echo '✅ Build and run successful!'
        }
        failure {
            echo '❌ Build failed. Check logs.'
        }
    }
}
