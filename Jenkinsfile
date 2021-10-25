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
                    docker run -p 8989:8989 -d --name spring danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm

                    cd front/
                    ng test -- --watch=false

                    docker stop spring
                """            
            }
        }
        
        stage('Deploy') {
            steps { 
                sh """
                    cd front/
                    docker build -f prod.Dockerfile .

                    cd ..
                    cd orm/
                    docker build -f prod.Dockerfile .

                    docker login -u "danielrxt321" -p "dadareyt32" docker.io

                    docker image tag fil_rouge_403_daniel_angular-front danielrxt321/filrouge:fil_rouge_403_daniel_angular-front
                    docker push danielrxt321/filrouge:fil_rouge_403_daniel_angular-front

                    docker image tag fil_rouge_403_daniel_spring-orm danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                    docker push danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                """         
            }
        }
    }
}
