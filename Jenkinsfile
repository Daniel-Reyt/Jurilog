pipeline {
    agent any

    stages {
        stage('SCM') {
            git 'http://git.uha4point0.fr/UHA40/fil-rouge-2021/4.0.3/fil_rouge_4.0.3_daniel.git'
        }
        stage('Build') {
            steps {
                  sh """
                        npm i -g npm@6.4.1
                        npm i
                        npm run build
                    """
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}