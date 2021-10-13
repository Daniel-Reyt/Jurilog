pipeline {
    agent any

    stages {
        stage('SCM') {
            git 'http://git.uha4point0.fr/UHA40/fil-rouge-2021/4.0.3/fil_rouge_4.0.3_daniel.git'
        }
        stage('build') {
            steps {
                echo 'build..'
            }
        }
        stage('test') {
            steps {
                echo 'test..'
            }
        }
        stage('deploy') {
            steps {
                echo 'deploy....'
            }
        }
    }
}