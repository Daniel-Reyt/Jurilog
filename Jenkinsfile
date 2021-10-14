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
                    echo 'stop orm ...'
                    docker-compose -f docker-compose-jenkins.yml down
                    echo 'build prod ...'
                    docker-compose -f docker-compose-jenkins.yml up -d --build
                """         
            }
        }
        post {
            success {
                script{
                    slackSend channel: '#Daniel Reyt',
                            color: 'good',
                            message: "The pipeline of branch master completed successful"
                }
            }
        }
    }
}