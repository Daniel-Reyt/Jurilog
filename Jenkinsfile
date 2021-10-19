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
                    docker-compose -f docker-compose-jenkins.yml up -d --build
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

                    ssh stukaboy@10.3.1.55
                    uha40 
                    docker stop danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                    docker stop danielrxt321/filrouge:fil_rouge_403_daniel_angular-front
                """         
            }
        }
    }
}
