pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
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
                    
                    cd ..
                    docker-compose -f docker-compose-prod.yml down --remove-orphans
                    docker-compose -f docker-compose-jenkins.yml up -d --build --remove-orphans
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
                    docker-compose -f docker-compose-jenkins.yml down
                    docker-compose -f docker-compose-prod.yml up --build
                """         
            }
        }
    }
}
