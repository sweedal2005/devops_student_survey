pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/YOUR_USERNAME/student-survey.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t student-survey-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8081:8080 student-survey-app'
            }
        }
    }

    post {
        success {
            mail to: 'youremail@gmail.com',
            subject: "Build SUCCESS - Student Survey App",
            body: "Your Jenkins pipeline executed successfully and app is deployed!"
        }

        failure {
            mail to: 'youremail@gmail.com',
            subject: "Build FAILED - Student Survey App",
            body: "Check Jenkins logs. Build failed."
        }
    }
}