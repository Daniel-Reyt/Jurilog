pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh """
                    cd orm/
                    mvn package
                    cd ..

                    cd front/
                    npm i
                    npm run build
                """
            }
        }
        stage('Test') {
            steps {
                sh """

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