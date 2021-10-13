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
                sh """
                    cd orm/
                    mvn spring-boot:run

                    cd front/
                    npm i
                    npm run test
                """            
                }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}