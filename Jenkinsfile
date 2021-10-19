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
                    ng test -- --watch=false
                """            
            }
        }
        
        stage('Deploy') {
            steps { 
                sh """

                """         
            }
        }
    }
}
