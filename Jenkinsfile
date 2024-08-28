pipeline {
    agent any

    parameters {
        string(name: 'TEST_ENV_URL', defaultValue: 'https://www.amazon.com', description: 'Test environment URL')
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Browser for testing')
    }

    tools {
        maven 'maven'
        jdk '21.0.4'  // Make sure this matches the name you gave in Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh "mvn test -DTEST_ENV_URL=${params.TEST_ENV_URL} -DBROWSER=${params.BROWSER}"
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        failure {
            echo "Build failed. Email notification would be sent here."
        }
    }
}
