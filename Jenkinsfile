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
                    docker-compose -f docker-compose-prod.yml up -d --build
                    docker-compose -f docker-compose-prod.yml down

                    docker image tag fil_rouge_403_daniel_angular-front danielrxt321/filrouge:fil_rouge_403_daniel_angular-front
                    docker push fil_rouge_403_daniel_angular-front danielrxt321/filrouge:fil_rouge_403_daniel_angular-front

                    docker image tag fil_rouge_403_daniel_spring-orm danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                    docker push fil_rouge_403_daniel_spring-orm danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                """         
            }
        }
    }
}
