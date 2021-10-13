pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh """
                    cd front/
                    npm i
                    npm run build
                """
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}