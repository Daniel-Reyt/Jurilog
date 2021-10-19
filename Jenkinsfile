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
                    echo test
                """            
            }
        }
        
        stage('Deploy') {
            steps { 
                sh """
                    ssh stukaboy@10.3.1.55
                    uha40 
                    docker stop danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                    docker stop danielrxt321/filrouge:fil_rouge_403_daniel_angular-front
                    docker run -p danielrxt321/filrouge:fil_rouge_403_daniel_spring-orm
                    docker run -p 80:80 danielrxt321/filrouge:fil_rouge_403_daniel_angular-front
                """         
            }
        }
    }
}
