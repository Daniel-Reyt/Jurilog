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
                    docker-compose -f docker-compose-jenkins.yml up --build
                    echo unpYxpRYL8YvfP | ssh nissan@10.3.1.30 'sudo su'
                    echo unpYxpRYL8YvfP | ssh nissan@10.3.1.30 'cd daniel/fil_rouge_403_daniel/ && docker-compose -f docker-compose-prod.yml down && git pull origin-gitlab master && docker-compose -f docker-compose-prod.yml up -d'
                """         
            }
        }
    }
}
