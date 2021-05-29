pipeline {
    agent any

    tools {
        jdk  "MyJava"
        maven "mymaven"
    }

    stages {
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('CodeReview') {
            steps {
                sh 'mvn pmd:pmd'
            }
        }
        stage('UnitTest') {
            steps {
                sh 'mvn test'
            }
        }
        stage('MetricCheck') {
            steps {
                sh 'mvn cobertura:cobertura -cobertura.report.output=xml'
            }
        }
        stage('MetricCheck') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
