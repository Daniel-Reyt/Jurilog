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
                    cd orm/
                    mvn spring-boot:run


                    cd ..
                    cd front/
                    ng test -- --watch=false
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