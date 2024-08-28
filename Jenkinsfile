pipeline {
    agent any

    parameters {
        string(name: 'TEST_ENV_URL', defaultValue: 'https://www.amazon.com', description: 'Test environment URL')
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Browser for testing')
    }

    tools {
        // Use 'maven' instead of a specific version
        maven 'maven'
        // Use 'jdk' instead of a specific version
        jdk 'jdk'
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
            emailext (
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
            )
        }
    }
}
