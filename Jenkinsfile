pipeline{
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    agent none
    stages{
        stage('Checkout'){
            agent {label 'win_slave'}
            steps{
                git 'https://github.com/devops-trainer/DevOpsClassCodes.git'
            }
        }
        stage('Compile'){
            agent {label 'win_slave'}
            steps{
                bat 'mvn compile'
            }
        }
        stage('CodeReview'){
            agent any
            steps{
                sh 'mvn pmd:pmd'
            }
            post{
                always{
                    pmd pattern: 'target/pmd.xml'
                }
            }
        }
        stage('UnitTest'){
            agent any
            steps{
                sh 'mvn test'
            }
        }
        stage('MetricCheck'){
            agent any
            steps{
                sh 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
            }
            post{
                always{
                    cobertura coberturaReportFile: 'target/site/cobertura/coverage.xml'
                }
            }
        }
        stage('Package'){
            agent any
            steps{
                sh 'mvn package'
            }
        }
    }
}
