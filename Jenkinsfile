@Library('threepoints_sharedlib@main') _

pipeline {
    agent any
    stages {
        stage('Inicio') {
            steps {
                echo 'Iniciando Pipeline...'
            }
        }
        stage('Análisis estático') {
            steps {
                staticAnalysis(true)
            }
        }
        stage('Finalizar') {
            steps {
                echo 'Pipeline completado con éxito.'
            }
        }
    }
}
