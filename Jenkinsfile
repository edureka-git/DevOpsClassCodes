pipeline{
     agent any
      stages{
          stage('SourceCode'){
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
          }
           stage('UnitTest'){
              steps{
                  sh 'mvn test'
              }
          }
           stage('MetricCheck'){
              steps{
                  sh 'mvn coberrura:cobertura -Dcobertura.report.format=xml'
              }
          }
          stage('Package'){
              steps{
                  sh 'mvn package'
              }
          }
      }
}
