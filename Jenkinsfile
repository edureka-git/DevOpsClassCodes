pipeline{
    tools{
        jdk 'myjava'
        maven 'mymaven'
    }
    
    agent none
    stages{
            stage('Compile'){
                agent any
                steps{
                    sh 'mvn compile'
                }
            }
            stage('CodeReview'){
                agent any
                steps{
                    sh 'mvn pmd:pmd'
                }
            }
            stage('UnitTest'){
                agent any
                steps{
                    sh 'mvn test'
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
