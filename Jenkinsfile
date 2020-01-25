pipeline{
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    agent any
    stages{
        stage('checkout'){
            steps{
                git 'https://github.com/devops-trainer/DevOpsClassCodes.git'
            }
        }
        stage('Compile'){
            steps{
                sh 'mvn compile'
            }
        }
        stage('CodeReview'){
            steps{
                sh 'mvn pmd:pmd'
            }
            post{
                always{
                    pmd pattern: 'target/pmd.xml'
                }
            }
        }
        stage('Unittest'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Metric Check'){
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
            steps{
                sh 'mvn package'
            }
        }
    }
}
