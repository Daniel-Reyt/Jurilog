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
                    docker-compose -f docker-compose-prod.yml up --build
                """
            }
        }
        stage('Test') {
            steps {
                sh """
                    cd front/
                    ng test -- --watch=false
                """            
            }
        }
        stage('Deploy') {
            steps { 
                sh """
                    docker-compose -f docker-compose-prod.yml down 
                """         
            }
        }
    }
}