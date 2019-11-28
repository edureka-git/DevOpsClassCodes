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
          stage('Package'){
              steps{
                  sh 'mvn package'
              }
          }
      }
}
